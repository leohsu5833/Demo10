package com.example.demo10

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class MyView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {
    companion object {
        const val INTRO = "These animations illustrate how a parametric Bézier curve is constructed. The parameter t ranges from 0 to 1. In the simplest case, a first-order Bézier curve, the curve is a straight line between the control points.\n" +
                "\n" +
                "For a second-order (quadratic) Bézier curve, first we find two intermediate points that are t along the lines between the three control points. Then we perform the same interpolation step again and find another point that is t along the line between those two intermediate points. Plotting this last point yields a quadratic Bézier curve. The same steps can be repeated for higher orders.";
    }
    constructor(context: Context?) : this(context, null, 0)
    constructor(context: Context?, attrs: AttributeSet?) :
            this(context, attrs, 0)

    init {

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paintBackground(canvas)
        paint1(canvas)
        paint2(canvas)
        paint3(canvas)
        paint4(canvas)
        paint5(canvas)
    }

    private fun paint5(canvas: Canvas?) {
        val p5 = Paint()
        val path1 = Path()
        path1.moveTo(950F,50F)
        p5.textSize=30f
        path1.quadTo(1500F, 1800F,50F, 1200F)
        canvas!!.drawTextOnPath(INTRO, path1, 0F,0F, p5)
    }

    private fun paint4(canvas: Canvas?) {
        for (i in 1..10) {

            val p4 = Paint()
            p4.style = Paint.Style.STROKE
            p4.strokeWidth = 4.0f
            p4.color = Color.argb(255, 255 - 20 * i, 0 + 20 * i, 0)
            val path1 = Path()
            path1.moveTo(50F, 300F)
            //path1.lineTo(850F, 300F)
            path1.quadTo(450F, -300F + i * 200F, 850F, 300F)
            canvas!!.drawPath(path1, p4)
        }
    }

    private fun paint3(canvas: Canvas?) {
        val p3 = Paint()
        p3.style = Paint.Style.STROKE
        p3.strokeWidth = 20.0f
        p3.color = Color.GRAY
        p3.strokeCap = Paint.Cap.BUTT
        canvas!!.drawLine(100f, 100f, 100f, 500f, p3)
        canvas.drawLine(100f, 500f, 500f, 500f, p3)
        p3.strokeCap = Paint.Cap.ROUND
        canvas!!.drawLine(130f, 70f, 130f, 470f, p3)
        canvas.drawLine(130f, 470f, 470f, 470f, p3)
        p3.strokeCap = Paint.Cap.SQUARE
        canvas!!.drawLine(160f, 40f, 160f, 440f, p3)
        canvas.drawLine(160f, 440f, 460f, 440f, p3)
    }

    private fun paint1(canvas: Canvas?) {
        val p2 = Paint()
        p2.style = Paint.Style.FILL
        p2.color = Color.GREEN
        p2.isAntiAlias=false
        canvas!!.drawCircle(150f, 150f, 100f, p2)
        p2.color = Color.BLUE
        p2.isAntiAlias = true
        canvas.drawCircle(200f, 150f, 100f, p2)
        p2.color = Color.RED
        val rectF = RectF()
        rectF.set(150f,150f,550f,350f)
        canvas.drawOval(rectF, p2)
    }

    private fun paint2(canvas: Canvas?) {
        val p3 = Paint()
        p3.style = Paint.Style.STROKE
        p3.strokeWidth = 3.0f
        p3.color = Color.CYAN
        val rectF = RectF()
        rectF.set(150f, 550f, 550f, 1050f)
        canvas!!.drawArc(rectF, 0f, 90f, false, p3)
        canvas.drawArc(rectF, 180f, 110f, true, p3)

    }
    private fun paintBackground(canvas: Canvas?) {
        val p1 = Paint()
        p1.style = Paint.Style.FILL
        p1.color = Color.YELLOW
        canvas!!.drawPaint(p1)
    }
}