package com.steleot.jetpackcompose.playground.compose.materialiconsextended

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.MaterialIconsExtendedNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.*

@Composable
fun ExtendedTwoToneScreen() {
    DefaultScaffold(
        title = MaterialIconsExtendedNavRoutes.ExtendedTwoTone.capitalize(Locale.getDefault())
    ) {
        ExtendedTwoToneGrid()
    }
}

private val list = listOf(
    Icons.TwoTone._3dRotation,
    Icons.TwoTone._4k,
    Icons.TwoTone._5g,
    Icons.TwoTone._6FtApart,
    Icons.TwoTone._360,
    Icons.TwoTone.AccessAlarm,
    Icons.TwoTone.AccessAlarms,
    Icons.TwoTone.Accessibility,
    Icons.TwoTone.AccessibilityNew,
    Icons.TwoTone.AccessibleForward,
    Icons.TwoTone.Accessible,
    Icons.TwoTone.AccessTime,
    Icons.TwoTone.AccountBalance,
    Icons.TwoTone.AccountBalanceWallet,
    Icons.TwoTone.AccountTree,
    Icons.TwoTone.AcUnit,
    Icons.TwoTone.Adb,
    Icons.TwoTone.AddAlarm,
    Icons.TwoTone.AddAlert,
    Icons.TwoTone.AddAPhoto,
    Icons.TwoTone.AddBox,
    Icons.TwoTone.AddBusiness,
    Icons.TwoTone.Addchart,
    Icons.TwoTone.AddCircleOutline,
    Icons.TwoTone.AddComment,
    Icons.TwoTone.AddIcCall,
    Icons.TwoTone.AddLocation,
    Icons.TwoTone.AddLocationAlt,
    Icons.TwoTone.AddPhotoAlternate,
    Icons.TwoTone.AddRoad,
    Icons.TwoTone.AddShoppingCart,
    Icons.TwoTone.AddTask,
    Icons.TwoTone.AddToHomeScreen,
    Icons.TwoTone.AddToPhotos,
    Icons.TwoTone.AddToQueue,
    Icons.TwoTone.Adjust,
    Icons.TwoTone.AdminPanelSettings,
    Icons.TwoTone.AdUnits,
    Icons.TwoTone.Agriculture,
    Icons.TwoTone.AirlineSeatFlatAngled,
    Icons.TwoTone.AirlineSeatFlat,
    Icons.TwoTone.AirlineSeatIndividualSuite,
    Icons.TwoTone.AirlineSeatLegroomExtra,
    Icons.TwoTone.AirlineSeatLegroomNormal,
    Icons.TwoTone.AirlineSeatLegroomReduced,
    Icons.TwoTone.AirlineSeatReclineExtra,
    Icons.TwoTone.AirlineSeatReclineNormal,
    Icons.TwoTone.AirplanemodeActive,
    Icons.TwoTone.AirplanemodeInactive,
    Icons.TwoTone.Airplay,
    Icons.TwoTone.AirportShuttle,
    Icons.TwoTone.AlarmAdd,
    Icons.TwoTone.Alarm,
    Icons.TwoTone.AlarmOff,
    Icons.TwoTone.AlarmOn,
    Icons.TwoTone.Album,
    Icons.TwoTone.AlignHorizontalCenter,
    Icons.TwoTone.AlignHorizontalLeft,
    Icons.TwoTone.AlignHorizontalRight,
    Icons.TwoTone.AlignVerticalBottom,
    Icons.TwoTone.AlignVerticalCenter,
    Icons.TwoTone.AlignVerticalTop,
    Icons.TwoTone.AllInbox,
    Icons.TwoTone.AllInclusive,
    Icons.TwoTone.AltRoute,
    Icons.TwoTone.AmpStories,
    Icons.TwoTone.Analytics,
    Icons.TwoTone.Anchor,
    Icons.TwoTone.Android,
    Icons.TwoTone.Announcement,
    Icons.TwoTone.Apartment,
    Icons.TwoTone.Api,
    Icons.TwoTone.AppBlocking,
    Icons.TwoTone.AppSettingsAlt,
    Icons.TwoTone.Apps,
    Icons.TwoTone.Architecture,
    Icons.TwoTone.Archive,
    Icons.TwoTone.ArrowBackIos,
    Icons.TwoTone.ArrowCircleDown,
    Icons.TwoTone.ArrowCircleUp,
    Icons.TwoTone.ArrowDownward,
    Icons.TwoTone.ArrowDropDownCircle,
    Icons.TwoTone.ArrowDropUp,
    Icons.TwoTone.ArrowForwardIos,
    Icons.TwoTone.ArrowLeft,
    Icons.TwoTone.ArrowRightAlt,
    Icons.TwoTone.ArrowRight,
    Icons.TwoTone.ArrowUpward,
    Icons.TwoTone.Article,
    Icons.TwoTone.ArtTrack,
    Icons.TwoTone.AspectRatio,
    Icons.TwoTone.Assessment,
    Icons.TwoTone.AssignmentInd,
    Icons.TwoTone.Assignment,
    Icons.TwoTone.AssignmentLate,
    Icons.TwoTone.AssignmentReturned,
    Icons.TwoTone.AssignmentReturn,
    Icons.TwoTone.AssignmentTurnedIn,
    Icons.TwoTone.Assistant,
    Icons.TwoTone.AssistantPhoto,
    Icons.TwoTone.Atm,
    Icons.TwoTone.AttachEmail,
    Icons.TwoTone.AttachFile,
    Icons.TwoTone.Attachment,
    Icons.TwoTone.AttachMoney,
    Icons.TwoTone.Audiotrack,
    Icons.TwoTone.AutoDelete,
    Icons.TwoTone.Autorenew,
    Icons.TwoTone.AvTimer,
)

@Preview
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExtendedTwoToneGrid() {
    LazyVerticalGrid(
        GridCells.Adaptive(60.dp)
    ) {
        items(list) {
            Icon(imageVector = it, contentDescription = "", modifier = Modifier.padding(8.dp))
        }
    }
}
