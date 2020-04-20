package com.example.yxys;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import android.graphics.Shader;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class CanvasView extends View {
//    private Paint p;
    private Paint bPoint;
//    private Path path;
//    private Region blackRegion;
    private int selectedFlag = -1;
    List<PartBean> partBeans = new ArrayList<>();
    private static final String TAG = "CanvasView";
    private Region totalRegion;
    public CanvasView(Context context) {
        super(context);
        init();
    }

    private void init() {
        initData();

        // 创建画笔对象
        bPoint = new Paint();
        // 设置画笔为边框模式
        bPoint.setStyle(Paint.Style.STROKE);
        // 设置边框宽度
        bPoint.setStrokeWidth(10);
        // 设置边框颜色
        bPoint.setColor(getResources().getColor(R.color.bn_grey_3));

    }

    private void initData() {
        PartBean partBean = new PartBean();
        partBean.setX(70);
        partBean.setY(130);
        List<DotBean> dotBeans = new ArrayList<>();
        dotBeans.add(new DotBean(70, 130, 405, 130));
        dotBeans.add(new DotBean(405, 130, 430, 100));
        dotBeans.add(new DotBean(430, 100, 470, 100));
        dotBeans.add(new DotBean(470, 100, 495, 130));
        dotBeans.add(new DotBean(495, 130, 830, 130));
        dotBeans.add(new DotBean(830, 130, 830, 230));
        dotBeans.add(new DotBean(830, 230, 535, 230));
        dotBeans.add(new DotBean(535, 230, 520, 250));
        dotBeans.add(new DotBean(520, 250, 330, 250));
        dotBeans.add(new DotBean(330, 250, 315, 230));
        dotBeans.add(new DotBean(315, 230, 70, 230));
        dotBeans.add(new DotBean(70, 230, 70, 130));
        partBean.setDotList(dotBeans);
        partBean.setStyle(1);
        partBean.setResource(R.color.bn_grey_1);
        partBeans.add(partBean);

        PartBean partBean2 = new PartBean();
        partBean2.setX(70);
        partBean2.setY(500);
        partBean2.getDotList().add(new DotBean(70, 500, 850, 500));
        partBean2.getDotList().add(new DotBean(850, 500, 850, 800));
        partBean2.getDotList().add(new DotBean(850, 800, 70, 800));
        partBean2.getDotList().add(new DotBean(70, 800, 70, 500));
        partBean2.setStyle(2);
        partBean2.setResource(R.mipmap.icon_bg);
        partBeans.add(partBean2);
    }

    /**
     * 修改背景
     */
    public void changeBackground(int style, int resource){
        if(selectedFlag == -1) {
            return;
        }
        PartBean partBean = partBeans.get(selectedFlag);
        partBean.setStyle(style);
        partBean.setResource(resource);
        invalidate();
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        p.setFilterBitmap(true);

        for (int i = 0; i < partBeans.size(); i++) {
            // 创建画笔对象
            Path path = new Path();
            // 创建区域对象
            Region region = new Region();
            // 获取对象
            PartBean partBean = partBeans.get(i);
            // 设置画笔为填充模式
            p.setStyle(Paint.Style.FILL);
            // 设置填充资源
            p.setShader(getShader(partBean.getResource(),partBean.getStyle()));
            // 将点移动到开始位置
            path.moveTo(partBean.getX(), partBean.getY());
            for (DotBean dotBean : partBean.getDotList()) {
                // 开始描点画线
                path.quadTo(dotBean.getX1(), dotBean.getY1(), dotBean.getX2(), dotBean.getY2());
            }
            // 结束描点画线
            path.close();
            // 绘制图形
            canvas.drawPath(path, p);
            // 设置区域
            region.setPath(path, totalRegion);
            // 将区域保存到对象中
            partBean.setRegion(region);
            // 判断是否有被点击选中的区域
            if (selectedFlag == i) {
                // 绘制选中效果边框
                canvas.drawPath(path, bPoint);
            }
        }
    }

    private Shader getShader(int resource , int style) {
        if(style == 1) {
            return new LinearGradient(0, 0, 400, 400, resource, resource, Shader.TileMode.REPEAT);
        } else  {
            return new BitmapShader(BitmapFactory.decodeResource(this.getResources(), resource), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        // 获取全局区域
        totalRegion = new Region(0, 0, w, h);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 获取手指在屏幕上的位置（x，y）
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN: // 手指按下
            case MotionEvent.ACTION_MOVE: // 手指移动
                break;
            case MotionEvent.ACTION_UP: // 手指抬起
                // 获取手指抬起时所在区域
                selectedFlag = getTouchFlag(x, y);
                // 刷新页面重新绘制
                invalidate();
                break;
        }
        return true;
    }

    /**
     * 判断落在哪个区域
     */
    private int getTouchFlag(int x, int y) {
        for (int i = 0; i < partBeans.size(); i++) {
            if(partBeans.get(i).getRegion().contains(x, y)){
                return i;
            }
        }
        return -1;
    }
}
