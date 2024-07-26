package com.example.flydragonfly

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect

class GameEngine(private val context: Context) {
     val backgroundImage: BackgroundImage = BackgroundImage()
     val bird: Bird = Bird(context)

        var gameState: Int = 0
     var frameDelayCounter: Int = 0
     val frameDelay: Int = 5


    fun updateAndDrawBackgroundImage(canvas: Canvas) {
        backgroundImage.backgroundImageX -= backgroundImage.backgroundVelocity
        if (backgroundImage.backgroundImageX < -AppConstants.bitmapBank.getBackgroundWidth()) {
            backgroundImage.backgroundImageX = 0
        }

        val backgroundBitmap = AppConstants.bitmapBank .mainbackground
        val backgroundWidth = AppConstants.bitmapBank.getBackgroundWidth()

        // Draw the first background
        canvas.drawBitmap(backgroundBitmap, backgroundImage.backgroundImageX.toFloat(), backgroundImage.backgroundImageY.toFloat(), null)

        // Draw the second background if needed
        if (backgroundImage.backgroundImageX < -(backgroundWidth - AppConstants.SCREEN_WIDTH)) {
            canvas.drawBitmap(
                backgroundBitmap,
                (backgroundImage.backgroundImageX + backgroundWidth).toFloat(),
                backgroundImage.backgroundImageY.toFloat(),
                null
            )
        }
    }

    fun updateAndDrawBird(canvas: Canvas) {

        if(gameState == 1)
        {
            // Update bird position and velocity
            if (bird.birdY < (AppConstants.SCREEN_HEIGHT - AppConstants.bitmapBank.getBirdHeight()) || bird.velocity < 0) {
                bird.velocity += AppConstants.gravity
                bird.birdY += bird.velocity
            }
        }


        // Draw bird
        val srcRect = Rect(
            bird.currentFrame * bird.bitmap.width / bird.maxFrame,
            0,
            (bird.currentFrame + 1) * bird.bitmap.width / bird.maxFrame,
            bird.bitmap.height
        )

        val dstRect = Rect(
            bird.birdX,
            bird.birdY,
            bird.birdX + bird.bitmap.width / bird.maxFrame,
            bird.birdY + bird.bitmap.height
        )

        canvas.drawBitmap(bird.bitmap, srcRect, dstRect, null)

        frameDelayCounter++
        if (frameDelayCounter >= frameDelay) {
            bird.currentFrame = (bird.currentFrame + 1) % bird.maxFrame
            frameDelayCounter = 0
        }
    }

}
