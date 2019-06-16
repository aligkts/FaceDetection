package com.aligkts.facedetection

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF

/**
 * Created by Ali Göktaş on 16,June,2019
 */

class RectOverlay(
    private val graphicOverlay: GraphicOverlay,
    private val rect: Rect
) : GraphicOverlay.Graphic(graphicOverlay) {

    private val RECT_COLOR = Color.RED
    private val strokeWidth = 4.0f
    private val rectPaint: Paint = Paint()

    init {
        rectPaint.color = RECT_COLOR
        rectPaint.style = Paint.Style.STROKE
        rectPaint.strokeWidth = strokeWidth
        postInvalidate()
    }

    override fun draw(canvas: Canvas) {
        val rectF = RectF(rect)
        rectF.left = translateX(rectF.left)
        rectF.right = translateX(rectF.right)
        rectF.top = translateY(rectF.top)
        rectF.bottom = translateY(rectF.bottom)
        canvas.drawRect(rectF, rectPaint)
    }

}
