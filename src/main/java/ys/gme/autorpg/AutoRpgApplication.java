package ys.gme.autorpg;

import javafx.application.Application;
import javafx.stage.Stage;
import ys.gme.autorpg.util.Constant;

public class AutoRpgApplication extends Application {
    @Override
    public void start(Stage stage){
        stage.setTitle("AutoRPG");
        //將初始舞台存入場景管理類
        GameManager.MANAGER.getSceneManager().setStage(stage);
        GameManager.MANAGER.getSceneManager().loadScene
                (Constant.getSceneName(Constant.SceneNameEnum.title));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}