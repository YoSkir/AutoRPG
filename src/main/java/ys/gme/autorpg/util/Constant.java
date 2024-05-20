package ys.gme.autorpg.util;

/**
 * @author yoskir
 */
public interface Constant {
    enum SceneNameEnum {main,title}
    enum DataFileTypeEnum {save,name}
    enum Nation {西方,中國,日本,米克斯}
    String SAVE_PATH=System.getProperty("user.home")+"/data";
    static String getSceneName(SceneNameEnum sceneNameEnum){
        return switch (sceneNameEnum){
            case main -> "main";
            case title -> "title";
        };
    }
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
