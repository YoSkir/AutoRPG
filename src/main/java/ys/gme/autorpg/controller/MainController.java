package ys.gme.autorpg.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import ys.gme.autorpg.util.Constant;
import ys.gme.autorpg.GameManager;

/**
 * 遊戲主畫面控制層
 * @author yoskir
 */
public class MainController implements Controller{
    @FXML
    private AnchorPane main;
    @FXML
    private ToolBar toolBar;
    @FXML
    private Pane gameDisplayArea;

    @Override
    public void preload() {
        //設定下方選單 滑鼠靠近才會顯示
        Scene scene= GameManager.MANAGER.getSceneManager().getScene
                (Constant.SceneNameEnum.main.name());
        scene.setOnMouseMoved(event->{
            double y=event.getY();
            double height=scene.getHeight();
            toolBar.setVisible(y > height - toolBar.getHeight());
        });
        //設定繪製的pane
        GameManager.MANAGER.getPaintManager().setGameDisplayArea(gameDisplayArea);
    }

    @Override
    public AnchorPane getView() {
        return main;
    }
}
