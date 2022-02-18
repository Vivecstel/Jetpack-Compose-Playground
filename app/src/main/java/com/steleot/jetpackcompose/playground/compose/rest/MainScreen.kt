package com.steleot.jetpackcompose.playground.compose.rest

import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import com.google.accompanist.insets.systemBarsPadding
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.customexamples.AdViewExample
import com.steleot.jetpackcompose.playground.compose.reusable.*
import com.steleot.jetpackcompose.playground.localproviders.LocalFavoriteHelper
import com.steleot.jetpackcompose.playground.localproviders.LocalIsDarkTheme
import com.steleot.jetpackcompose.playground.localproviders.LocalNavController
import com.steleot.jetpackcompose.playground.localproviders.LocalUser
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes
import com.steleot.jetpackcompose.playground.utils.GoogleSignContract
import com.steleot.jetpackcompose.playground.utils.sendFeedback
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import timber.log.Timber

// todo refactor file
val routes = listOf(
    MainNavRoutes.Activity,
    MainNavRoutes.Animation,
    MainNavRoutes.ConstraintLayout,
    MainNavRoutes.CustomExamples,
    MainNavRoutes.ExternalLibraries,
    MainNavRoutes.Foundation,
    MainNavRoutes.Material,
    MainNavRoutes.Material3,
    MainNavRoutes.MaterialIcons,
    MainNavRoutes.MaterialIConsExtended,
    MainNavRoutes.Navigation,
    MainNavRoutes.Paging,
    MainNavRoutes.Runtime,
    MainNavRoutes.Ui,
    MainNavRoutes.ViewModel,
)

private val drawerItems = listOf(
    DrawerListItemData.DividerData,
    DrawerListItemData.MenuData(
        route = MainNavRoutes.Favorites,
        textRes = R.string.favorites,
        imageVector = Icons.Filled.Favorite,
    ),
    DrawerListItemData.MenuData(
        route = MainNavRoutes.Popular,
        textRes = R.string.popular,
        imageVector = Icons.Filled.ThumbUp,
    ),
    DrawerListItemData.DividerData,
    DrawerListItemData.MenuData(
        route = MainNavRoutes.Discover,
        textRes = R.string.discover,
        imageVector = Icons.Filled.Extension,
    ),
    DrawerListItemData.MenuData(
        route = MainNavRoutes.New,
        textRes = R.string.new_screen,
        imageVector = Icons.Filled.Lightbulb,
    ),
    DrawerListItemData.DividerData,
    DrawerListItemData.MenuData(
        route = MainNavRoutes.Articles,
        textRes = R.string.articles,
        imageVector = Icons.Filled.Article,
        menuAction = MenuAction.TOAST
    ),
    DrawerListItemData.DividerData,
    DrawerListItemData.MenuData(
        route = null,
        textRes = R.string.send_feedback,
        imageVector = Icons.Filled.Feedback,
        MenuAction.FEEDBACK
    ),
    DrawerListItemData.MenuData(
        route = null,
        textRes = R.string.privacy_policy,
        imageVector = Icons.Filled.PrivacyTip,
        menuAction = MenuAction.PRIVACY_POLICY
    ),
    DrawerListItemData.DividerData,
    DrawerListItemData.MenuData(
        route = MainNavRoutes.Settings,
        textRes = R.string.settings,
        imageVector = Icons.Filled.Settings,
    ),
    DrawerListItemData.MenuData(
        route = MainNavRoutes.ReleaseNotes,
        textRes = R.string.release_notes,
        imageVector = Icons.Filled.NewReleases,
    ),
)

private const val PrivacyPolicyUrl = "https://jetpack-compose-play.flycricket.io/privacy.html"

