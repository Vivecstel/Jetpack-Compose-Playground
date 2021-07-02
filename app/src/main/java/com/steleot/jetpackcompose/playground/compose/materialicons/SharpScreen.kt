package com.steleot.jetpackcompose.playground.compose.materialicons

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.MaterialIconsNavRoutes

private const val Url = "materialicons/SharpScreen.kt"

@Composable
fun SharpScreen() {
    DefaultScaffold(
        title = MaterialIconsNavRoutes.Sharp,
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
