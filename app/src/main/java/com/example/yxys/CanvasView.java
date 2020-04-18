package com.example.yxys;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class CanvasView extends View {
    private Paint p;
    private Path path;

    public CanvasView(Context context) {
        super(context);
        init();
    }

    private void init() {
        p = new Paint();
        Shader shader = new BitmapShader(BitmapFactory.decodeResource(this.getResources(),R.mipmap.icon_bg),Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        p.setShader(shader);
        path = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        List<PointBean> pointBeans = new ArrayList<>();
        pointBeans.add(PointBean.add(70,130,405,130));
        pointBeans.add(PointBean.add(405,130,430,100));
        pointBeans.add(PointBean.add(430,100,470,100));
        pointBeans.add(PointBean.add(470,100,495,130));
        pointBeans.add(PointBean.add(495,130,830,130));
        pointBeans.add(PointBean.add(830,130,830,230));
        pointBeans.add(PointBean.add(830,230,535,230));
        pointBeans.add(PointBean.add(535,230,520,250));
        pointBeans.add(PointBean.add(520,250,330,250));
        pointBeans.add(PointBean.add(330,250,315,230));
        pointBeans.add(PointBean.add(315,230,70,230));
        pointBeans.add(PointBean.add(70,230,70,130));

        path.moveTo(70,130);
        for (PointBean pointBean: pointBeans) {
            path.quadTo(pointBean.getX1(),pointBean.getY1(),pointBean.getX2(),pointBean.getY2());
        }
        path.close();
        canvas.drawPath(path, p);
    }
}
