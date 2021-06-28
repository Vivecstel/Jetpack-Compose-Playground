package com.steleot.jetpackcompose.playground.compose.materialicons

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.MaterialIconsNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold

private const val Url = "materialicons/TwoToneScreen.kt"

@Composable
fun TwoToneScreen() {
    DefaultScaffold(
        title = MaterialIconsNavRoutes.TwoTone,
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
