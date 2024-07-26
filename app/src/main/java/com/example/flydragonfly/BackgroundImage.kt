package com.example.flydragonfly

class BackgroundImage {
    var backgroundImageX: Int = 0
    var backgroundImageY: Int = 0
    var backgroundVelocity: Int = 0

    fun getX(): Int {
        return backgroundImageX
    }

    fun getY(): Int {
        return backgroundImageY
    }

    fun setX(backgroundImageX: Int) {
        this.backgroundImageX = backgroundImageX
    }

    fun setY(backgroundImageY: Int) {
        this.backgroundImageY = backgroundImageY
    }

    fun getVelocity(): Int {
        return backgroundVelocity
    }
}
