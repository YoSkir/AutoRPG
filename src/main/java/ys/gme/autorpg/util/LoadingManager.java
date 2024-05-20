package ys.gme.autorpg.util;

import ys.gme.autorpg.GameManager;
import ys.gme.autorpg.component.NameComponent;

/**
 * 讀取檔案用
 * @author yoskir
 */
public class LoadingManager {
    /**
     * 讀取名稱資料
     */
    public void loadNameList(){
        String nameListJson= GameManager.MANAGER.getDataManager().readStringFromFile(Constant.DataFileTypeEnum.name);
        NameComponent nameList=GameManager.MANAGER.getJsonMapper().jsonToObject(nameListJson,NameComponent.class);
        GameManager.MANAGER.getLiveManager().setNameList(nameList);
    }
}