@Composable
fun MainScreenWithDrawer(
    firebaseAuth: FirebaseAuth,
    googleSignInClient: GoogleSignInClient,
    title: String = stringResource(id = R.string.app_name),
    list: List<String> = routes,
    showAd: Boolean = true,
    setUser: (FirebaseUser?) -> Unit
) {
    val state = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    var errorDialogText by remember { mutableStateOf("") }
    var showingErrorDialog by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val uriHandler = LocalUriHandler.current
    val user = LocalUser.current
    val favoriteHelper = LocalFavoriteHelper.current
    val navController = LocalNavController.current
    val launcher =
        rememberLauncherForActivityResult(GoogleSignContract(googleSignInClient)) { idToken ->
            scope.launch {
                try {
                    val credential = GoogleAuthProvider.getCredential(idToken, null)
                    val result = firebaseAuth.signInWithCredential(credential).await()
                    Timber.d("Successful login.")
                    setUser(result.user)
                } catch (e: Exception) {
                    Timber.e(e, "Failed to sign in with Google.")
                    errorDialogText = context.getString(R.string.failed_google_sign_in)
                    showingErrorDialog = true
                }
            }
        }

    if (showingErrorDialog) {
        ErrorAlertDialog(errorDialogText) {
            showingErrorDialog = false
        }
    }

    Scaffold(
        scaffoldState = state,
        modifier = Modifier.systemBarsPadding(),
        topBar = {
            MenuTopAppBar(
                title = title,
                openDrawer = {
                    scope.launch {
                        state.drawerState.open()
                    }
                },
            )
        },
        drawerBackgroundColor = MaterialTheme.colors.primary,
        drawerContent = {
            DrawerUserItem(
                user = LocalUser.current,
                signInOnClick = {
                    launcher.launch(null)
                },
                signOutOnClick = {
                    firebaseAuth.signOut()
                    scope.launch {
                        try {
                            googleSignInClient.signOut().await()
                        } catch (e: Exception) {
                            Timber.e(e, "Failed to google sign out.")
                        }
                    }
                    favoriteHelper.clearAll()
                    setUser(null)
                }
            )
            drawerItems.forEach {
                when (it) {
                    is DrawerListItemData.DividerData -> Divider()
                    is DrawerListItemData.MenuData -> {
                        DrawerListItem(it.textRes, icon = {
                            Icon(
                                it.imageVector,
                                contentDescription = null
                            )
                        }) {
                            scope.launch {
                                state.drawerState.close()
                                when (it.menuAction) {
                                    MenuAction.NAVIGATION -> {
                                        if (user == null
                                            && it.route in listOf(
                                                MainNavRoutes.Popular,
                                                MainNavRoutes.Favorites
                                            )
                                        ) {
                                            errorDialogText = context.getString(
                                                R.string.mandatory_sign_in,
                                                context.getString(it.textRes)
                                            )
                                            showingErrorDialog = true
                                            return@launch
                                        }
                                        it.route?.let { route ->
                                            navController.navigate(
                                                if (route == MainNavRoutes.Favorites) "$route/${user!!.uid}"
                                                else route
                                            )
                                        }
                                    }
                                    MenuAction.TOAST -> Toast.makeText(
                                        context,
                                        R.string.coming_soon,
                                        Toast.LENGTH_LONG
                                    ).show()
                                    MenuAction.FEEDBACK -> context.sendFeedback()
                                    MenuAction.PRIVACY_POLICY -> uriHandler.openUri(PrivacyPolicyUrl)
                                }
                            }
                        }
                    }
                }
            }
        }
    ) {
        MainScreenContent(it, list, showAd)
    }
}

@Composable
private fun ErrorAlertDialog(
    text: String,
    closeAction: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = { },
        title = {
            Text(text = stringResource(id = R.string.app_name))
        },
        text = {
            Text(text = text)
        },
        buttons = {
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = android.R.string.ok),
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable(onClick = closeAction)
                )
            }
        },
    )
}

