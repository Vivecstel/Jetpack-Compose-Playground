package com.steleot.jetpackcompose.playground.compose.materialiconsextended

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
import com.steleot.jetpackcompose.playground.MaterialIconsExtendedNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.*

@Composable
fun ExtendedOutlinedScreen() {
    DefaultScaffold(
        title = MaterialIconsExtendedNavRoutes.ExtendedOutlined.capitalize(Locale.getDefault())
    ) {
        ExtendedOutlinedGrid()
    }
}

private val list = listOf(
    Icons.Outlined._3dRotation,
    Icons.Outlined._4k,
    Icons.Outlined._5g,
    Icons.Outlined._6FtApart,
    Icons.Outlined._360,
    Icons.Outlined.AccessAlarm,
    Icons.Outlined.AccessAlarms,
    Icons.Outlined.Accessibility,
    Icons.Outlined.AccessibilityNew,
    Icons.Outlined.AccessibleForward,
    Icons.Outlined.Accessible,
    Icons.Outlined.AccessTime,
    Icons.Outlined.AccountBalance,
    Icons.Outlined.AccountBalanceWallet,
    Icons.Outlined.AccountTree,
    Icons.Outlined.AcUnit,
    Icons.Outlined.Adb,
    Icons.Outlined.AddAlarm,
    Icons.Outlined.AddAlert,
    Icons.Outlined.AddAPhoto,
    Icons.Outlined.AddBox,
    Icons.Outlined.AddBusiness,
    Icons.Outlined.Addchart,
    Icons.Outlined.AddCircleOutline,
    Icons.Outlined.AddComment,
    Icons.Outlined.AddIcCall,
    Icons.Outlined.AddLocation,
    Icons.Outlined.AddLocationAlt,
    Icons.Outlined.AddPhotoAlternate,
    Icons.Outlined.AddRoad,
    Icons.Outlined.AddShoppingCart,
    Icons.Outlined.AddTask,
    Icons.Outlined.AddToHomeScreen,
    Icons.Outlined.AddToPhotos,
    Icons.Outlined.AddToQueue,
    Icons.Outlined.Adjust,
    Icons.Outlined.AdminPanelSettings,
    Icons.Outlined.AdUnits,
    Icons.Outlined.Agriculture,
    Icons.Outlined.AirlineSeatFlatAngled,
    Icons.Outlined.AirlineSeatFlat,
    Icons.Outlined.AirlineSeatIndividualSuite,
    Icons.Outlined.AirlineSeatLegroomExtra,
    Icons.Outlined.AirlineSeatLegroomNormal,
    Icons.Outlined.AirlineSeatLegroomReduced,
    Icons.Outlined.AirlineSeatReclineExtra,
    Icons.Outlined.AirlineSeatReclineNormal,
    Icons.Outlined.AirplanemodeActive,
    Icons.Outlined.AirplanemodeInactive,
    Icons.Outlined.Airplay,
    Icons.Outlined.AirportShuttle,
    Icons.Outlined.AlarmAdd,
    Icons.Outlined.Alarm,
    Icons.Outlined.AlarmOff,
    Icons.Outlined.AlarmOn,
    Icons.Outlined.Album,
    Icons.Outlined.AlignHorizontalCenter,
    Icons.Outlined.AlignHorizontalLeft,
    Icons.Outlined.AlignHorizontalRight,
    Icons.Outlined.AlignVerticalBottom,
    Icons.Outlined.AlignVerticalCenter,
    Icons.Outlined.AlignVerticalTop,
    Icons.Outlined.AllInbox,
    Icons.Outlined.AllInclusive,
    Icons.Outlined.AltRoute,
    Icons.Outlined.AmpStories,
    Icons.Outlined.Analytics,
    Icons.Outlined.Anchor,
    Icons.Outlined.Android,
    Icons.Outlined.Announcement,
    Icons.Outlined.Apartment,
    Icons.Outlined.Api,
    Icons.Outlined.AppBlocking,
    Icons.Outlined.AppSettingsAlt,
    Icons.Outlined.Apps,
    Icons.Outlined.Architecture,
    Icons.Outlined.Archive,
    Icons.Outlined.ArrowBackIos,
    Icons.Outlined.ArrowCircleDown,
    Icons.Outlined.ArrowCircleUp,
    Icons.Outlined.ArrowDownward,
    Icons.Outlined.ArrowDropDownCircle,
    Icons.Outlined.ArrowDropUp,
    Icons.Outlined.ArrowForwardIos,
    Icons.Outlined.ArrowLeft,
    Icons.Outlined.ArrowRightAlt,
    Icons.Outlined.ArrowRight,
    Icons.Outlined.ArrowUpward,
    Icons.Outlined.Article,
    Icons.Outlined.ArtTrack,
    Icons.Outlined.AspectRatio,
    Icons.Outlined.Assessment,
    Icons.Outlined.AssignmentInd,
    Icons.Outlined.Assignment,
    Icons.Outlined.AssignmentLate,
    Icons.Outlined.AssignmentReturned,
    Icons.Outlined.AssignmentReturn,
    Icons.Outlined.AssignmentTurnedIn,
    Icons.Outlined.Assistant,
    Icons.Outlined.AssistantPhoto,
    Icons.Outlined.Atm,
    Icons.Outlined.AttachEmail,
    Icons.Outlined.AttachFile,
    Icons.Outlined.Attachment,
    Icons.Outlined.AttachMoney,
    Icons.Outlined.Audiotrack,
    Icons.Outlined.AutoDelete,
    Icons.Outlined.Autorenew,
    Icons.Outlined.AvTimer,
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExtendedOutlinedGrid() {
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
fun PreviewExtendedOutlinedGrid() {
    ExtendedOutlinedGrid()
}