package io.github.iamvaliyev.multitabmenu.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Emil Valiyev on 12/6/16.
 */
public class Triangle extends View {

    Paint mPaint;

    Path mPath;

    int color = 0;

    public enum Direction {
        NORTH, SOUTH, EAST, WEST
    }

    public Triangle(Context context) {
        super(context);
        create();
    }

    public Triangle(Context context, AttributeSet attrs) {
        super(context, attrs);
        create();
    }

    public void setColor(int color) {
        mPaint.setColor(color);
        invalidate();
    }

    private void create() {
        mPaint = new Paint();
        mPaint.setStyle(Style.FILL);

        if (color != 0)
            mPaint.setColor(color);
        else
            mPaint.setColor(Color.parseColor("#DD0A2F"));

    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPath = calculate(Direction.SOUTH);
        canvas.drawPath(mPath, mPaint);
    }

    private Path calculate(Direction direction) {
        Point p1 = new Point();
        p1.x = 0;
        p1.y = 0;

        Point p2 = null, p3 = null;

        int width = getWidth();

        if (direction == Direction.NORTH) {
            p2 = new Point(p1.x + width, p1.y);
            p3 = new Point(p1.x + (width / 2), p1.y - width);
        } else if (direction == Direction.SOUTH) {
            p2 = new Point(p1.x + width, p1.y);
            p3 = new Point(p1.x + (width / 2), p1.y + width);
        } else if (direction == Direction.EAST) {
            p2 = new Point(p1.x, p1.y + width);
            p3 = new Point(p1.x - width, p1.y + (width / 2));
        } else if (direction == Direction.WEST) {
            p2 = new Point(p1.x, p1.y + width);
            p3 = new Point(p1.x + width, p1.y + (width / 2));
        }

        Path path = new Path();
        path.moveTo(p1.x, p1.y);
        path.lineTo(p2.x, p2.y);
        path.lineTo(p3.x, p3.y);

        return path;
    }
}