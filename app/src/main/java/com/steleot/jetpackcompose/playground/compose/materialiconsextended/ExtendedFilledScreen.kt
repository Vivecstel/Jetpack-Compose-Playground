package com.steleot.jetpackcompose.playground.compose.materialiconsextended

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
import com.steleot.jetpackcompose.playground.MaterialIconsExtendedNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold

private const val Url = "materialiconsextended/ExtendedFilledScreen.kt"

@Composable
fun ExtendedFilledScreen() {
    DefaultScaffold(
        title = MaterialIconsExtendedNavRoutes.ExtendedFilled,
        link = Url,
    ) {
        ExtendedFilledGrid()
    }
}

private val list = listOf(
    Icons.Filled._3dRotation,
    Icons.Filled._4k,
    Icons.Filled._5g,
    Icons.Filled._6FtApart,
    Icons.Filled._360,
    Icons.Filled.AccessAlarm,
    Icons.Filled.AccessAlarms,
    Icons.Filled.Accessibility,
    Icons.Filled.AccessibilityNew,
    Icons.Filled.AccessibleForward,
    Icons.Filled.Accessible,
    Icons.Filled.AccessTime,
    Icons.Filled.AccountBalance,
    Icons.Filled.AccountBalanceWallet,
    Icons.Filled.AccountTree,
    Icons.Filled.AcUnit,
    Icons.Filled.Adb,
    Icons.Filled.AddAlarm,
    Icons.Filled.AddAlert,
    Icons.Filled.AddAPhoto,
    Icons.Filled.AddBox,
    Icons.Filled.AddBusiness,
    Icons.Filled.Addchart,
    Icons.Filled.AddCircleOutline,
    Icons.Filled.AddComment,
    Icons.Filled.AddIcCall,
    Icons.Filled.AddLocation,
    Icons.Filled.AddLocationAlt,
    Icons.Filled.AddPhotoAlternate,
    Icons.Filled.AddRoad,
    Icons.Filled.AddShoppingCart,
    Icons.Filled.AddTask,
    Icons.Filled.AddToHomeScreen,
    Icons.Filled.AddToPhotos,
    Icons.Filled.AddToQueue,
    Icons.Filled.Adjust,
    Icons.Filled.AdminPanelSettings,
    Icons.Filled.AdUnits,
    Icons.Filled.Agriculture,
    Icons.Filled.AirlineSeatFlatAngled,
    Icons.Filled.AirlineSeatFlat,
    Icons.Filled.AirlineSeatIndividualSuite,
    Icons.Filled.AirlineSeatLegroomExtra,
    Icons.Filled.AirlineSeatLegroomNormal,
    Icons.Filled.AirlineSeatLegroomReduced,
    Icons.Filled.AirlineSeatReclineExtra,
    Icons.Filled.AirlineSeatReclineNormal,
    Icons.Filled.AirplanemodeActive,
    Icons.Filled.AirplanemodeInactive,
    Icons.Filled.Airplay,
    Icons.Filled.AirportShuttle,
    Icons.Filled.AlarmAdd,
    Icons.Filled.Alarm,
    Icons.Filled.AlarmOff,
    Icons.Filled.AlarmOn,
    Icons.Filled.Album,
    Icons.Filled.AlignHorizontalCenter,
    Icons.Filled.AlignHorizontalLeft,
    Icons.Filled.AlignHorizontalRight,
    Icons.Filled.AlignVerticalBottom,
    Icons.Filled.AlignVerticalCenter,
    Icons.Filled.AlignVerticalTop,
    Icons.Filled.AllInbox,
    Icons.Filled.AllInclusive,
    Icons.Filled.AltRoute,
    Icons.Filled.AmpStories,
    Icons.Filled.Analytics,
    Icons.Filled.Anchor,
    Icons.Filled.Android,
    Icons.Filled.Announcement,
    Icons.Filled.Apartment,
    Icons.Filled.Api,
    Icons.Filled.AppBlocking,
    Icons.Filled.AppSettingsAlt,
    Icons.Filled.Apps,
    Icons.Filled.Architecture,
    Icons.Filled.Archive,
    Icons.Filled.ArrowBackIos,
    Icons.Filled.ArrowCircleDown,
    Icons.Filled.ArrowCircleUp,
    Icons.Filled.ArrowDownward,
    Icons.Filled.ArrowDropDownCircle,
    Icons.Filled.ArrowDropUp,
    Icons.Filled.ArrowForwardIos,
    Icons.Filled.ArrowLeft,
    Icons.Filled.ArrowRightAlt,
    Icons.Filled.ArrowRight,
    Icons.Filled.ArrowUpward,
    Icons.Filled.Article,
    Icons.Filled.ArtTrack,
    Icons.Filled.AspectRatio,
    Icons.Filled.Assessment,
    Icons.Filled.AssignmentInd,
    Icons.Filled.Assignment,
    Icons.Filled.AssignmentLate,
    Icons.Filled.AssignmentReturned,
    Icons.Filled.AssignmentReturn,
    Icons.Filled.AssignmentTurnedIn,
    Icons.Filled.Assistant,
    Icons.Filled.AssistantPhoto,
    Icons.Filled.Atm,
    Icons.Filled.AttachEmail,
    Icons.Filled.AttachFile,
    Icons.Filled.Attachment,
    Icons.Filled.AttachMoney,
    Icons.Filled.Audiotrack,
    Icons.Filled.AutoDelete,
    Icons.Filled.Autorenew,
    Icons.Filled.AvTimer,
)

@Preview
@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ExtendedFilledGrid() {
    LazyVerticalGrid(
        GridCells.Adaptive(60.dp)
    ) {
        items(list) {
            Icon(imageVector = it, contentDescription = "", modifier = Modifier.padding(8.dp))
        }
    }
}
