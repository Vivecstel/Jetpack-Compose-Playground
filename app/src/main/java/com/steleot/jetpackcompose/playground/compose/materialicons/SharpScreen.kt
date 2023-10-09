package com.steleot.jetpackcompose.playground.compose.materialicons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.sharp.*
import androidx.compose.material.icons.sharp.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.MaterialIconsNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "materialicons/SharpScreen.kt"

@Composable
fun SharpScreen() {
    DefaultScaffold(
        title = MaterialIconsNavRoutes.Sharp,
        link = URL,
    ) {
        SharpGrid(paddingValues = it)
    }
}

private val list = listOf(
    Icons.Sharp.AccountBox,
    Icons.Sharp.AccountCircle,
    Icons.Sharp.AddCircle,
    Icons.Sharp.Add,
    Icons.AutoMirrored.Sharp.ArrowBack,
    Icons.Sharp.ArrowDropDown,
    Icons.AutoMirrored.Sharp.ArrowForward,
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
    Icons.AutoMirrored.Sharp.ExitToApp,
    Icons.Sharp.Face,
    Icons.Sharp.FavoriteBorder,
    Icons.Sharp.Favorite,
    Icons.Sharp.Home,
    Icons.Sharp.Info,
    Icons.Sharp.KeyboardArrowDown,
    Icons.AutoMirrored.Sharp.KeyboardArrowLeft,
    Icons.AutoMirrored.Sharp.KeyboardArrowRight,
    Icons.Sharp.KeyboardArrowUp,
    Icons.AutoMirrored.Sharp.List,
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
    Icons.AutoMirrored.Sharp.Send,
    Icons.Sharp.Settings,
    Icons.Sharp.Share,
    Icons.Sharp.ShoppingCart,
    Icons.Sharp.Star,
    Icons.Sharp.ThumbUp,
    Icons.Sharp.Warning,
)

@Preview
@Composable
private fun SharpGrid(paddingValues: PaddingValues = PaddingValues()) {
    LazyVerticalGrid(
        GridCells.Adaptive(60.dp),
        modifier = Modifier.padding(paddingValues = paddingValues)
    ) {
        items(list) {
            Icon(imageVector = it, contentDescription = null, modifier = Modifier.padding(8.dp))
        }
    }
}
