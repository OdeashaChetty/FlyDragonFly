package com.example.flydragonfly

import android.content.Context
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView

class GameView(context: Context) : SurfaceView(context), SurfaceHolder.Callback {

     var gameThread: GameThread

    init {
        holder.addCallback(this)
        isFocusable = true
        gameThread = GameThread(holder)
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        if (!gameThread.isRunning) {
            gameThread = GameThread(holder)
            gameThread.start()
        } else {
            gameThread.start()
        }
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        // Handle surface changes
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        if (gameThread.isRunning) {
            gameThread.setIsRunning(false)
            var retry = true
            while (retry) {
                try {
                    gameThread.join()
                    retry = false
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }
    }
    override fun onTouchEvent(event: MotionEvent): Boolean {
        val action = event.action
        if (action == MotionEvent.ACTION_DOWN) {
            AppConstants.gameEngine.gameState = 1
            AppConstants.gameEngine.bird.velocity = AppConstants.VELOCITY_WHEN_JUMPED
        }
        return true
    }
}
