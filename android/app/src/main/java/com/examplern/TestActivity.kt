package com.examplern

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log
import com.facebook.react.ReactInstanceManager
import com.facebook.react.ReactRootView
import com.facebook.react.common.LifecycleState
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler
import com.facebook.react.shell.MainReactPackage
import com.facebook.soloader.SoLoader

class TestActivity : Activity(), DefaultHardwareBackBtnHandler {
    private var mReactInstanceManager: ReactInstanceManager? = null
    private var mReactRootView: ReactRootView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SoLoader.init(this, false)

        Log.d("TestActivity", "onCreate() called")

        try {
            val reactNativeApplication = applicationContext
            if (reactNativeApplication != null) {
                mReactInstanceManager = ReactInstanceManager.builder()
                        .setApplication(application)
                        .setCurrentActivity(this)
                        .setBundleAssetName("index.android.bundle") // Or specify your own bundle URL
                        .setJSMainModulePath("index") // Or specify your own module name
                        .addPackage(MainReactPackage())
                        .setUseDeveloperSupport(BuildConfig.DEBUG)
                        .setInitialLifecycleState(LifecycleState.RESUMED)
                        .build()
            } else {
                // Log an error or handle the case where application context is null
                // For example, you could show a toast message and finish the activity
                Log.e("TestActivity", "Application context is null")
                finish()
                return
            }
        } catch (e: Exception) {
            Log.e("TestActivity", "Error: ", e)
            finish()
            return
        }

//
        mReactRootView = ReactRootView(this)
        mReactRootView!!.startReactApplication(mReactInstanceManager, "RNSampleComponent", null)
//
        setContentView(mReactRootView)
    }

    override fun invokeDefaultOnBackPressed() {
        TODO("Not yet implemented")
    }


}