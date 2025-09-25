package com.project.router

import android.content.Context
import android.content.Intent

object IntentUtils {

    fun createLogonIntent(context: Context): Intent {
        return createIntent(context, "com.metatribe.account.login.ui.view.LoginMainActivity")
    }

    fun createProfileIntent(context: Context): Intent {
        return createIntent(context, "com.metatribe.account.profile.ui.view.ProfileMainActivity")
    }

    fun createFeedIntent(context: Context): Intent {
        return createIntent(context, "com.metatribe.content.feed.ui.view.FeedMainActivity")
    }


    private fun createIntent(context: Context, className: String): Intent =
        Intent().apply {
            setClassName(context.packageName, className)
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        }

}
