package ys.gme.autorpg.util.game.paint;

import javafx.scene.paint.Color;
import lombok.Getter;
import lombok.Setter;
import ys.gme.autorpg.util.Constant;

/**
 * 顯示在畫面上的資訊
 * @author yoskir
 */
@Getter
public class PaintInfo {
    private double x;
    private double y;
    @Setter
    private Color color;
    @Setter
    private double radius;
    @Setter
    private String name;
    @Setter//被選中時外框
    private boolean chosen;

    public PaintInfo(Color color,double radius,String name){
        setColor(color);
        setRadius(radius);
        setName(name);
        chosen=false;
        double x= Constant.START_X;
        double y=Constant.START_Y;
        setPosition(x,y);
    }

    /**
     * 設定位置
     */
    public void setPosition(double x,double y){
        this.x=x;this.y=y;
    }
}
