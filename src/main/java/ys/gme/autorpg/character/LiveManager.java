package ys.gme.autorpg.character;

import ys.gme.autorpg.GameManager;
import ys.gme.autorpg.component.name.Nation;
import ys.gme.autorpg.util.Constant;
import ys.gme.autorpg.component.NameComponent;

import java.util.*;

/**
 * 生命管理層
 * @author yoskir
 */
public class LiveManager {
    private final Map<Constant.Nation,List<String>> firstNameMap=new HashMap<>();
    private final Map<Constant.Nation,List<String>> lastNameMap=new HashMap<>();

    /**
     * 載入名稱資料的Map
     * @param nameList 名稱資料容器
     */
    public void setNameList(NameComponent nameList){
        for(Nation nation:nameList.getNationalNameList()){
            firstNameMap.put(nation.getNation(),nation.getFirstNames());
            lastNameMap.put(nation.getNation(),nation.getLastNames());
        }
    }

    /**
     * 創建角色
     * @return 創建的角色
     */
    public GameCharacter createCharacter(){
        return new GameCharacter();
    }

    /**
     * 計算升級所需經驗值
     * @param currentLevel 目前等級
     * @return 所需經驗值
     */
    public int calculateLvUpExp(int currentLevel){
        return 10*currentLevel;
    }

    public double calculateRadius()

    /**
     * 計算能力值成長量
     * @param potential 能力值潛力
     * @return 成長量
     */
    public int getStatGrow(int potential){
        int growRate=Math.min(80+potential*5,90) ;
        int statGrow=0;
        int growLottery= GameManager.MANAGER.getRandomInt(0,100);
        while (growLottery<growRate){
            statGrow++;
            growLottery=GameManager.MANAGER.getRandomInt(0,100);
            growRate= Math.max(growRate - 20, 10);
        }
        return statGrow;
    }

    /**
     * 獲得隨機名字
     * @return 名字
     */
    public String randomName(Constant.Nation nation) {
        List<String> firstNameList;
        List<String> lastNameList;
        //米克斯名字列表
        if (Objects.requireNonNull(nation) == Constant.Nation.Mix) {
            Constant.Nation secondNation;
            Constant.Nation firstNation;
            //找非米克斯名列表
            do {
                secondNation = randomNation();
            } while (secondNation.equals(Constant.Nation.Mix));
            //找國籍不與名重複列表
            do {
                firstNation= randomNation();
            }while (firstNation.equals(Constant.Nation.Mix)||firstNation.equals(secondNation));
            firstNameList = firstNameMap.get(firstNation);
            lastNameList = lastNameMap.get(secondNation);
        } else {
            firstNameList = firstNameMap.get(nation);
            lastNameList = lastNameMap.get(nation);
        }
        String firstName=firstNameList.get(GameManager.MANAGER.getRandomInt(1,firstNameList.size())-1);
        String lastName=lastNameList.get(GameManager.MANAGER.getRandomInt(1,lastNameList.size())-1);
        //中國名一半機率雙字
        if(nation.equals(Constant.Nation.Chinese)){
            if(GameManager.MANAGER.getRandomInt(0,1)>0){
                firstName+=firstNameList.get(GameManager.MANAGER.getRandomInt(1,firstNameList.size())-1);
            }
        }else if(nation.equals(Constant.Nation.Mix)){
            lastName+=" ";
        }else if(nation.equals(Constant.Nation.Western)){
            lastName+="．";
        }
        return lastName+firstName;
    }

    /**
     * 獲得隨機國籍
     * @return 國籍
     */
    public Constant.Nation randomNation() {
        return switch (GameManager.MANAGER.getRandomInt(1,4)){
            case 1-> Constant.Nation.Japanese;
            case 2-> Constant.Nation.Chinese;
            case 3-> Constant.Nation.Western;
            default -> Constant.Nation.Mix;
        };
    }
}
