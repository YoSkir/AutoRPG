package ys.gme.autorpg.util;

/**
 * @author yoskir
 */
public interface Constant {
    //場景名稱
    enum SceneNameEnum {main,title,gmMenu}
    //檔案類型
    enum DataFileTypeEnum {save,name}
    //國籍
    enum Nation {Western, Chinese, Japanese, Mix}
    //隊伍類型
    enum TeamType{Player,Other,Neutral,Enemy}
    //預設起始位置
    Double START_X=200.0;
    Double START_Y=150.0;
    String SAVE_PATH=System.getProperty("user.home")+"/data";
    /**
     * 方便偵錯的訊息
     * @param params 數量、型別不定的傳入參數
     */
    static void DebugLog(Object... params){
        //獲取呼叫debug log的線程資訊
        StackTraceElement[] stackTrace=Thread.currentThread().getStackTrace();
        String className,methodName;
        if(stackTrace.length>2){
            StackTraceElement caller=stackTrace[2];
            className=caller.getClassName();
            methodName=caller.getMethodName();
        }else {
            className="未知類";
            methodName="未知方法";
        }
        StringBuilder debugMessage=new StringBuilder("|測試訊息| Class名稱: "+className+" Method名稱: "+methodName+"\n");
        for(Object param:params){
            debugMessage.append(param).append(" ");
        }
        System.out.println(debugMessage);
    }
}
