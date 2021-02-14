package com.steleot.jetpackcompose.playground.compose.materialiconsextended

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
import com.steleot.jetpackcompose.playground.MaterialIconsExtendedNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.*

@Composable
fun ExtendedSharpScreen() {
    DefaultScaffold(
        title = MaterialIconsExtendedNavRoutes.ExtendedSharp.capitalize(Locale.getDefault())
    ) {
        ExtendedSharpGrid()
    }
}

private val list = listOf(
    Icons.Sharp._3dRotation,
    Icons.Sharp._4k,
    Icons.Sharp._5g,
    Icons.Sharp._6FtApart,
    Icons.Sharp._360,
    Icons.Sharp.AccessAlarm,
    Icons.Sharp.AccessAlarms,
    Icons.Sharp.Accessibility,
    Icons.Sharp.AccessibilityNew,
    Icons.Sharp.AccessibleForward,
    Icons.Sharp.Accessible,
    Icons.Sharp.AccessTime,
    Icons.Sharp.AccountBalance,
    Icons.Sharp.AccountBalanceWallet,
    Icons.Sharp.AccountTree,
    Icons.Sharp.AcUnit,
    Icons.Sharp.Adb,
    Icons.Sharp.AddAlarm,
    Icons.Sharp.AddAlert,
    Icons.Sharp.AddAPhoto,
    Icons.Sharp.AddBox,
    Icons.Sharp.AddBusiness,
    Icons.Sharp.Addchart,
    Icons.Sharp.AddCircleOutline,
    Icons.Sharp.AddComment,
    Icons.Sharp.AddIcCall,
    Icons.Sharp.AddLocation,
    Icons.Sharp.AddLocationAlt,
    Icons.Sharp.AddPhotoAlternate,
    Icons.Sharp.AddRoad,
    Icons.Sharp.AddShoppingCart,
    Icons.Sharp.AddTask,
    Icons.Sharp.AddToHomeScreen,
    Icons.Sharp.AddToPhotos,
    Icons.Sharp.AddToQueue,
    Icons.Sharp.Adjust,
    Icons.Sharp.AdminPanelSettings,
    Icons.Sharp.AdUnits,
    Icons.Sharp.Agriculture,
    Icons.Sharp.AirlineSeatFlatAngled,
    Icons.Sharp.AirlineSeatFlat,
    Icons.Sharp.AirlineSeatIndividualSuite,
    Icons.Sharp.AirlineSeatLegroomExtra,
    Icons.Sharp.AirlineSeatLegroomNormal,
    Icons.Sharp.AirlineSeatLegroomReduced,
    Icons.Sharp.AirlineSeatReclineExtra,
    Icons.Sharp.AirlineSeatReclineNormal,
    Icons.Sharp.AirplanemodeActive,
    Icons.Sharp.AirplanemodeInactive,
    Icons.Sharp.Airplay,
    Icons.Sharp.AirportShuttle,
    Icons.Sharp.AlarmAdd,
    Icons.Sharp.Alarm,
    Icons.Sharp.AlarmOff,
    Icons.Sharp.AlarmOn,
    Icons.Sharp.Album,
    Icons.Sharp.AlignHorizontalCenter,
    Icons.Sharp.AlignHorizontalLeft,
    Icons.Sharp.AlignHorizontalRight,
    Icons.Sharp.AlignVerticalBottom,
    Icons.Sharp.AlignVerticalCenter,
    Icons.Sharp.AlignVerticalTop,
    Icons.Sharp.AllInbox,
    Icons.Sharp.AllInclusive,
    Icons.Sharp.AltRoute,
    Icons.Sharp.AmpStories,
    Icons.Sharp.Analytics,
    Icons.Sharp.Anchor,
    Icons.Sharp.Android,
    Icons.Sharp.Announcement,
    Icons.Sharp.Apartment,
    Icons.Sharp.Api,
    Icons.Sharp.AppBlocking,
    Icons.Sharp.AppSettingsAlt,
    Icons.Sharp.Apps,
    Icons.Sharp.Architecture,
    Icons.Sharp.Archive,
    Icons.Sharp.ArrowBackIos,
    Icons.Sharp.ArrowCircleDown,
    Icons.Sharp.ArrowCircleUp,
    Icons.Sharp.ArrowDownward,
    Icons.Sharp.ArrowDropDownCircle,
    Icons.Sharp.ArrowDropUp,
    Icons.Sharp.ArrowForwardIos,
    Icons.Sharp.ArrowLeft,
    Icons.Sharp.ArrowRightAlt,
    Icons.Sharp.ArrowRight,
    Icons.Sharp.ArrowUpward,
    Icons.Sharp.Article,
    Icons.Sharp.ArtTrack,
    Icons.Sharp.AspectRatio,
    Icons.Sharp.Assessment,
    Icons.Sharp.AssignmentInd,
    Icons.Sharp.Assignment,
    Icons.Sharp.AssignmentLate,
    Icons.Sharp.AssignmentReturned,
    Icons.Sharp.AssignmentReturn,
    Icons.Sharp.AssignmentTurnedIn,
    Icons.Sharp.Assistant,
    Icons.Sharp.AssistantPhoto,
    Icons.Sharp.Atm,
    Icons.Sharp.AttachEmail,
    Icons.Sharp.AttachFile,
    Icons.Sharp.Attachment,
    Icons.Sharp.AttachMoney,
    Icons.Sharp.Audiotrack,
    Icons.Sharp.AutoDelete,
    Icons.Sharp.Autorenew,
    Icons.Sharp.AvTimer,
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExtendedSharpGrid() {
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
fun PreviewExtendedSharpGrid() {
    ExtendedSharpGrid()
}