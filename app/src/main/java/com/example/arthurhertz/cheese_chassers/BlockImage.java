package com.example.arthurhertz.cheese_chassers;

import android.graphics.Bitmap;

public class BlockImage {

    int x;
    int y;
    Bitmap img;

    public BlockImage(int x, int y, Bitmap img) {
        this.x = x;
        this.y = y;
        this.img = img;
    }
}