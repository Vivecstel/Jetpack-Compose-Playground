package com.steleot.jetpackcompose.playground.compose.materialicons

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.AccountBox
import androidx.compose.material.icons.sharp.AccountCircle
import androidx.compose.material.icons.sharp.Add
import androidx.compose.material.icons.sharp.AddCircle
import androidx.compose.material.icons.sharp.ArrowBack
import androidx.compose.material.icons.sharp.ArrowDropDown
import androidx.compose.material.icons.sharp.ArrowForward
import androidx.compose.material.icons.sharp.Build
import androidx.compose.material.icons.sharp.Call
import androidx.compose.material.icons.sharp.Check
import androidx.compose.material.icons.sharp.CheckCircle
import androidx.compose.material.icons.sharp.Clear
import androidx.compose.material.icons.sharp.Close
import androidx.compose.material.icons.sharp.Create
import androidx.compose.material.icons.sharp.DateRange
import androidx.compose.material.icons.sharp.Delete
import androidx.compose.material.icons.sharp.Done
import androidx.compose.material.icons.sharp.Edit
import androidx.compose.material.icons.sharp.Email
import androidx.compose.material.icons.sharp.ExitToApp
import androidx.compose.material.icons.sharp.Face
import androidx.compose.material.icons.sharp.Favorite
import androidx.compose.material.icons.sharp.FavoriteBorder
import androidx.compose.material.icons.sharp.Home
import androidx.compose.material.icons.sharp.Info
import androidx.compose.material.icons.sharp.KeyboardArrowDown
import androidx.compose.material.icons.sharp.KeyboardArrowLeft
import androidx.compose.material.icons.sharp.KeyboardArrowRight
import androidx.compose.material.icons.sharp.KeyboardArrowUp
import androidx.compose.material.icons.sharp.List
import androidx.compose.material.icons.sharp.LocationOn
import androidx.compose.material.icons.sharp.Lock
import androidx.compose.material.icons.sharp.MailOutline
import androidx.compose.material.icons.sharp.Menu
import androidx.compose.material.icons.sharp.MoreVert
import androidx.compose.material.icons.sharp.Notifications
import androidx.compose.material.icons.sharp.Person
import androidx.compose.material.icons.sharp.Phone
import androidx.compose.material.icons.sharp.Place
import androidx.compose.material.icons.sharp.PlayArrow
import androidx.compose.material.icons.sharp.Refresh
import androidx.compose.material.icons.sharp.Search
import androidx.compose.material.icons.sharp.Send
import androidx.compose.material.icons.sharp.Settings
import androidx.compose.material.icons.sharp.Share
import androidx.compose.material.icons.sharp.ShoppingCart
import androidx.compose.material.icons.sharp.Star
import androidx.compose.material.icons.sharp.ThumbUp
import androidx.compose.material.icons.sharp.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.MaterialIconsNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.Locale

private const val Url = "materialicons/SharpScreen.kt"

@Composable
fun SharpScreen() {
    DefaultScaffold(
        title = MaterialIconsNavRoutes.Sharp.capitalize(Locale.getDefault()),
        link = Url,
    ) {
        SharpGrid()
    }
}

private val list = listOf(
    Icons.Sharp.AccountBox,
    Icons.Sharp.AccountCircle,
    Icons.Sharp.AddCircle,
    Icons.Sharp.Add,
    Icons.Sharp.ArrowBack,
    Icons.Sharp.ArrowDropDown,
    Icons.Sharp.ArrowForward,
    Icons.Sharp.Build,
    Icons.Sharp.Call,
    Icons.Sharp.CheckCircle,
    Icons.Sharp.Check,
    Icons.Sharp.Clear,
    Icons.Sharp.Close,
    Icons.Sharp.Create,
    Icons.Sharp.DateRange,
    Icons.Sharp.Delete,
    Icons.Sharp.Done,
    Icons.Sharp.Edit,
    Icons.Sharp.Email,
    Icons.Sharp.ExitToApp,
    Icons.Sharp.Face,
    Icons.Sharp.FavoriteBorder,
    Icons.Sharp.Favorite,
    Icons.Sharp.Home,
    Icons.Sharp.Info,
    Icons.Sharp.KeyboardArrowDown,
    Icons.Sharp.KeyboardArrowLeft,
    Icons.Sharp.KeyboardArrowRight,
    Icons.Sharp.KeyboardArrowUp,
    Icons.Sharp.List,
    Icons.Sharp.LocationOn,
    Icons.Sharp.Lock,
    Icons.Sharp.MailOutline,
    Icons.Sharp.Menu,
    Icons.Sharp.MoreVert,
    Icons.Sharp.Notifications,
    Icons.Sharp.Person,
    Icons.Sharp.Phone,
    Icons.Sharp.Place,
    Icons.Sharp.PlayArrow,
    Icons.Sharp.Refresh,
    Icons.Sharp.Search,
    Icons.Sharp.Send,
    Icons.Sharp.Settings,
    Icons.Sharp.Share,
    Icons.Sharp.ShoppingCart,
    Icons.Sharp.Star,
    Icons.Sharp.ThumbUp,
    Icons.Sharp.Warning,
)

@Preview
@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun SharpGrid() {
    LazyVerticalGrid(
        GridCells.Adaptive(60.dp)
    ) {
        items(list) {
            Icon(imageVector = it, contentDescription = "", modifier = Modifier.padding(8.dp))
        }
    }
}
