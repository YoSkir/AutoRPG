package ys.gme.autorpg.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import ys.gme.autorpg.component.NameComponent;
import ys.gme.autorpg.util.Constant;
import ys.gme.autorpg.GameManager;

public class TitleController implements Controller {

    @FXML
    protected void onHelloButtonClick() {
        GameManager.MANAGER.getSceneManager().loadScene
                (Constant.SceneNameEnum.main.name());
    }

    @Override
    public void preload() {
        GameManager.MANAGER.getLoadingManager().loadNameList();
    }

    @Override
    public AnchorPane getView() {
        return null;
    }
}