package ys.gme.autorpg.util;

import ys.gme.autorpg.AutoRpgApplication;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * 檔案資料存取類
 * @author yoskir
 */
public class DataManager {
    public boolean saveStringToFile(String jsonStr, Constant.DataFileTypeEnum dataFileTypeEnum) {
        if(!isDirectoryAvailable()){
            Constant.DebugLog("資料夾不存在且創建失敗");
            return false;
        }
        Path path= getPathAddFileName(dataFileTypeEnum);
        try {
            Files.writeString(path, jsonStr);
            return true;
        } catch (IOException e) {
            Constant.DebugLog("資料儲存失敗 "+ e.getMessage());
            return false;
        }
    }
    public String readStringFromFile(Constant.DataFileTypeEnum dataFileTypeEnum){
        try {
            Path path=getPathAddFileName(dataFileTypeEnum);
            assert path != null;
            return Files.readString(path);
        } catch (IOException e) {
            Constant.DebugLog("資料讀取失敗 "+e.getMessage());
            return "";
        }
    }

    /**
     * 回傳包含檔名的完整儲存路徑
     * @param dataFileTypeEnum 資料檔案類別
     * @return 完整路徑
     */
    private Path getPathAddFileName(Constant.DataFileTypeEnum dataFileTypeEnum) {
        return switch (dataFileTypeEnum) {
            case save -> Paths.get(Constant.SAVE_PATH +"/save.sv");
            case name -> Paths.get(Objects.requireNonNull(getDataFileURI("/data/name_data.txt")));
        };
    }

    /**
     * 獲得程式內部檔案的URI
     * @param filePath 檔案resource中相對位置
     * @return URI
     */
    private URI getDataFileURI(String filePath){
        try {
            return Objects.requireNonNull(getClass().getResource(filePath)).toURI();
        }catch (URISyntaxException e) {
            Constant.DebugLog("URI獲取失敗",e.getMessage());
            return null;
        }
    }

    /**
     * 確認儲存資料夾存在 如不存在則創建
     * @return 資料夾是否存在
     */
    private boolean isDirectoryAvailable() {
        File directory=new File(Constant.SAVE_PATH);
        if(!directory.exists()){
            boolean isCreated=directory.mkdirs();
            if(!isCreated){
                Constant.DebugLog("創建備份資料夾失敗");
                return false;
            }
        }
        return true;
    }
}
