package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.guru.fontawesomecomposelib.FaIcon
import com.guru.fontawesomecomposelib.FaIcons
import com.steleot.jetpackcompose.playground.navigation.graph.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val Url = "externallibraries/FontAwesomeScreen.kt"

@Composable
fun FontAwesomeScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.FontAwesome,
        link = Url,
    ) {
        FontAwesomeGrid()
    }
}

private val list = listOf(
    FaIcons.AccessibleIcon,
    FaIcons.Accusoft,
    FaIcons.AcquisitionsIncorporated,
    FaIcons.Ad,
    FaIcons.AddressBook,
    FaIcons.AddressBookRegular,
    FaIcons.AddressCard,
    FaIcons.AddressCardRegular,
    FaIcons.Adjust,
    FaIcons.Adn,
    FaIcons.Adversal,
    FaIcons.Affiliatetheme,
    FaIcons.AirFreshener,
    FaIcons.Airbnb,
    FaIcons.Algolia,
    FaIcons.AlignCenter,
    FaIcons.AlignJustify,
    FaIcons.AlignLeft,
    FaIcons.AlignRight,
    FaIcons.Alipay,
    FaIcons.Allergies,
    FaIcons.Amazon,
    FaIcons.AmazonPay,
    FaIcons.Ambulance,
    FaIcons.AmericanSignLanguageInterpreting,
    FaIcons.Amilia,
    FaIcons.Anchor,
    FaIcons.Android,
    FaIcons.Angellist,
    FaIcons.AngleDoubleDown,
    FaIcons.AngleDoubleLeft,
    FaIcons.AngleDoubleRight,
    FaIcons.AngleDoubleUp,
    FaIcons.AngleDown,
    FaIcons.AngleLeft,
    FaIcons.AngleRight,
    FaIcons.AngleUp,
    FaIcons.Angry,
    FaIcons.AngryRegular,
    FaIcons.Angrycreative,
    FaIcons.Angular,
    FaIcons.Ankh,
    FaIcons.AppStore,
    FaIcons.AppStoreIos,
    FaIcons.Apper,
    FaIcons.Apple,
    FaIcons.AppleAlt,
    FaIcons.ApplePay,
    FaIcons.Archive,
    FaIcons.Archway,
    FaIcons.ArrowAltCircleDown,
    FaIcons.ArrowAltCircleDownRegular,
    FaIcons.ArrowAltCircleLeft,
    FaIcons.ArrowAltCircleLeftRegular,
    FaIcons.ArrowAltCircleRight,
    FaIcons.ArrowAltCircleRightRegular,
    FaIcons.ArrowAltCircleUp,
    FaIcons.ArrowAltCircleUpRegular,
    FaIcons.ArrowCircleDown,
    FaIcons.ArrowCircleLeft,
    FaIcons.ArrowCircleRight,
    FaIcons.ArrowCircleUp,
    FaIcons.ArrowDown,
    FaIcons.ArrowLeft,
    FaIcons.ArrowRight,
    FaIcons.ArrowUp,
    FaIcons.ArrowsAlt,
    FaIcons.ArrowsAltH,
    FaIcons.ArrowsAltV,
    FaIcons.Artstation,
    FaIcons.AssistiveListeningSystems,
    FaIcons.Asterisk,
    FaIcons.Asymmetrik,
    FaIcons.At,
    FaIcons.Atlas,
    FaIcons.Atlassian,
    FaIcons.Atom,
    FaIcons.Audible,
    FaIcons.AudioDescription,
    FaIcons.Autoprefixer,
    FaIcons.Avianex,
    FaIcons.Aviato,
    FaIcons.Award,
    FaIcons.Aws,
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun FontAwesomeGrid() {
    LazyVerticalGrid(
        GridCells.Adaptive(60.dp)
    ) {
        items(list) {
            FaIcon(
                faIcon = it,
                modifier = Modifier.padding(8.dp),
                size = 36.dp,
                tint = MaterialTheme.colors.onSurface
            )
        }
    }
}
