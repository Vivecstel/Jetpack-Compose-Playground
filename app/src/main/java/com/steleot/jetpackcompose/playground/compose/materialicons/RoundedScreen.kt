package com.steleot.jetpackcompose.playground.compose.materialicons

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.Build
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Create
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.ExitToApp
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.MailOutline
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Place
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.ThumbUp
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.MaterialIconsNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.Locale

private const val Url = "materialicons/RoundedScreen.kt"

@Composable
fun RoundedScreen() {
    DefaultScaffold(
        title = MaterialIconsNavRoutes.Rounded.capitalize(Locale.getDefault()),
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
