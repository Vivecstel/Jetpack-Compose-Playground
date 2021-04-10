package com.steleot.jetpackcompose.playground.compose.materialiconsextended

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AcUnit
import androidx.compose.material.icons.filled.AccessAlarm
import androidx.compose.material.icons.filled.AccessAlarms
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Accessibility
import androidx.compose.material.icons.filled.AccessibilityNew
import androidx.compose.material.icons.filled.Accessible
import androidx.compose.material.icons.filled.AccessibleForward
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.AccountTree
import androidx.compose.material.icons.filled.AdUnits
import androidx.compose.material.icons.filled.Adb
import androidx.compose.material.icons.filled.AddAPhoto
import androidx.compose.material.icons.filled.AddAlarm
import androidx.compose.material.icons.filled.AddAlert
import androidx.compose.material.icons.filled.AddBox
import androidx.compose.material.icons.filled.AddBusiness
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material.icons.filled.AddComment
import androidx.compose.material.icons.filled.AddIcCall
import androidx.compose.material.icons.filled.AddLocation
import androidx.compose.material.icons.filled.AddLocationAlt
import androidx.compose.material.icons.filled.AddPhotoAlternate
import androidx.compose.material.icons.filled.AddRoad
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.AddTask
import androidx.compose.material.icons.filled.AddToHomeScreen
import androidx.compose.material.icons.filled.AddToPhotos
import androidx.compose.material.icons.filled.AddToQueue
import androidx.compose.material.icons.filled.Addchart
import androidx.compose.material.icons.filled.Adjust
import androidx.compose.material.icons.filled.AdminPanelSettings
import androidx.compose.material.icons.filled.Agriculture
import androidx.compose.material.icons.filled.AirlineSeatFlat
import androidx.compose.material.icons.filled.AirlineSeatFlatAngled
import androidx.compose.material.icons.filled.AirlineSeatIndividualSuite
import androidx.compose.material.icons.filled.AirlineSeatLegroomExtra
import androidx.compose.material.icons.filled.AirlineSeatLegroomNormal
import androidx.compose.material.icons.filled.AirlineSeatLegroomReduced
import androidx.compose.material.icons.filled.AirlineSeatReclineExtra
import androidx.compose.material.icons.filled.AirlineSeatReclineNormal
import androidx.compose.material.icons.filled.AirplanemodeActive
import androidx.compose.material.icons.filled.AirplanemodeInactive
import androidx.compose.material.icons.filled.Airplay
import androidx.compose.material.icons.filled.AirportShuttle
import androidx.compose.material.icons.filled.Alarm
import androidx.compose.material.icons.filled.AlarmAdd
import androidx.compose.material.icons.filled.AlarmOff
import androidx.compose.material.icons.filled.AlarmOn
import androidx.compose.material.icons.filled.Album
import androidx.compose.material.icons.filled.AlignHorizontalCenter
import androidx.compose.material.icons.filled.AlignHorizontalLeft
import androidx.compose.material.icons.filled.AlignHorizontalRight
import androidx.compose.material.icons.filled.AlignVerticalBottom
import androidx.compose.material.icons.filled.AlignVerticalCenter
import androidx.compose.material.icons.filled.AlignVerticalTop
import androidx.compose.material.icons.filled.AllInbox
import androidx.compose.material.icons.filled.AllInclusive
import androidx.compose.material.icons.filled.AltRoute
import androidx.compose.material.icons.filled.AmpStories
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Anchor
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.Announcement
import androidx.compose.material.icons.filled.Apartment
import androidx.compose.material.icons.filled.Api
import androidx.compose.material.icons.filled.AppBlocking
import androidx.compose.material.icons.filled.AppSettingsAlt
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.Architecture
import androidx.compose.material.icons.filled.Archive
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.ArrowCircleDown
import androidx.compose.material.icons.filled.ArrowCircleUp
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowDropDownCircle
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.ArrowLeft
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.material.icons.filled.ArrowRightAlt
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.ArtTrack
import androidx.compose.material.icons.filled.Article
import androidx.compose.material.icons.filled.AspectRatio
import androidx.compose.material.icons.filled.Assessment
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.AssignmentInd
import androidx.compose.material.icons.filled.AssignmentLate
import androidx.compose.material.icons.filled.AssignmentReturn
import androidx.compose.material.icons.filled.AssignmentReturned
import androidx.compose.material.icons.filled.AssignmentTurnedIn
import androidx.compose.material.icons.filled.Assistant
import androidx.compose.material.icons.filled.AssistantPhoto
import androidx.compose.material.icons.filled.Atm
import androidx.compose.material.icons.filled.AttachEmail
import androidx.compose.material.icons.filled.AttachFile
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Attachment
import androidx.compose.material.icons.filled.Audiotrack
import androidx.compose.material.icons.filled.AutoDelete
import androidx.compose.material.icons.filled.Autorenew
import androidx.compose.material.icons.filled.AvTimer
import androidx.compose.material.icons.filled._360
import androidx.compose.material.icons.filled._3dRotation
import androidx.compose.material.icons.filled._4k
import androidx.compose.material.icons.filled._5g
import androidx.compose.material.icons.filled._6FtApart
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
