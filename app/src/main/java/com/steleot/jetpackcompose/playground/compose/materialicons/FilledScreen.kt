package com.steleot.jetpackcompose.playground.compose.materialicons

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.MaterialIconsNavRoutes

private const val Url = "materialicons/FilledScreen.kt"

@Composable
fun FilledScreen() {
    DefaultScaffold(
        title = MaterialIconsNavRoutes.Filled,
        link = Url
    ) {
        FilledGrid()
    }
}

private val list = listOf(
    Icons.Filled.AccountBox,
    Icons.Filled.AccountCircle,
    Icons.Filled.AddCircle,
    Icons.Filled.Add,
    Icons.Filled.ArrowBack,
    Icons.Filled.ArrowDropDown,
    Icons.Filled.ArrowForward,
    Icons.Filled.Build,
    Icons.Filled.Call,
    Icons.Filled.CheckCircle,
    Icons.Filled.Check,
    Icons.Filled.Clear,
    Icons.Filled.Close,
    Icons.Filled.Create,
    Icons.Filled.DateRange,
    Icons.Filled.Delete,
    Icons.Filled.Done,
    Icons.Filled.Edit,
    Icons.Filled.Email,
    Icons.Filled.ExitToApp,
    Icons.Filled.Face,
    Icons.Filled.FavoriteBorder,
    Icons.Filled.Favorite,
    Icons.Filled.Home,
    Icons.Filled.Info,
    Icons.Filled.KeyboardArrowDown,
    Icons.Filled.KeyboardArrowLeft,
    Icons.Filled.KeyboardArrowRight,
    Icons.Filled.KeyboardArrowUp,
    Icons.Filled.List,
    Icons.Filled.LocationOn,
    Icons.Filled.Lock,
    Icons.Filled.MailOutline,
    Icons.Filled.Menu,
    Icons.Filled.MoreVert,
    Icons.Filled.Notifications,
    Icons.Filled.Person,
    Icons.Filled.Phone,
    Icons.Filled.Place,
    Icons.Filled.PlayArrow,
    Icons.Filled.Refresh,
    Icons.Filled.Search,
    Icons.Filled.Send,
    Icons.Filled.Settings,
    Icons.Filled.Share,
    Icons.Filled.ShoppingCart,
    Icons.Filled.Star,
    Icons.Filled.ThumbUp,
    Icons.Filled.Warning,
)

@Preview
@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun FilledGrid() {
    LazyVerticalGrid(
        GridCells.Adaptive(60.dp)
    ) {
        items(list) {
            Icon(imageVector = it, contentDescription = null, modifier = Modifier.padding(8.dp))
        }
    }
}