@Composable
private fun DrawerUserItem(
    user: FirebaseUser?,
    signInOnClick: () -> Unit,
    signOutOnClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .height(100.dp)
            .padding(16.dp)
    ) {
        if (user != null) {
            SignedInUser(user, signOutOnClick)
        } else {
            GoogleSignInButton(LocalIsDarkTheme.current, signInOnClick)
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
private fun BoxScope.SignedInUser(
    user: FirebaseUser,
    signOutOnClick: () -> Unit,
) {
    Row(
        modifier = Modifier.align(Alignment.Center)
    ) {
        AsyncImage(
            model = user.photoUrl,
            contentDescription = stringResource(id = R.string.user_photo),
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
        )
        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .align(Alignment.CenterVertically)
                .weight(1f)
        ) {
            Text(
                user.displayName ?: stringResource(id = R.string.name_not_found),
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Bold,
            )
            Text(
                user.email ?: stringResource(id = R.string.email_not_found),
                style = MaterialTheme.typography.body2,
            )
        }
        TextButton(
            onClick = signOutOnClick,
            colors = ButtonDefaults.textButtonColors(
                contentColor = MaterialTheme.colors.onSurface
            ),
            modifier = Modifier
                .align(Alignment.CenterVertically),
            border = BorderStroke(1.dp, MaterialTheme.colors.onSurface)
        ) {
            Text(
                text = stringResource(id = R.string.sign_out),
            )
        }
    }
}

@Composable
private fun BoxScope.GoogleSignInButton(
    isDarkTheme: Boolean = true,
    signInOnClick: () -> Unit = { },
) {
    Button(
        onClick = signInOnClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (isDarkTheme) Color(0xFF4285F4.toInt()) else Color(
                0xFFFFFFFF.toInt()
            )
        ),
        modifier = Modifier.align(Alignment.Center),
        shape = RoundedCornerShape(1.dp),
        contentPadding = PaddingValues(1.dp)
    ) {
        Row {
            Icon(
                painter = painterResource(
                    id = R.drawable.ic_google_icon
                ),
                contentDescription = stringResource(id = R.string.google_icon),
                tint = Color.Unspecified,
                modifier = Modifier
                    .background(
                        if (isDarkTheme) Color(0xFFFFFFFF.toInt()) else Color.Unspecified,
                        RoundedCornerShape(1.dp)
                    )
                    .padding(8.dp)
            )
            Text(
                text = stringResource(id = R.string.google_sign_in),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 16.dp, end = 8.dp)
            )
        }
    }
}

@Composable
fun MainScreen(
    title: String = stringResource(id = R.string.app_name),
    list: List<String> = routes,
    showAd: Boolean = true,
) {
    Scaffold(
        modifier = Modifier.systemBarsPadding(),
        topBar = {
            DefaultTopAppBar(title = title, shouldAllowSearch = true)
        },
    ) {
        MainScreenContent(it, list, showAd)
    }
}

@Composable
fun MainScreenContent(
    paddingValues: PaddingValues,
    list: List<String>,
    showAd: Boolean = true,
) {
    val navController = LocalNavController.current
    val routesWithRibbons = remember {
        list.map { route ->
            route to (route in ribbonRoutes)
        }
    }
    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
    ) {
        items(routesWithRibbons) { (route, shouldShowRibbon) ->
            key(route) {
                DefaultCardListItem(
                    text = route,
                    hasRibbon = shouldShowRibbon
                ) {
                    navController.navigate(route)
                }
            }
        }
        item("adMob") {
            if (showAd) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .requiredHeight(55.dp),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    AdViewExample(R.string.main_screen_banner_id)
                }
            }
        }
    }
}

sealed class DrawerListItemData {

    class MenuData(
        val route: String?,
        @StringRes val textRes: Int,
        val imageVector: ImageVector,
        val menuAction: MenuAction = MenuAction.NAVIGATION
    ) : DrawerListItemData()

    object DividerData : DrawerListItemData()
}

enum class MenuAction {
    NAVIGATION, TOAST, FEEDBACK, PRIVACY_POLICY
}

@Composable
private fun DrawerListItem(
    @StringRes textRes: Int,
    icon: @Composable (() -> Unit)? = null,
    onClick: () -> Unit
) {
    DefaultListItem(
        text = AnnotatedString(stringResource(id = textRes)),
        modifier = Modifier.clickable(onClick = onClick),
        icon = icon
    )
}
