package com.steleot.jetpackcompose.playground.compose.materialiconsextended

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.AcUnit
import androidx.compose.material.icons.sharp.AccessAlarm
import androidx.compose.material.icons.sharp.AccessAlarms
import androidx.compose.material.icons.sharp.AccessTime
import androidx.compose.material.icons.sharp.Accessibility
import androidx.compose.material.icons.sharp.AccessibilityNew
import androidx.compose.material.icons.sharp.Accessible
import androidx.compose.material.icons.sharp.AccessibleForward
import androidx.compose.material.icons.sharp.AccountBalance
import androidx.compose.material.icons.sharp.AccountBalanceWallet
import androidx.compose.material.icons.sharp.AccountTree
import androidx.compose.material.icons.sharp.AdUnits
import androidx.compose.material.icons.sharp.Adb
import androidx.compose.material.icons.sharp.AddAPhoto
import androidx.compose.material.icons.sharp.AddAlarm
import androidx.compose.material.icons.sharp.AddAlert
import androidx.compose.material.icons.sharp.AddBox
import androidx.compose.material.icons.sharp.AddBusiness
import androidx.compose.material.icons.sharp.AddCircleOutline
import androidx.compose.material.icons.sharp.AddComment
import androidx.compose.material.icons.sharp.AddIcCall
import androidx.compose.material.icons.sharp.AddLocation
import androidx.compose.material.icons.sharp.AddLocationAlt
import androidx.compose.material.icons.sharp.AddPhotoAlternate
import androidx.compose.material.icons.sharp.AddRoad
import androidx.compose.material.icons.sharp.AddShoppingCart
import androidx.compose.material.icons.sharp.AddTask
import androidx.compose.material.icons.sharp.AddToHomeScreen
import androidx.compose.material.icons.sharp.AddToPhotos
import androidx.compose.material.icons.sharp.AddToQueue
import androidx.compose.material.icons.sharp.Addchart
import androidx.compose.material.icons.sharp.Adjust
import androidx.compose.material.icons.sharp.AdminPanelSettings
import androidx.compose.material.icons.sharp.Agriculture
import androidx.compose.material.icons.sharp.AirlineSeatFlat
import androidx.compose.material.icons.sharp.AirlineSeatFlatAngled
import androidx.compose.material.icons.sharp.AirlineSeatIndividualSuite
import androidx.compose.material.icons.sharp.AirlineSeatLegroomExtra
import androidx.compose.material.icons.sharp.AirlineSeatLegroomNormal
import androidx.compose.material.icons.sharp.AirlineSeatLegroomReduced
import androidx.compose.material.icons.sharp.AirlineSeatReclineExtra
import androidx.compose.material.icons.sharp.AirlineSeatReclineNormal
import androidx.compose.material.icons.sharp.AirplanemodeActive
import androidx.compose.material.icons.sharp.AirplanemodeInactive
import androidx.compose.material.icons.sharp.Airplay
import androidx.compose.material.icons.sharp.AirportShuttle
import androidx.compose.material.icons.sharp.Alarm
import androidx.compose.material.icons.sharp.AlarmAdd
import androidx.compose.material.icons.sharp.AlarmOff
import androidx.compose.material.icons.sharp.AlarmOn
import androidx.compose.material.icons.sharp.Album
import androidx.compose.material.icons.sharp.AlignHorizontalCenter
import androidx.compose.material.icons.sharp.AlignHorizontalLeft
import androidx.compose.material.icons.sharp.AlignHorizontalRight
import androidx.compose.material.icons.sharp.AlignVerticalBottom
import androidx.compose.material.icons.sharp.AlignVerticalCenter
import androidx.compose.material.icons.sharp.AlignVerticalTop
import androidx.compose.material.icons.sharp.AllInbox
import androidx.compose.material.icons.sharp.AllInclusive
import androidx.compose.material.icons.sharp.AltRoute
import androidx.compose.material.icons.sharp.AmpStories
import androidx.compose.material.icons.sharp.Analytics
import androidx.compose.material.icons.sharp.Anchor
import androidx.compose.material.icons.sharp.Android
import androidx.compose.material.icons.sharp.Announcement
import androidx.compose.material.icons.sharp.Apartment
import androidx.compose.material.icons.sharp.Api
import androidx.compose.material.icons.sharp.AppBlocking
import androidx.compose.material.icons.sharp.AppSettingsAlt
import androidx.compose.material.icons.sharp.Apps
import androidx.compose.material.icons.sharp.Architecture
import androidx.compose.material.icons.sharp.Archive
import androidx.compose.material.icons.sharp.ArrowBackIos
import androidx.compose.material.icons.sharp.ArrowCircleDown
import androidx.compose.material.icons.sharp.ArrowCircleUp
import androidx.compose.material.icons.sharp.ArrowDownward
import androidx.compose.material.icons.sharp.ArrowDropDownCircle
import androidx.compose.material.icons.sharp.ArrowDropUp
import androidx.compose.material.icons.sharp.ArrowForwardIos
import androidx.compose.material.icons.sharp.ArrowLeft
import androidx.compose.material.icons.sharp.ArrowRight
import androidx.compose.material.icons.sharp.ArrowRightAlt
import androidx.compose.material.icons.sharp.ArrowUpward
import androidx.compose.material.icons.sharp.ArtTrack
import androidx.compose.material.icons.sharp.Article
import androidx.compose.material.icons.sharp.AspectRatio
import androidx.compose.material.icons.sharp.Assessment
import androidx.compose.material.icons.sharp.Assignment
import androidx.compose.material.icons.sharp.AssignmentInd
import androidx.compose.material.icons.sharp.AssignmentLate
import androidx.compose.material.icons.sharp.AssignmentReturn
import androidx.compose.material.icons.sharp.AssignmentReturned
import androidx.compose.material.icons.sharp.AssignmentTurnedIn
import androidx.compose.material.icons.sharp.Assistant
import androidx.compose.material.icons.sharp.AssistantPhoto
import androidx.compose.material.icons.sharp.Atm
import androidx.compose.material.icons.sharp.AttachEmail
import androidx.compose.material.icons.sharp.AttachFile
import androidx.compose.material.icons.sharp.AttachMoney
import androidx.compose.material.icons.sharp.Attachment
import androidx.compose.material.icons.sharp.Audiotrack
import androidx.compose.material.icons.sharp.AutoDelete
import androidx.compose.material.icons.sharp.Autorenew
import androidx.compose.material.icons.sharp.AvTimer
import androidx.compose.material.icons.sharp._360
import androidx.compose.material.icons.sharp._3dRotation
import androidx.compose.material.icons.sharp._4k
import androidx.compose.material.icons.sharp._5g
import androidx.compose.material.icons.sharp._6FtApart
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

@Preview
@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ExtendedSharpGrid() {
    LazyVerticalGrid(
        GridCells.Adaptive(60.dp)
    ) {
        items(list) {
            Icon(imageVector = it, contentDescription = "", modifier = Modifier.padding(8.dp))
        }
    }
}
