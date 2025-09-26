package com.metatribe.content.feed.extension

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import com.google.gson.Gson
import java.io.IOException

fun bitmapToBase64(bitmap: Bitmap): String {

    val byteArrayOutputStream = java.io.ByteArrayOutputStream()
    bitmap.compress(Bitmap.CompressFormat.JPEG, 70, byteArrayOutputStream)
    val imageArray = byteArrayOutputStream.toByteArray()
    val imageBase64 = android.util.Base64.encodeToString(imageArray, android.util.Base64.DEFAULT)

    return imageBase64
}

fun base64ToBitmap(imgBase64: String): Bitmap {
    val decodedBytes = android.util.Base64.decode(imgBase64, android.util.Base64.DEFAULT)
    return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
}

fun getBitmapFromUri(context: Context, uri: Uri): Bitmap {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
        val source = ImageDecoder.createSource(context.contentResolver, uri)
        ImageDecoder.decodeBitmap(source)
    } else {
        MediaStore.Images.Media.getBitmap(context.contentResolver, uri)
    }
}

fun <T> getMockByJSON(context: Context, fileName: String, type: Class<T>): T {
    val jsonString = getJsonDataFromAsset(context, fileName)

    return Gson().fromJson(jsonString, type)
}

private fun getJsonDataFromAsset(context: Context, fileName: String): String {
    val jsonString: String
    try {
        jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
    } catch (ioException: IOException) {
        return ""
    }
    return jsonString
}

