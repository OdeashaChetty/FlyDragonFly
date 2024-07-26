package com.example.flydragonfly

import android.content.Context
import android.util.DisplayMetrics

class AppConstants private constructor() {
    companion object {
        // Variables for screen dimensions
        var SCREEN_WIDTH: Int = 0
        var SCREEN_HEIGHT: Int = 0
        const val gravity = 1
        const val VELOCITY_WHEN_JUMPED = -20

        lateinit var bitmapBank: BitmapBank
        lateinit var gameEngine: GameEngine

        // Game-related constants
        const val BIRD_WIDTH = 100
        const val BIRD_HEIGHT = 50
        const val BIRD_VELOCITY = 10

        const val PIPE_WIDTH = 100
        const val PIPE_HEIGHT = 300
        const val PIPE_GAP = 200

        // Initialization function to set screen dimensions and create instances
        fun initialization(context: Context) {
            val displayMetrics = DisplayMetrics()
            (context as? MainActivity)?.windowManager?.defaultDisplay?.getMetrics(displayMetrics)
            SCREEN_WIDTH = displayMetrics.widthPixels
            SCREEN_HEIGHT = displayMetrics.heightPixels

            // Directly initialize BitmapBank and GameEngine
            bitmapBank = BitmapBank(context.resources)
            gameEngine = GameEngine(context)
        }
    }
}
