package ys.gme.autorpg.character.history;

import ys.gme.autorpg.character.Team;
import ys.gme.autorpg.scene.Map;

/**
 * 用於記錄歷史記錄當下角色狀態的類
 * @author yoskir
 */
public record CharacterInfo(
        String name,
        int level,
        int exp,
        int money,
        int salary,
        int str,
        int dex,
        int mag,
        int luc,
        Map map,
        Team team
)
{ }
