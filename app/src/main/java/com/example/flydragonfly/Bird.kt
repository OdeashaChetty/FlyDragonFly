package com.example.flydragonfly

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Rect

class Bird(context: Context) {
     val bitmap: Bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.dragon)
     val maxFrame = 3
    var currentFrame = 0
    var birdX = AppConstants.SCREEN_WIDTH /2
    var birdY = AppConstants.SCREEN_HEIGHT/2
    var velocity = 0


    fun draw(canvas: Canvas) {
        val srcRect = Rect(
            currentFrame * bitmap.width / maxFrame,
            0,
            (currentFrame + 1) * bitmap.width / maxFrame,
            bitmap.height
        )
        val dstRect = Rect(birdX, birdY, birdX + bitmap.width / maxFrame, birdY + bitmap.height)
        canvas.drawBitmap(bitmap, srcRect, dstRect, null)
    }

    fun update() {
        birdY += velocity
        currentFrame = (currentFrame + 1) % maxFrame
    }
}
