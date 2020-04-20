package com.example.yxys;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;

import java.util.ArrayList;
import java.util.List;

public class PartBean {

    // 起点x
    private int x;
    // 起点y
    private int y;
    // 填充样式（1-颜色；2-图片）
    private int style;
    // 填充资源（色值id/图片id）
    private int resource;
    private List<DotBean> dotList = new ArrayList<>();
    // 画笔
    private Paint paint;
    // 路径
    private Path path;
    // 区域
    private Region region;


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    public List<DotBean> getDotList() {
        return dotList;
    }

    public void setDotList(List<DotBean> dotList) {
        this.dotList = dotList;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
