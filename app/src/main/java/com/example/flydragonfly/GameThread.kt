package com.example.flydragonfly

import android.graphics.Canvas
import android.os.SystemClock
import android.util.Log
import android.view.SurfaceHolder

class GameThread(val surfaceHolder: SurfaceHolder) : Thread() {

    @Volatile
    var isRunning: Boolean = true

    private var startTime: Long = 0
    private var loopTime: Long = 0
    private val delay: Long = 33

    override fun run() {
        while (isRunning) {
            startTime = SystemClock.uptimeMillis()
            val canvas: Canvas? = surfaceHolder.lockCanvas(null)
            if (canvas != null) {
                synchronized(surfaceHolder) {
                    AppConstants.gameEngine.updateAndDrawBackgroundImage(canvas)
                    AppConstants.gameEngine.updateAndDrawBird(canvas)
                }
                surfaceHolder.unlockCanvasAndPost(canvas)
            }
            loopTime = SystemClock.uptimeMillis() - startTime
            if (loopTime < delay) {
                try {
                    Thread.sleep(delay - loopTime)
                } catch (e: InterruptedException) {
                    Log.e("Interrupted", "Interrupted while sleeping")
                }
            }
        }
    }

    fun setIsRunning(isRunning: Boolean) {
        this.isRunning = isRunning
    }
}
