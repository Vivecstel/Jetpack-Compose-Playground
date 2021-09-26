package com.steleot.jetpackcompose.playground.compose.rest

import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.google.accompanist.insets.systemBarsPadding
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.steleot.jetpackcompose.playground.LocalIsDarkTheme
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.customexamples.AdViewExample
import com.steleot.jetpackcompose.playground.compose.reusable.*
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes
import com.steleot.jetpackcompose.playground.utils.GoogleSignContract
import com.steleot.jetpackcompose.playground.utils.capitalizeFirstLetter
import com.steleot.jetpackcompose.playground.utils.sendFeedback
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import timber.log.Timber

private val routes = listOf(
    MainNavRoutes.Activity,
    MainNavRoutes.Animation,
    MainNavRoutes.ConstraintLayout,
    MainNavRoutes.CustomExamples,
    MainNavRoutes.ExternalLibraries,
    MainNavRoutes.Foundation,
    MainNavRoutes.FoundationLayout,
    MainNavRoutes.Material,
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
        MainNavRoutes.Favorites,
        Icons.Filled.Favorite,
        menuAction = MenuAction.TOAST
    ),
    DrawerListItemData.MenuData(
        MainNavRoutes.Popular,
        Icons.Filled.ThumbUp
    ),
    DrawerListItemData.MenuData(
        MainNavRoutes.Articles,
        Icons.Filled.Article,
        menuAction = MenuAction.TOAST
    ),
    DrawerListItemData.DividerData,
    DrawerListItemData.MenuData(
        "send feedback",
        Icons.Filled.Feedback,
        "Send Feedback",
        MenuAction.FEEDBACK
    ),
    DrawerListItemData.MenuData(
        "privacy policy",
        Icons.Filled.PrivacyTip,
        menuAction = MenuAction.PRIVACY_POLICY
    ),
    DrawerListItemData.DividerData,
    DrawerListItemData.MenuData(
        MainNavRoutes.Settings,
        Icons.Filled.Settings
    ),
    DrawerListItemData.MenuData(
        MainNavRoutes.ReleaseNotes,
        Icons.Filled.NewReleases
    ),
)

private const val PrivacyPolicyUrl = "https://jetpack-compose-play.flycricket.io/privacy.html"

@Composable
fun MainScreenWithDrawer(
    navController: NavHostController,
    firebaseAuth: FirebaseAuth,
    googleSignInClient: GoogleSignInClient,
    title: String = stringResource(id = R.string.app_name),
    list: List<String> = routes,
    navigateToSearch: (() -> Unit)? = { navController.navigate(MainNavRoutes.Search) },
    showAd: Boolean = true,
) {
    val state = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val uriHandler = LocalUriHandler.current
    var user by remember { mutableStateOf(firebaseAuth.currentUser) }
    val launcher =
        rememberLauncherForActivityResult(GoogleSignContract(googleSignInClient)) { idToken ->
            scope.launch {
                try {
                    val credential = GoogleAuthProvider.getCredential(idToken, null)
                    val result = firebaseAuth.signInWithCredential(credential).await()
                    user = result.user
                } catch (e: Exception) {
                    Timber.e(e, "todo message")
                    // todo handle
                }
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
                navigateToSearch = navigateToSearch
            )
        },
        drawerContent = {
            DrawerUserItem(
                user = user,
                signInOnClick = {
                    launcher.launch(null)
                },
                signOutOnClick = {
                    firebaseAuth.signOut()
                    user = null
                }
            )
            drawerItems.forEach {
                when (it) {
                    is DrawerListItemData.DividerData -> Divider()
                    is DrawerListItemData.MenuData -> {
                        DrawerListItem(it.text, icon = {
                            Icon(
                                it.imageVector, contentDescription = "Open ${it.text}"
                            )
                        }) {
                            scope.launch {
                                state.drawerState.close()
                                when (it.menuAction) {
                                    MenuAction.NAVIGATION -> navController.navigate(it.text)
                                    MenuAction.TOAST -> Toast.makeText(
                                        context,
                                        "Coming soon",
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
        MainScreenContent(navController, it, list, showAd)
    }
}

@OptIn(ExperimentalCoilApi::class)
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
            val painter = rememberImagePainter(
                data = user.photoUrl,
                builder = {
                    transformations(CircleCropTransformation())
                }
            )
            Row(
                modifier = Modifier.align(Alignment.Center)
            ) {
                Box {
                    Image(
                        painter = painter,
                        contentDescription = "Content description",
                        modifier = Modifier
                            .size(64.dp)
                            .padding(end = 24.dp)
                    )
                    when (painter.state) {
                        is ImagePainter.State.Loading -> {
                            Box(Modifier.matchParentSize()) {
                                CircularProgressIndicator(Modifier.align(Alignment.Center))
                            }
                        }
                        is ImagePainter.State.Error -> {
                            Image(
                                imageVector = Icons.Filled.AccountCircle,
                                contentDescription = "Vector"
                            )
                        }
                        else -> {
                            Timber.d("Else image load states")
                        }
                    }
                }
                Text(
                    user.displayName ?: "name not found",
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                TextButton(
                    onClick = signOutOnClick,
                    modifier = Modifier.background(Color.Red)
                ) {
                    Text(
                        text = "Sign out",
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        } else {
            Button(
                onClick = signInOnClick,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = if (LocalIsDarkTheme.current) Color(0xFF4285F4.toInt()) else Color(
                        0xFFFFFFFF.toInt()
                    )
                ),
                modifier = Modifier.align(Alignment.Center)
            ) {
                Row {
                    Icon(
                        painter = painterResource(
                            id = R.drawable.ic_google_icon
                        ),
                        contentDescription = "Google icon",
                        tint = Color.Unspecified,
                        modifier = Modifier.padding(end = 24.dp)
                    )
                    Text(
                        text = "Sign in with Google",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    navController: NavHostController,
    title: String = stringResource(id = R.string.app_name),
    list: List<String> = routes,
    navigateToSearch: (() -> Unit)? = { navController.navigate(MainNavRoutes.Search) },
    showAd: Boolean = true,
) {
    Scaffold(
        modifier = Modifier.systemBarsPadding(),
        topBar = {
            DefaultTopAppBar(
                title = title,
                navigateToSearch = navigateToSearch
            )
        },
    ) {
        MainScreenContent(navController, it, list, showAd)
    }
}

@Composable
fun MainScreenContent(
    navController: NavHostController,
    paddingValues: PaddingValues,
    list: List<String>,
    showAd: Boolean = true,
) {
    val routesWithRibbons = remember {
        list.map { route ->
            route to (route in ribbonRoutes)
        }
    }
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .verticalScroll(rememberScrollState())
    ) {
        routesWithRibbons.forEach { (route, shouldShowRibbon) ->
            DefaultCardListItem(
                text = route,
                shouldShowRibbon = shouldShowRibbon
            ) {
                navController.navigate(route)
            }
        }
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

sealed class DrawerListItemData {

    class MenuData(
        val text: String,
        val imageVector: ImageVector,
        val contentDescription: String = "Open $text",
        val menuAction: MenuAction = MenuAction.NAVIGATION
    ) : DrawerListItemData()

    object DividerData : DrawerListItemData()
}

enum class MenuAction {
    NAVIGATION, TOAST, FEEDBACK, PRIVACY_POLICY
}

@Composable
private fun DrawerListItem(
    text: String,
    icon: @Composable (() -> Unit)? = null,
    onClick: () -> Unit
) {
    DefaultListItem(
        text = AnnotatedString(text.capitalizeFirstLetter()),
        modifier = Modifier.clickable(onClick = onClick),
        icon = icon
    )
}
