package com.canerture.valorantcmp

import android.app.Application
import com.canerture.common.di.initKoin

class ValorantCMPApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}
