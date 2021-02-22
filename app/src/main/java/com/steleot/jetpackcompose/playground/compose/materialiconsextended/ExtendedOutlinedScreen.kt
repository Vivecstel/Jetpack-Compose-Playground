package com.steleot.jetpackcompose.playground.compose.materialiconsextended

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AcUnit
import androidx.compose.material.icons.outlined.AccessAlarm
import androidx.compose.material.icons.outlined.AccessAlarms
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material.icons.outlined.Accessibility
import androidx.compose.material.icons.outlined.AccessibilityNew
import androidx.compose.material.icons.outlined.Accessible
import androidx.compose.material.icons.outlined.AccessibleForward
import androidx.compose.material.icons.outlined.AccountBalance
import androidx.compose.material.icons.outlined.AccountBalanceWallet
import androidx.compose.material.icons.outlined.AccountTree
import androidx.compose.material.icons.outlined.AdUnits
import androidx.compose.material.icons.outlined.Adb
import androidx.compose.material.icons.outlined.AddAPhoto
import androidx.compose.material.icons.outlined.AddAlarm
import androidx.compose.material.icons.outlined.AddAlert
import androidx.compose.material.icons.outlined.AddBox
import androidx.compose.material.icons.outlined.AddBusiness
import androidx.compose.material.icons.outlined.AddCircleOutline
import androidx.compose.material.icons.outlined.AddComment
import androidx.compose.material.icons.outlined.AddIcCall
import androidx.compose.material.icons.outlined.AddLocation
import androidx.compose.material.icons.outlined.AddLocationAlt
import androidx.compose.material.icons.outlined.AddPhotoAlternate
import androidx.compose.material.icons.outlined.AddRoad
import androidx.compose.material.icons.outlined.AddShoppingCart
import androidx.compose.material.icons.outlined.AddTask
import androidx.compose.material.icons.outlined.AddToHomeScreen
import androidx.compose.material.icons.outlined.AddToPhotos
import androidx.compose.material.icons.outlined.AddToQueue
import androidx.compose.material.icons.outlined.Addchart
import androidx.compose.material.icons.outlined.Adjust
import androidx.compose.material.icons.outlined.AdminPanelSettings
import androidx.compose.material.icons.outlined.Agriculture
import androidx.compose.material.icons.outlined.AirlineSeatFlat
import androidx.compose.material.icons.outlined.AirlineSeatFlatAngled
import androidx.compose.material.icons.outlined.AirlineSeatIndividualSuite
import androidx.compose.material.icons.outlined.AirlineSeatLegroomExtra
import androidx.compose.material.icons.outlined.AirlineSeatLegroomNormal
import androidx.compose.material.icons.outlined.AirlineSeatLegroomReduced
import androidx.compose.material.icons.outlined.AirlineSeatReclineExtra
import androidx.compose.material.icons.outlined.AirlineSeatReclineNormal
import androidx.compose.material.icons.outlined.AirplanemodeActive
import androidx.compose.material.icons.outlined.AirplanemodeInactive
import androidx.compose.material.icons.outlined.Airplay
import androidx.compose.material.icons.outlined.AirportShuttle
import androidx.compose.material.icons.outlined.Alarm
import androidx.compose.material.icons.outlined.AlarmAdd
import androidx.compose.material.icons.outlined.AlarmOff
import androidx.compose.material.icons.outlined.AlarmOn
import androidx.compose.material.icons.outlined.Album
import androidx.compose.material.icons.outlined.AlignHorizontalCenter
import androidx.compose.material.icons.outlined.AlignHorizontalLeft
import androidx.compose.material.icons.outlined.AlignHorizontalRight
import androidx.compose.material.icons.outlined.AlignVerticalBottom
import androidx.compose.material.icons.outlined.AlignVerticalCenter
import androidx.compose.material.icons.outlined.AlignVerticalTop
import androidx.compose.material.icons.outlined.AllInbox
import androidx.compose.material.icons.outlined.AllInclusive
import androidx.compose.material.icons.outlined.AltRoute
import androidx.compose.material.icons.outlined.AmpStories
import androidx.compose.material.icons.outlined.Analytics
import androidx.compose.material.icons.outlined.Anchor
import androidx.compose.material.icons.outlined.Android
import androidx.compose.material.icons.outlined.Announcement
import androidx.compose.material.icons.outlined.Apartment
import androidx.compose.material.icons.outlined.Api
import androidx.compose.material.icons.outlined.AppBlocking
import androidx.compose.material.icons.outlined.AppSettingsAlt
import androidx.compose.material.icons.outlined.Apps
import androidx.compose.material.icons.outlined.Architecture
import androidx.compose.material.icons.outlined.Archive
import androidx.compose.material.icons.outlined.ArrowBackIos
import androidx.compose.material.icons.outlined.ArrowCircleDown
import androidx.compose.material.icons.outlined.ArrowCircleUp
import androidx.compose.material.icons.outlined.ArrowDownward
import androidx.compose.material.icons.outlined.ArrowDropDownCircle
import androidx.compose.material.icons.outlined.ArrowDropUp
import androidx.compose.material.icons.outlined.ArrowForwardIos
import androidx.compose.material.icons.outlined.ArrowLeft
import androidx.compose.material.icons.outlined.ArrowRight
import androidx.compose.material.icons.outlined.ArrowRightAlt
import androidx.compose.material.icons.outlined.ArrowUpward
import androidx.compose.material.icons.outlined.ArtTrack
import androidx.compose.material.icons.outlined.Article
import androidx.compose.material.icons.outlined.AspectRatio
import androidx.compose.material.icons.outlined.Assessment
import androidx.compose.material.icons.outlined.Assignment
import androidx.compose.material.icons.outlined.AssignmentInd
import androidx.compose.material.icons.outlined.AssignmentLate
import androidx.compose.material.icons.outlined.AssignmentReturn
import androidx.compose.material.icons.outlined.AssignmentReturned
import androidx.compose.material.icons.outlined.AssignmentTurnedIn
import androidx.compose.material.icons.outlined.Assistant
import androidx.compose.material.icons.outlined.AssistantPhoto
import androidx.compose.material.icons.outlined.Atm
import androidx.compose.material.icons.outlined.AttachEmail
import androidx.compose.material.icons.outlined.AttachFile
import androidx.compose.material.icons.outlined.AttachMoney
import androidx.compose.material.icons.outlined.Attachment
import androidx.compose.material.icons.outlined.Audiotrack
import androidx.compose.material.icons.outlined.AutoDelete
import androidx.compose.material.icons.outlined.Autorenew
import androidx.compose.material.icons.outlined.AvTimer
import androidx.compose.material.icons.outlined._360
import androidx.compose.material.icons.outlined._3dRotation
import androidx.compose.material.icons.outlined._4k
import androidx.compose.material.icons.outlined._5g
import androidx.compose.material.icons.outlined._6FtApart
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

@Preview
@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ExtendedOutlinedGrid() {
    LazyVerticalGrid(
        GridCells.Adaptive(60.dp)
    ) {
        items(list) {
            Icon(imageVector = it, contentDescription = "", modifier = Modifier.padding(8.dp))
        }
    }
}
