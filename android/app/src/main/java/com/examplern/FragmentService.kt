package com.examplern

import android.app.Activity
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod

class FragmentService(private val reactContext: ReactApplicationContext): ReactContextBaseJavaModule(reactContext) {
    override fun getName(): String {
        return "FragmentModule";
    }

    @ReactMethod
    fun showFragment() {
        val currentActivity: Activity? = currentActivity
        currentActivity?.let { activity ->
            // Create an instance of your fragment
            val fragment = MyFragment()

            // Begin a fragment transaction
            val fragmentManager: FragmentManager = (activity as FragmentActivity).supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

            // Replace any existing fragment with your new fragment
            fragmentTransaction.replace(android.R.id.content, fragment)

            // Optionally add the transaction to the back stack
            fragmentTransaction.addToBackStack(null)

            // Commit the transaction
            fragmentTransaction.commit()
        }
    }
}