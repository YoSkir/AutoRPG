package ys.gme.autorpg.character.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;

/**
 * 存放不同程度歷史訊息的類
 * @author yoskir
 */
@Data
@ToString(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HistoryList {
    @JsonProperty(value = "totalHistory")//一般歷史(只存特定筆數)
    List<History> totalHistory=new LinkedList<>();
    @JsonProperty(value = "importantHistory")//重要
    List<History> importantHistory=new LinkedList<>();
    @JsonProperty(value = "superHistory")//超級
    List<History> superHistory=new LinkedList<>();
    @JsonProperty(value = "epicHistory")//史詩
    List<History> epicHistory=new LinkedList<>();
}
/**
 ** 一般
 * 移動、攻擊、受傷、死亡、休息、娛樂、購買日常品、撿取、掉落、裝備強化(3星內)、接受一般任務、完成一般任務
 ** 重要
 * 能力值加3、升級、打贏Boss、打到寶物、薪水提升、薪水下降、購買高級品、裝備強化(4~6星)、發生衝突、國家以下賽事成績、更換隊伍、退出隊伍
 * 等級達10的倍數
 ** 超級
 * 能力值加4、裝備強化(7~11星)、洲際賽成績、等級達20的倍數
 ** 史詩
 * 能力值加5以上、特殊名稱(12~15星)、世界賽成績、等級達40的倍數
 */
