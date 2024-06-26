package ys.gme.autorpg.character;

import ys.gme.autorpg.GameManager;
import ys.gme.autorpg.character.history.HistoryList;
import ys.gme.autorpg.util.Constant;
import ys.gme.autorpg.util.game.paint.PaintInfo;

/**
 * 遊戲人物類
 * @author yoskir
 */
public class GameCharacter {
    private int level,exp,lvUpExp;
    private int hp,maxHp,mp,maxMp;
    private int str,dex,mag,luc;
    private int money,salary;
    private String name,surName;
    private Constant.Nation nation;
    private Constant.TeamType teamType;
    private Team team;
    //歷史訊息
    private HistoryList historyList;
    //潛力值 影響升級時能力值多次增加的機率 每1加5% 最多10
    private final int potential_hp,potential_mp,potential_str,potential_dex,potential_mag,potential_luc;
    private final PaintInfo charPaintInfo;



    public GameCharacter(){
        //能力值初始化
        level=1;exp=0;
        lvUpExp= GameManager.MANAGER.getLiveManager().calculateLvUpExp(level);
        nation=GameManager.MANAGER.getLiveManager().randomNation();
        name=GameManager.MANAGER.getLiveManager().randomName(nation);
        surName=name;
        //特殊名稱獎勵
        potential_hp=name.equals("鷹村守")?15:GameManager.MANAGER.getRandomInt(0,10);
        potential_mp=name.equals("犬與羅霸特")?15:GameManager.MANAGER.getRandomInt(0,10);
        potential_str=name.equals("厄林 哈蘭德")?15:GameManager.MANAGER.getRandomInt(0,10);
        potential_dex=name.equals("宮城良田")?15:GameManager.MANAGER.getRandomInt(0,10);
        potential_mag=name.equals("星海光來")?15:GameManager.MANAGER.getRandomInt(0,10);
        potential_luc=name.equals("伍佑群")?50:GameManager.MANAGER.getRandomInt(0,10);
        maxHp=5;maxMp=5;str=0;dex=0;mag=0;luc=0;
        money=name.equals("吳玟頤")?500000000:0;
        salary=0;
        levelUp();
        //其他初始化
        historyList=new HistoryList();
        teamType= Constant.TeamType.Neutral;

        //繪製資訊初始化
        double radius=
        charPaintInfo=new PaintInfo()
    }

    /**
     * 等級提升 並依照潛力增加能力值
     */
    public void levelUp(){
        level++;
        exp=0;
        lvUpExp=GameManager.MANAGER.getLiveManager().calculateLvUpExp(level);
        maxHp+=GameManager.MANAGER.getLiveManager().getStatGrow(potential_hp)*2;
        maxMp+=GameManager.MANAGER.getLiveManager().getStatGrow(potential_mp)*2;
        hp=maxHp;mp=maxMp;

        str+=GameManager.MANAGER.getLiveManager().getStatGrow(potential_str);
        dex+=GameManager.MANAGER.getLiveManager().getStatGrow(potential_dex);
        mag+=GameManager.MANAGER.getLiveManager().getStatGrow(potential_mag);
        luc+=GameManager.MANAGER.getLiveManager().getStatGrow(potential_luc);
    }

}
