package com.ingbyr.guiyouget.controllers

import com.ingbyr.guiyouget.engine.YoutubeDL
import com.ingbyr.guiyouget.events.RequestCheckUpdatesYouGet
import com.ingbyr.guiyouget.events.RequestCheckUpdatesYoutubeDL
import org.slf4j.LoggerFactory
import tornadofx.Controller
import java.util.*


class UpdatesController : Controller() {
    init {
        messages = ResourceBundle.getBundle("i18n/UpdatesView")
    }

    private val logger = LoggerFactory.getLogger(this::class.java)

    fun subscribeEvents() {
        //TODO Engine needs to handle itself updates func
        subscribe<RequestCheckUpdatesYoutubeDL> {
            //TODO check updates for youtube-dl
        }

        subscribe<RequestCheckUpdatesYouGet> {
            //TODO check updates for you-get
        }
    }

    private fun needUpdate(localVersion: String, remoteVersion: String): Boolean {
        logger.debug("local version: $localVersion, remote version: $remoteVersion")
        val lv = localVersion.split(".").map { it.toInt() }
        val rv = remoteVersion.split(".").map { it.toInt() }
        return rv.indices.any { rv[it] - lv[it] > 0 }
    }

    private fun parseVersion(vStr: String): String {
        val v = Regex("'\\d+.+'").findAll(vStr).toList().flatMap(MatchResult::groupValues)
        return v.first().replace("'", "").replace("\"", "")
    }


    private fun downloadYouGet(remoteV: String) {
        //TODO download new you-get
    }

    private fun downloadYoutubeDL(remoteV: String) {
        //TODO download new youtube-dl
    }
}