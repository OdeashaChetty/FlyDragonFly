package com.example.flydragonfly

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory

class BitmapBank(resources: Resources) {

     var mainbackground: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.mainbackground)
     var bird: Array<Bitmap?> = arrayOfNulls(2)

    init {
        mainbackground = scaleImage(mainbackground)
        bird[0] = BitmapFactory.decodeResource(resources, R.drawable.dragon)
        bird[1] = BitmapFactory.decodeResource(resources, R.drawable.dragon)
        bird[0] = scaleBirdImage(bird[0]!!)
        bird[1] = scaleBirdImage(bird[1]!!)
    }

    fun getBird(frame: Int): Bitmap? {
        return bird[frame]
    }

    fun getBirdWidth(): Int {
        return bird[0]?.width ?: 0
    }

    fun getBirdHeight(): Int {
        return bird[0]?.height ?: 0
    }

    fun getMainBackground(): Bitmap {
        return mainbackground
    }

    fun getBackgroundWidth(): Int {
        return mainbackground.width
    }

    fun getBackgroundHeight(): Int {
        return mainbackground.height
    }

    private fun scaleImage(bitmap: Bitmap): Bitmap {
        val widthHeightRatio = bitmap.width.toFloat() / bitmap.height.toFloat()
        val backgroundScaleWidth = (widthHeightRatio * AppConstants.SCREEN_HEIGHT).toInt()
        return Bitmap.createScaledBitmap(bitmap, backgroundScaleWidth, AppConstants.SCREEN_HEIGHT, false)
    }
    private fun scaleBirdImage(bitmap: Bitmap): Bitmap {
        // Define the new width and height for the bird image
        val newWidth = (bitmap.width * 1.5).toInt()
        val newHeight = (bitmap.height * 1.5).toInt()  // Increase the height by 50%
        return Bitmap.createScaledBitmap(bitmap, newWidth, newHeight, false)
    }
}
