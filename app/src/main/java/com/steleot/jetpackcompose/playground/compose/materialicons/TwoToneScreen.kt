package com.steleot.jetpackcompose.playground.compose.materialicons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.twotone.*
import androidx.compose.material.icons.twotone.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.MaterialIconsNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "materialicons/TwoToneScreen.kt"

@Composable
fun TwoToneScreen() {
    DefaultScaffold(
        title = MaterialIconsNavRoutes.TwoTone,
        link = URL,
    ) {
        TwoToneGrid(paddingValues = it)
    }
}

private val list = listOf(
    Icons.TwoTone.AccountBox,
    Icons.TwoTone.AccountCircle,
    Icons.TwoTone.AddCircle,
    Icons.TwoTone.Add,
    Icons.AutoMirrored.TwoTone.ArrowBack,
    Icons.TwoTone.ArrowDropDown,
    Icons.AutoMirrored.TwoTone.ArrowForward,
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
    Icons.AutoMirrored.TwoTone.ExitToApp,
    Icons.TwoTone.Face,
    Icons.TwoTone.FavoriteBorder,
    Icons.TwoTone.Favorite,
    Icons.TwoTone.Home,
    Icons.TwoTone.Info,
    Icons.TwoTone.KeyboardArrowDown,
    Icons.AutoMirrored.TwoTone.KeyboardArrowLeft,
    Icons.AutoMirrored.TwoTone.KeyboardArrowRight,
    Icons.TwoTone.KeyboardArrowUp,
    Icons.AutoMirrored.TwoTone.List,
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
    Icons.AutoMirrored.TwoTone.Send,
    Icons.TwoTone.Settings,
    Icons.TwoTone.Share,
    Icons.TwoTone.ShoppingCart,
    Icons.TwoTone.Star,
    Icons.TwoTone.ThumbUp,
    Icons.TwoTone.Warning,
)

@Preview
@Composable
private fun TwoToneGrid(paddingValues: PaddingValues = PaddingValues()) {
    LazyVerticalGrid(
        GridCells.Adaptive(60.dp),
        modifier = Modifier.padding(paddingValues = paddingValues),
    ) {
        items(list) {
            Icon(imageVector = it, contentDescription = null, modifier = Modifier.padding(8.dp))
        }
    }
}
