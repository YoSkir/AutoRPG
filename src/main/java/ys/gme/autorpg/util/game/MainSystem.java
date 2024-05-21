package ys.gme.autorpg.util.game;

import ys.gme.autorpg.character.GameCharacter;

import java.util.HashMap;
import java.util.Map;

/**
 * 主要遊戲運行的控制器
 * @author yoskir
 */
public class MainSystem {
    private final Map<String, GameCharacter> playerCharMap=new HashMap<>();
    private final Map<String,GameCharacter> neutralCharMap=new HashMap<>();
}
