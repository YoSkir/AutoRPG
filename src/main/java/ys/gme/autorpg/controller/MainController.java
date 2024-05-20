package ys.gme.autorpg.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
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

    @Override
    public void preload() {
        Scene scene= GameManager.MANAGER.getSceneManager().getScene
                (Constant.getSceneName(Constant.SceneNameEnum.main));
        scene.setOnMouseMoved(event->{
            double y=event.getY();
            double height=scene.getHeight();
            toolBar.setVisible(y > height - toolBar.getHeight());
        });
    }

    @Override
    public AnchorPane getView() {
        return main;
    }
}
