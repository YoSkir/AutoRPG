package ys.gme.autorpg;

import lombok.Getter;
import ys.gme.autorpg.character.LiveManager;
import ys.gme.autorpg.scene.SceneManager;
import ys.gme.autorpg.util.DataManager;
import ys.gme.autorpg.util.JsonMapper;
import ys.gme.autorpg.util.LoadingManager;

import java.util.Random;

/**
 * 中央管理
 * @author yoskir
 */
@Getter
public class GameManager {
    public final static GameManager MANAGER=new GameManager();
    private final SceneManager sceneManager=new SceneManager();
    private final LiveManager liveManager=new LiveManager();
    private final JsonMapper jsonMapper=new JsonMapper();
    private final DataManager dataManager=new DataManager();
    private final LoadingManager loadingManager=new LoadingManager();

    private final Random random=new Random();

    /**
     * 獲得隨機整數
     * @param min 最低值
     * @param max 最高值
     * @return 隨機數
     */
    public int getRandomInt(int min,int max){
        return random.nextInt(min,max+1);
    }

}
