package com.metatribe.content.feed.data.source

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.metatribe.content.feed.domain.vo.ObjectiveVO
import com.metatribe.content.feed.domain.vo.UserVO

class LocalDataSource(private val context: Context) {

    fun getPostsFromAssets(): UserVO {
        val jsonString = context.assets.open("user.json")
            .bufferedReader().use { it.readText() }

        Log.d("LocalDataSource", "JSON: $jsonString")

        val type = object : TypeToken<UserVO>() {}.type
        return Gson().fromJson(jsonString, type)
    }
}
