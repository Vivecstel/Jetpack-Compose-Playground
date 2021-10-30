package com.steleot.jetpackcompose.playground.compose.materialicons

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.MaterialIconsNavRoutes

private const val Url = "materialicons/OutlinedScreen.kt"

@Composable
fun OutlinedScreen() {
    DefaultScaffold(
        title = MaterialIconsNavRoutes.Outlined,
        link = Url,
    ) {
        OutlinedGrid()
    }
}

private val list = listOf(
    Icons.Outlined.AccountBox,
    Icons.Outlined.AccountCircle,
    Icons.Outlined.AddCircle,
    Icons.Outlined.Add,
    Icons.Outlined.ArrowBack,
    Icons.Outlined.ArrowDropDown,
    Icons.Outlined.ArrowForward,
    Icons.Outlined.Build,
    Icons.Outlined.Call,
    Icons.Outlined.CheckCircle,
    Icons.Outlined.Check,
    Icons.Outlined.Clear,
    Icons.Outlined.Close,
    Icons.Outlined.Create,
    Icons.Outlined.DateRange,
    Icons.Outlined.Delete,
    Icons.Outlined.Done,
    Icons.Outlined.Edit,
    Icons.Outlined.Email,
    Icons.Outlined.ExitToApp,
    Icons.Outlined.Face,
    Icons.Outlined.FavoriteBorder,
    Icons.Outlined.Favorite,
    Icons.Outlined.Home,
    Icons.Outlined.Info,
    Icons.Outlined.KeyboardArrowDown,
    Icons.Outlined.KeyboardArrowLeft,
    Icons.Outlined.KeyboardArrowRight,
    Icons.Outlined.KeyboardArrowUp,
    Icons.Outlined.List,
    Icons.Outlined.LocationOn,
    Icons.Outlined.Lock,
    Icons.Outlined.MailOutline,
    Icons.Outlined.Menu,
    Icons.Outlined.MoreVert,
    Icons.Outlined.Notifications,
    Icons.Outlined.Person,
    Icons.Outlined.Phone,
    Icons.Outlined.Place,
    Icons.Outlined.PlayArrow,
    Icons.Outlined.Refresh,
    Icons.Outlined.Search,
    Icons.Outlined.Send,
    Icons.Outlined.Settings,
    Icons.Outlined.Share,
    Icons.Outlined.ShoppingCart,
    Icons.Outlined.Star,
    Icons.Outlined.ThumbUp,
    Icons.Outlined.Warning,
)

@Preview
@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun OutlinedGrid() {
    LazyVerticalGrid(
        GridCells.Adaptive(60.dp)
    ) {
        items(list) {
            Icon(imageVector = it, contentDescription = "", modifier = Modifier.padding(8.dp))
        }
    }
}
