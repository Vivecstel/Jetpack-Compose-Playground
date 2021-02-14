package com.steleot.jetpackcompose.playground.compose.materialicons

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.MaterialIconsNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.*

@Composable
fun OutlinedScreen() {
    DefaultScaffold(
        title = MaterialIconsNavRoutes.Outlined.capitalize(Locale.getDefault())
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OutlinedGrid() {
    LazyVerticalGrid(
        GridCells.Adaptive(60.dp)
    ) {
        items(list) {
            Icon(imageVector = it, contentDescription = "", modifier = Modifier.padding(8.dp))
        }
    }
}

@Preview
@Composable
fun PreviewOutlinedGrid() {
    OutlinedGrid()
}