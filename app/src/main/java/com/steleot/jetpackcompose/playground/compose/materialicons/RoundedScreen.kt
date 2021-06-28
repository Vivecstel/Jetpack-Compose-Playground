package com.steleot.jetpackcompose.playground.compose.materialicons

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.MaterialIconsNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold

private const val Url = "materialicons/RoundedScreen.kt"

@Composable
fun RoundedScreen() {
    DefaultScaffold(
        title = MaterialIconsNavRoutes.Rounded,
        link = Url,
    ) {
        RoundedGrid()
    }
}

private val list = listOf(
    Icons.Rounded.AccountBox,
    Icons.Rounded.AccountCircle,
    Icons.Rounded.AddCircle,
    Icons.Rounded.Add,
    Icons.Rounded.ArrowBack,
    Icons.Rounded.ArrowDropDown,
    Icons.Rounded.ArrowForward,
    Icons.Rounded.Build,
    Icons.Rounded.Call,
    Icons.Rounded.CheckCircle,
    Icons.Rounded.Check,
    Icons.Rounded.Clear,
    Icons.Rounded.Close,
    Icons.Rounded.Create,
    Icons.Rounded.DateRange,
    Icons.Rounded.Delete,
    Icons.Rounded.Done,
    Icons.Rounded.Edit,
    Icons.Rounded.Email,
    Icons.Rounded.ExitToApp,
    Icons.Rounded.Face,
    Icons.Rounded.FavoriteBorder,
    Icons.Rounded.Favorite,
    Icons.Rounded.Home,
    Icons.Rounded.Info,
    Icons.Rounded.KeyboardArrowDown,
    Icons.Rounded.KeyboardArrowLeft,
    Icons.Rounded.KeyboardArrowRight,
    Icons.Rounded.KeyboardArrowUp,
    Icons.Rounded.List,
    Icons.Rounded.LocationOn,
    Icons.Rounded.Lock,
    Icons.Rounded.MailOutline,
    Icons.Rounded.Menu,
    Icons.Rounded.MoreVert,
    Icons.Rounded.Notifications,
    Icons.Rounded.Person,
    Icons.Rounded.Phone,
    Icons.Rounded.Place,
    Icons.Rounded.PlayArrow,
    Icons.Rounded.Refresh,
    Icons.Rounded.Search,
    Icons.Rounded.Send,
    Icons.Rounded.Settings,
    Icons.Rounded.Share,
    Icons.Rounded.ShoppingCart,
    Icons.Rounded.Star,
    Icons.Rounded.ThumbUp,
    Icons.Rounded.Warning,
)

@Preview
@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun RoundedGrid() {
    LazyVerticalGrid(
        GridCells.Adaptive(60.dp)
    ) {
        items(list) {
            Icon(imageVector = it, contentDescription = "", modifier = Modifier.padding(8.dp))
        }
    }
}
