package ys.gme.autorpg.character.history;

import java.time.LocalDateTime;

/**
 * 歷史訊息紀錄類
 *
 * @author yoskir
 */
public record History(LocalDateTime time, StringBuilder message,CharacterInfo info) {}

