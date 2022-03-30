package com.steleot.jetpackcompose.playground.appwidget

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.glance.GlanceModifier
import androidx.glance.LocalContext
import androidx.glance.action.clickable
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.action.actionStartActivity
import androidx.glance.appwidget.lazy.LazyColumn
import androidx.glance.appwidget.lazy.items
import androidx.glance.background
import androidx.glance.layout.*
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextAlign
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider
import com.steleot.jetpackcompose.playground.BuildConfig
import com.steleot.jetpackcompose.playground.MainActivity
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.rest.newRoutes
import com.steleot.jetpackcompose.playground.theme.deepPurple500

class PlaygroundGlanceWidget : GlanceAppWidget() {

    @Composable
    override fun Content() {
        val context = LocalContext.current
        Column(
            modifier = GlanceModifier.fillMaxSize().background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TitleText(context.getString(R.string.app_name))
            if (newRoutes.isEmpty()) {
                ItemText(context.getString(R.string.new_empty))
            } else {
                LazyColumn(modifier = GlanceModifier.fillMaxSize().background(Color.White)) {
                    items(newRoutes) {
                        ItemText(
                            text = it,
                            modifier = GlanceModifier.clickable(
                                actionStartActivity(
                                    Intent(
                                        Intent.ACTION_VIEW,
                                        "${BuildConfig.DEEP_LINK_URI}/$it".toUri(),
                                        context,
                                        MainActivity::class.java
                                    )
                                )
                            ),
                            textAlign = TextAlign.Start,
                        )
                    }
                }
            }
        }
    }

    @Composable
    private fun TitleText(
        text: String
    ) {
        Text(
            text = text,
            modifier = GlanceModifier
                .fillMaxWidth()
                .background(color = Color(deepPurple500))
                .padding(12.dp),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                color = ColorProvider(Color.White)
            ),
        )
    }

    @Composable
    private fun ItemText(
        text: String,
        modifier: GlanceModifier = GlanceModifier,
        textAlign: TextAlign = TextAlign.Center
    ) {
        Text(
            text = text,
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp),
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                textAlign = textAlign
            ),
        )
    }
}