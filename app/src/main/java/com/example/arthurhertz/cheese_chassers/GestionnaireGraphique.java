package com.example.arthurhertz.cheese_chassers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class GestionnaireGraphique extends View implements View.OnTouchListener {
    int y;
    int x;
    Board leBoardXd;
    Modele modele = new Modele();

    public GestionnaireGraphique(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setOnTouchListener(this);
        this.setBackgroundColor(Color.RED);
        // Creation du tableau
        //leBoardXd = new Board(modele.monTableau);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Bitmap drawable = null;
        x = (int) motionEvent.getX();
        y = (int) motionEvent.getY();
        int xTab = determinationCaseTableauX(x);
        int yTab = determinationCaseTableauY(y);
        int valeur = modele.monTableau[xTab][yTab];

        switch (valeur) {
            case -1:
                drawable = BitmapFactory.decodeResource(getResources(), R.drawable.arrowdown);
                break;
            case 0:
                drawable = BitmapFactory.decodeResource(getResources(), R.drawable.peinture);
                break;
            case 1:
                drawable = BitmapFactory.decodeResource(getResources(), R.drawable.mouse);
                break;
            case 2:
                drawable = BitmapFactory.decodeResource(getResources(), R.drawable.cheese);
                break;
            case 3:
                drawable = BitmapFactory.decodeResource(getResources(), R.drawable.cat);
                break;
            case 4:
                drawable = BitmapFactory.decodeResource(getResources(), R.drawable.mousetrap);
                break;
            case 5:
                drawable = BitmapFactory.decodeResource(getResources(), R.drawable.mousetrapdesac);
                break;
            case 6:
                drawable = BitmapFactory.decodeResource(getResources(), R.drawable.mousetrapdesac);
                break;
                default:
                    break;
        }
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                leBoardXd.add(new BlockImage(x, y, drawable));
                break;
            default:
                break;
        }
        this.invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //leBoardXd.draw(canvas);
        canvas.drawCircle(100,100,50,new Paint());

        Log.d("debug", "REDRAWING");
    }

    public int determinationCaseTableauX(int xPix) {
        xPix = x;

        int xTab = xPix / 200;

        return xTab;
    }

    public int determinationCaseTableauY(int yPix) {
        yPix = y;

        int yTab = yPix / 200;

        return yTab;
    }

    public int[] determinationPixelCanvas(int xTab, int yTab) {

        int xPix = xTab * 200;
        int yPix = yTab * 200;

        return new int[]{xPix, yPix};
    }
}
