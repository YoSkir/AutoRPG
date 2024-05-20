package ys.gme.autorpg.scene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Setter;
import ys.gme.autorpg.AutoRpgApplication;
import ys.gme.autorpg.util.Constant;
import ys.gme.autorpg.controller.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 場景管理層
 * @author yoskir
 */
public class SceneManager {
    @Setter
    private Stage stage;
    private final Map<String, Scene> sceneMap=new HashMap<>();
    private final Map<String,Controller> controllerMap=new HashMap<>();

    /**
     * 更換場景
     * @param sceneName 場景名稱
     * */
    public void loadScene(String sceneName){
        Scene nextScene=sceneMap.getOrDefault(sceneName,createScene(sceneName));
        if(nextScene==null){
            return;
        }
        controllerMap.get(sceneName).preload();
        stage.setScene(nextScene);
    }

    /**
     * 獲得特定場景
     * @param sceneName 場景名稱
     * @return 場景
     */
    public Scene getScene(String sceneName){
        return sceneMap.getOrDefault(sceneName,null);
    }

    /**
     * 創建場景
     * @param sceneName 場景名稱
     */
    private Scene createScene(String sceneName) {
        String fxmlFile=sceneName+".fxml";
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(AutoRpgApplication.class.getResource(fxmlFile));
            Scene scene = new Scene(fxmlLoader.load(), 400, 300);
            scene.getStylesheets().add(
                    Objects.requireNonNull(getClass().getResource("/css/dark_theme.css")).toExternalForm());
            sceneMap.put(sceneName,scene);
            controllerMap.put(sceneName,fxmlLoader.getController());
            return scene;
        } catch (IOException e) {
            Constant.DebugLog("fxml讀取失敗",e.getMessage());
            return null;
        }
    }
}
