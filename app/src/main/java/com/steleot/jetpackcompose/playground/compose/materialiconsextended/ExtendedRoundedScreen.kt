package com.steleot.jetpackcompose.playground.compose.materialiconsextended

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.MaterialIconsExtendedNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.*

@Composable
fun ExtendedRoundedScreen() {
    DefaultScaffold(
        title = MaterialIconsExtendedNavRoutes.ExtendedRounded.capitalize(Locale.getDefault())
    ) {
        ExtendedRoundedGrid()
    }
}

private val list = listOf(
    Icons.Rounded._3dRotation,
    Icons.Rounded._4k,
    Icons.Rounded._5g,
    Icons.Rounded._6FtApart,
    Icons.Rounded._360,
    Icons.Rounded.AccessAlarm,
    Icons.Rounded.AccessAlarms,
    Icons.Rounded.Accessibility,
    Icons.Rounded.AccessibilityNew,
    Icons.Rounded.AccessibleForward,
    Icons.Rounded.Accessible,
    Icons.Rounded.AccessTime,
    Icons.Rounded.AccountBalance,
    Icons.Rounded.AccountBalanceWallet,
    Icons.Rounded.AccountTree,
    Icons.Rounded.AcUnit,
    Icons.Rounded.Adb,
    Icons.Rounded.AddAlarm,
    Icons.Rounded.AddAlert,
    Icons.Rounded.AddAPhoto,
    Icons.Rounded.AddBox,
    Icons.Rounded.AddBusiness,
    Icons.Rounded.Addchart,
    Icons.Rounded.AddCircleOutline,
    Icons.Rounded.AddComment,
    Icons.Rounded.AddIcCall,
    Icons.Rounded.AddLocation,
    Icons.Rounded.AddLocationAlt,
    Icons.Rounded.AddPhotoAlternate,
    Icons.Rounded.AddRoad,
    Icons.Rounded.AddShoppingCart,
    Icons.Rounded.AddTask,
    Icons.Rounded.AddToHomeScreen,
    Icons.Rounded.AddToPhotos,
    Icons.Rounded.AddToQueue,
    Icons.Rounded.Adjust,
    Icons.Rounded.AdminPanelSettings,
    Icons.Rounded.AdUnits,
    Icons.Rounded.Agriculture,
    Icons.Rounded.AirlineSeatFlatAngled,
    Icons.Rounded.AirlineSeatFlat,
    Icons.Rounded.AirlineSeatIndividualSuite,
    Icons.Rounded.AirlineSeatLegroomExtra,
    Icons.Rounded.AirlineSeatLegroomNormal,
    Icons.Rounded.AirlineSeatLegroomReduced,
    Icons.Rounded.AirlineSeatReclineExtra,
    Icons.Rounded.AirlineSeatReclineNormal,
    Icons.Rounded.AirplanemodeActive,
    Icons.Rounded.AirplanemodeInactive,
    Icons.Rounded.Airplay,
    Icons.Rounded.AirportShuttle,
    Icons.Rounded.AlarmAdd,
    Icons.Rounded.Alarm,
    Icons.Rounded.AlarmOff,
    Icons.Rounded.AlarmOn,
    Icons.Rounded.Album,
    Icons.Rounded.AlignHorizontalCenter,
    Icons.Rounded.AlignHorizontalLeft,
    Icons.Rounded.AlignHorizontalRight,
    Icons.Rounded.AlignVerticalBottom,
    Icons.Rounded.AlignVerticalCenter,
    Icons.Rounded.AlignVerticalTop,
    Icons.Rounded.AllInbox,
    Icons.Rounded.AllInclusive,
    Icons.Rounded.AltRoute,
    Icons.Rounded.AmpStories,
    Icons.Rounded.Analytics,
    Icons.Rounded.Anchor,
    Icons.Rounded.Android,
    Icons.Rounded.Announcement,
    Icons.Rounded.Apartment,
    Icons.Rounded.Api,
    Icons.Rounded.AppBlocking,
    Icons.Rounded.AppSettingsAlt,
    Icons.Rounded.Apps,
    Icons.Rounded.Architecture,
    Icons.Rounded.Archive,
    Icons.Rounded.ArrowBackIos,
    Icons.Rounded.ArrowCircleDown,
    Icons.Rounded.ArrowCircleUp,
    Icons.Rounded.ArrowDownward,
    Icons.Rounded.ArrowDropDownCircle,
    Icons.Rounded.ArrowDropUp,
    Icons.Rounded.ArrowForwardIos,
    Icons.Rounded.ArrowLeft,
    Icons.Rounded.ArrowRightAlt,
    Icons.Rounded.ArrowRight,
    Icons.Rounded.ArrowUpward,
    Icons.Rounded.Article,
    Icons.Rounded.ArtTrack,
    Icons.Rounded.AspectRatio,
    Icons.Rounded.Assessment,
    Icons.Rounded.AssignmentInd,
    Icons.Rounded.Assignment,
    Icons.Rounded.AssignmentLate,
    Icons.Rounded.AssignmentReturned,
    Icons.Rounded.AssignmentReturn,
    Icons.Rounded.AssignmentTurnedIn,
    Icons.Rounded.Assistant,
    Icons.Rounded.AssistantPhoto,
    Icons.Rounded.Atm,
    Icons.Rounded.AttachEmail,
    Icons.Rounded.AttachFile,
    Icons.Rounded.Attachment,
    Icons.Rounded.AttachMoney,
    Icons.Rounded.Audiotrack,
    Icons.Rounded.AutoDelete,
    Icons.Rounded.Autorenew,
    Icons.Rounded.AvTimer,
)

@Preview
@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ExtendedRoundedGrid() {
    LazyVerticalGrid(
        GridCells.Adaptive(60.dp)
    ) {
        items(list) {
            Icon(imageVector = it, contentDescription = "", modifier = Modifier.padding(8.dp))
        }
    }
}
