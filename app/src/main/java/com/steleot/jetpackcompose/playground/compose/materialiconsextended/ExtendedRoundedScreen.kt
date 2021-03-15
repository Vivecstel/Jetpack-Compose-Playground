package com.steleot.jetpackcompose.playground.compose.materialiconsextended

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AcUnit
import androidx.compose.material.icons.rounded.AccessAlarm
import androidx.compose.material.icons.rounded.AccessAlarms
import androidx.compose.material.icons.rounded.AccessTime
import androidx.compose.material.icons.rounded.Accessibility
import androidx.compose.material.icons.rounded.AccessibilityNew
import androidx.compose.material.icons.rounded.Accessible
import androidx.compose.material.icons.rounded.AccessibleForward
import androidx.compose.material.icons.rounded.AccountBalance
import androidx.compose.material.icons.rounded.AccountBalanceWallet
import androidx.compose.material.icons.rounded.AccountTree
import androidx.compose.material.icons.rounded.AdUnits
import androidx.compose.material.icons.rounded.Adb
import androidx.compose.material.icons.rounded.AddAPhoto
import androidx.compose.material.icons.rounded.AddAlarm
import androidx.compose.material.icons.rounded.AddAlert
import androidx.compose.material.icons.rounded.AddBox
import androidx.compose.material.icons.rounded.AddBusiness
import androidx.compose.material.icons.rounded.AddCircleOutline
import androidx.compose.material.icons.rounded.AddComment
import androidx.compose.material.icons.rounded.AddIcCall
import androidx.compose.material.icons.rounded.AddLocation
import androidx.compose.material.icons.rounded.AddLocationAlt
import androidx.compose.material.icons.rounded.AddPhotoAlternate
import androidx.compose.material.icons.rounded.AddRoad
import androidx.compose.material.icons.rounded.AddShoppingCart
import androidx.compose.material.icons.rounded.AddTask
import androidx.compose.material.icons.rounded.AddToHomeScreen
import androidx.compose.material.icons.rounded.AddToPhotos
import androidx.compose.material.icons.rounded.AddToQueue
import androidx.compose.material.icons.rounded.Addchart
import androidx.compose.material.icons.rounded.Adjust
import androidx.compose.material.icons.rounded.AdminPanelSettings
import androidx.compose.material.icons.rounded.Agriculture
import androidx.compose.material.icons.rounded.AirlineSeatFlat
import androidx.compose.material.icons.rounded.AirlineSeatFlatAngled
import androidx.compose.material.icons.rounded.AirlineSeatIndividualSuite
import androidx.compose.material.icons.rounded.AirlineSeatLegroomExtra
import androidx.compose.material.icons.rounded.AirlineSeatLegroomNormal
import androidx.compose.material.icons.rounded.AirlineSeatLegroomReduced
import androidx.compose.material.icons.rounded.AirlineSeatReclineExtra
import androidx.compose.material.icons.rounded.AirlineSeatReclineNormal
import androidx.compose.material.icons.rounded.AirplanemodeActive
import androidx.compose.material.icons.rounded.AirplanemodeInactive
import androidx.compose.material.icons.rounded.Airplay
import androidx.compose.material.icons.rounded.AirportShuttle
import androidx.compose.material.icons.rounded.Alarm
import androidx.compose.material.icons.rounded.AlarmAdd
import androidx.compose.material.icons.rounded.AlarmOff
import androidx.compose.material.icons.rounded.AlarmOn
import androidx.compose.material.icons.rounded.Album
import androidx.compose.material.icons.rounded.AlignHorizontalCenter
import androidx.compose.material.icons.rounded.AlignHorizontalLeft
import androidx.compose.material.icons.rounded.AlignHorizontalRight
import androidx.compose.material.icons.rounded.AlignVerticalBottom
import androidx.compose.material.icons.rounded.AlignVerticalCenter
import androidx.compose.material.icons.rounded.AlignVerticalTop
import androidx.compose.material.icons.rounded.AllInbox
import androidx.compose.material.icons.rounded.AllInclusive
import androidx.compose.material.icons.rounded.AltRoute
import androidx.compose.material.icons.rounded.AmpStories
import androidx.compose.material.icons.rounded.Analytics
import androidx.compose.material.icons.rounded.Anchor
import androidx.compose.material.icons.rounded.Android
import androidx.compose.material.icons.rounded.Announcement
import androidx.compose.material.icons.rounded.Apartment
import androidx.compose.material.icons.rounded.Api
import androidx.compose.material.icons.rounded.AppBlocking
import androidx.compose.material.icons.rounded.AppSettingsAlt
import androidx.compose.material.icons.rounded.Apps
import androidx.compose.material.icons.rounded.Architecture
import androidx.compose.material.icons.rounded.Archive
import androidx.compose.material.icons.rounded.ArrowBackIos
import androidx.compose.material.icons.rounded.ArrowCircleDown
import androidx.compose.material.icons.rounded.ArrowCircleUp
import androidx.compose.material.icons.rounded.ArrowDownward
import androidx.compose.material.icons.rounded.ArrowDropDownCircle
import androidx.compose.material.icons.rounded.ArrowDropUp
import androidx.compose.material.icons.rounded.ArrowForwardIos
import androidx.compose.material.icons.rounded.ArrowLeft
import androidx.compose.material.icons.rounded.ArrowRight
import androidx.compose.material.icons.rounded.ArrowRightAlt
import androidx.compose.material.icons.rounded.ArrowUpward
import androidx.compose.material.icons.rounded.ArtTrack
import androidx.compose.material.icons.rounded.Article
import androidx.compose.material.icons.rounded.AspectRatio
import androidx.compose.material.icons.rounded.Assessment
import androidx.compose.material.icons.rounded.Assignment
import androidx.compose.material.icons.rounded.AssignmentInd
import androidx.compose.material.icons.rounded.AssignmentLate
import androidx.compose.material.icons.rounded.AssignmentReturn
import androidx.compose.material.icons.rounded.AssignmentReturned
import androidx.compose.material.icons.rounded.AssignmentTurnedIn
import androidx.compose.material.icons.rounded.Assistant
import androidx.compose.material.icons.rounded.AssistantPhoto
import androidx.compose.material.icons.rounded.Atm
import androidx.compose.material.icons.rounded.AttachEmail
import androidx.compose.material.icons.rounded.AttachFile
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.Attachment
import androidx.compose.material.icons.rounded.Audiotrack
import androidx.compose.material.icons.rounded.AutoDelete
import androidx.compose.material.icons.rounded.Autorenew
import androidx.compose.material.icons.rounded.AvTimer
import androidx.compose.material.icons.rounded._360
import androidx.compose.material.icons.rounded._3dRotation
import androidx.compose.material.icons.rounded._4k
import androidx.compose.material.icons.rounded._5g
import androidx.compose.material.icons.rounded._6FtApart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.MaterialIconsExtendedNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.Locale

private const val Url = "materialiconsextended/ExtendedRoundedScreen.kt"

@Composable
fun ExtendedRoundedScreen() {
    DefaultScaffold(
        title = MaterialIconsExtendedNavRoutes.ExtendedRounded.capitalize(Locale.getDefault()),
        link = Url,
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
