package ys.gme.autorpg.character;

import lombok.Setter;
import ys.gme.autorpg.GameManager;
import ys.gme.autorpg.component.name.Nation;
import ys.gme.autorpg.util.Constant;
import ys.gme.autorpg.component.NameComponent;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

/**
 * 生命管理層
 * @author yoskir
 */
public class LiveManager {
    private final Map<Constant.Nation,List<String>> firstNameMap=new HashMap<>();
    private final Map<Constant.Nation,List<String>> lastNameMap=new HashMap<>();

    private NameComponent nameList;
    public void setNameList(NameComponent nameComponent){
        nameList=nameComponent;
        for(Nation nation:nameList.getNationalNameList()){
            firstNameMap.put(nation.getNation(),nation.getFirstNames());
            lastNameMap.put(nation.getNation(),nation.getLastNames());
        }
    }

    /**
     * 計算升級所需經驗值
     * @param currentLevel 目前等級
     * @return 所需經驗值
     */
    public int getLvUpExp(int currentLevel){
        return 10*currentLevel;
    }

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
    public String getName(Constant.Nation nation) {
        List<String> firstNameList;
        List<String> lastNameList;
        //米克斯名字列表
        if (Objects.requireNonNull(nation) == Constant.Nation.米克斯) {
            Constant.Nation secondNation;
            Constant.Nation firstNation;
            //找非米克斯名列表
            do {
                secondNation = getNation();
            } while (secondNation.equals(Constant.Nation.米克斯));
            //找國籍不與名重複列表
            do {
                firstNation=getNation();
            }while (firstNation.equals(Constant.Nation.米克斯)||firstNation.equals(secondNation));
            firstNameList = firstNameMap.get(firstNation);
            lastNameList = lastNameMap.get(secondNation);
        } else {
            firstNameList = firstNameMap.get(nation);
            lastNameList = lastNameMap.get(nation);
        }
        String firstName=firstNameList.get(GameManager.MANAGER.getRandomInt(1,firstNameList.size())-1);
        String lastName=lastNameList.get(GameManager.MANAGER.getRandomInt(1,lastNameList.size())-1);
        //中國名一半機率雙字
        if(nation.equals(Constant.Nation.中國)){
            if(GameManager.MANAGER.getRandomInt(0,1)>0){
                firstName+=firstNameList.get(GameManager.MANAGER.getRandomInt(1,firstNameList.size())-1);
            }
        }else if(nation.equals(Constant.Nation.米克斯)){
            lastName+=" ";
        }else if(nation.equals(Constant.Nation.西方)){
            lastName+="．";
        }
        return lastName+firstName;
    }

    /**
     * 獲得隨機國籍
     * @return 國籍
     */
    public Constant.Nation getNation() {
        return switch (GameManager.MANAGER.getRandomInt(1,4)){
            case 1-> Constant.Nation.日本;
            case 2-> Constant.Nation.中國;
            case 3-> Constant.Nation.西方;
            default -> Constant.Nation.米克斯;
        };
    }
}
