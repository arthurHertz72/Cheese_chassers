package com.example.arthurhertz.cheese_chassers;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.LinkedList;

public class Board extends LinkedList<BlockImage>{
    int tableauModel[][];

    public Board(int[][] tableauModel) {
        this.tableauModel = tableauModel;
        new LinkedList<>();
    }

    public void draw(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        for (BlockImage blockImage: this
             ) {
            canvas.drawBitmap(blockImage.img,blockImage.x,blockImage.y,paint);
        }
    }
}

