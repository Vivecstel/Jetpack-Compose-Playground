package com.steleot.jetpackcompose.playground.compose.materialicons

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.MaterialIconsNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

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
