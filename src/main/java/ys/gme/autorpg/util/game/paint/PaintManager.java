package ys.gme.autorpg.util.game.paint;

import javafx.scene.layout.Pane;
import lombok.Getter;
import lombok.Setter;
import ys.gme.autorpg.character.GameCharacter;

/**
 * 遊戲畫面繪製類
 * @author yoskir
 */
public class PaintManager {
    @Setter@Getter
    private Pane gameDisplayArea;

    public void addPaintedObject(GameCharacter charToPaint){

    }

    /**
     * 在畫面上繪製角色
     * @param charToPaint 要繪製的角色
     */
    public void paintChar(GameCharacter charToPaint){

    }
}
