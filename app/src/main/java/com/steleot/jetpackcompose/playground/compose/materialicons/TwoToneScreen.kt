package com.steleot.jetpackcompose.playground.compose.materialicons

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.AccountBox
import androidx.compose.material.icons.twotone.AccountCircle
import androidx.compose.material.icons.twotone.Add
import androidx.compose.material.icons.twotone.AddCircle
import androidx.compose.material.icons.twotone.ArrowBack
import androidx.compose.material.icons.twotone.ArrowDropDown
import androidx.compose.material.icons.twotone.ArrowForward
import androidx.compose.material.icons.twotone.Build
import androidx.compose.material.icons.twotone.Call
import androidx.compose.material.icons.twotone.Check
import androidx.compose.material.icons.twotone.CheckCircle
import androidx.compose.material.icons.twotone.Clear
import androidx.compose.material.icons.twotone.Close
import androidx.compose.material.icons.twotone.Create
import androidx.compose.material.icons.twotone.DateRange
import androidx.compose.material.icons.twotone.Delete
import androidx.compose.material.icons.twotone.Done
import androidx.compose.material.icons.twotone.Edit
import androidx.compose.material.icons.twotone.Email
import androidx.compose.material.icons.twotone.ExitToApp
import androidx.compose.material.icons.twotone.Face
import androidx.compose.material.icons.twotone.Favorite
import androidx.compose.material.icons.twotone.FavoriteBorder
import androidx.compose.material.icons.twotone.Home
import androidx.compose.material.icons.twotone.Info
import androidx.compose.material.icons.twotone.KeyboardArrowDown
import androidx.compose.material.icons.twotone.KeyboardArrowLeft
import androidx.compose.material.icons.twotone.KeyboardArrowRight
import androidx.compose.material.icons.twotone.KeyboardArrowUp
import androidx.compose.material.icons.twotone.List
import androidx.compose.material.icons.twotone.LocationOn
import androidx.compose.material.icons.twotone.Lock
import androidx.compose.material.icons.twotone.MailOutline
import androidx.compose.material.icons.twotone.Menu
import androidx.compose.material.icons.twotone.MoreVert
import androidx.compose.material.icons.twotone.Notifications
import androidx.compose.material.icons.twotone.Person
import androidx.compose.material.icons.twotone.Phone
import androidx.compose.material.icons.twotone.Place
import androidx.compose.material.icons.twotone.PlayArrow
import androidx.compose.material.icons.twotone.Refresh
import androidx.compose.material.icons.twotone.Search
import androidx.compose.material.icons.twotone.Send
import androidx.compose.material.icons.twotone.Settings
import androidx.compose.material.icons.twotone.Share
import androidx.compose.material.icons.twotone.ShoppingCart
import androidx.compose.material.icons.twotone.Star
import androidx.compose.material.icons.twotone.ThumbUp
import androidx.compose.material.icons.twotone.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.MaterialIconsNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.Locale

private const val Url = "materialicons/TwoToneScreen.kt"

@Composable
fun TwoToneScreen() {
    DefaultScaffold(
        title = MaterialIconsNavRoutes.TwoTone.capitalize(Locale.getDefault()),
        link = Url,
    ) {
        TwoToneGrid()
    }
}

private val list = listOf(
    Icons.TwoTone.AccountBox,
    Icons.TwoTone.AccountCircle,
    Icons.TwoTone.AddCircle,
    Icons.TwoTone.Add,
    Icons.TwoTone.ArrowBack,
    Icons.TwoTone.ArrowDropDown,
    Icons.TwoTone.ArrowForward,
    Icons.TwoTone.Build,
    Icons.TwoTone.Call,
    Icons.TwoTone.CheckCircle,
    Icons.TwoTone.Check,
    Icons.TwoTone.Clear,
    Icons.TwoTone.Close,
    Icons.TwoTone.Create,
    Icons.TwoTone.DateRange,
    Icons.TwoTone.Delete,
    Icons.TwoTone.Done,
    Icons.TwoTone.Edit,
    Icons.TwoTone.Email,
    Icons.TwoTone.ExitToApp,
    Icons.TwoTone.Face,
    Icons.TwoTone.FavoriteBorder,
    Icons.TwoTone.Favorite,
    Icons.TwoTone.Home,
    Icons.TwoTone.Info,
    Icons.TwoTone.KeyboardArrowDown,
    Icons.TwoTone.KeyboardArrowLeft,
    Icons.TwoTone.KeyboardArrowRight,
    Icons.TwoTone.KeyboardArrowUp,
    Icons.TwoTone.List,
    Icons.TwoTone.LocationOn,
    Icons.TwoTone.Lock,
    Icons.TwoTone.MailOutline,
    Icons.TwoTone.Menu,
    Icons.TwoTone.MoreVert,
    Icons.TwoTone.Notifications,
    Icons.TwoTone.Person,
    Icons.TwoTone.Phone,
    Icons.TwoTone.Place,
    Icons.TwoTone.PlayArrow,
    Icons.TwoTone.Refresh,
    Icons.TwoTone.Search,
    Icons.TwoTone.Send,
    Icons.TwoTone.Settings,
    Icons.TwoTone.Share,
    Icons.TwoTone.ShoppingCart,
    Icons.TwoTone.Star,
    Icons.TwoTone.ThumbUp,
    Icons.TwoTone.Warning,
)

@Preview
@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun TwoToneGrid() {
    LazyVerticalGrid(
        GridCells.Adaptive(60.dp)
    ) {
        items(list) {
            Icon(imageVector = it, contentDescription = "", modifier = Modifier.padding(8.dp))
        }
    }
}
