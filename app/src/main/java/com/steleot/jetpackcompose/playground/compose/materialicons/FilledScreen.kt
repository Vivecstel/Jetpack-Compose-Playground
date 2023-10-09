package com.steleot.jetpackcompose.playground.compose.materialicons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.*
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.MaterialIconsNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "materialicons/FilledScreen.kt"

@Composable
fun FilledScreen() {
    DefaultScaffold(
        title = MaterialIconsNavRoutes.Filled,
        link = URL
    ) {
        FilledGrid(paddingValues = it)
    }
}

private val list = listOf(
    Icons.Filled.AccountBox,
    Icons.Filled.AccountCircle,
    Icons.Filled.AddCircle,
    Icons.Filled.Add,
    Icons.AutoMirrored.Filled.ArrowBack,
    Icons.Filled.ArrowDropDown,
    Icons.AutoMirrored.Filled.ArrowForward,
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
    Icons.AutoMirrored.Filled.ExitToApp,
    Icons.Filled.Face,
    Icons.Filled.FavoriteBorder,
    Icons.Filled.Favorite,
    Icons.Filled.Home,
    Icons.Filled.Info,
    Icons.Filled.KeyboardArrowDown,
    Icons.AutoMirrored.Filled.KeyboardArrowLeft,
    Icons.AutoMirrored.Filled.KeyboardArrowRight,
    Icons.Filled.KeyboardArrowUp,
    Icons.AutoMirrored.Filled.List,
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
    Icons.AutoMirrored.Filled.Send,
    Icons.Filled.Settings,
    Icons.Filled.Share,
    Icons.Filled.ShoppingCart,
    Icons.Filled.Star,
    Icons.Filled.ThumbUp,
    Icons.Filled.Warning,
)

@Preview
@Composable
private fun FilledGrid(paddingValues: PaddingValues = PaddingValues()) {
    LazyVerticalGrid(
        GridCells.Adaptive(60.dp),
        modifier = Modifier.padding(paddingValues = paddingValues)
    ) {
        items(list) {
            Icon(imageVector = it, contentDescription = null, modifier = Modifier.padding(8.dp))
        }
    }
}
