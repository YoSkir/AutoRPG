package ys.gme.autorpg.controller;

import javafx.scene.layout.AnchorPane;

/**
 * @author yoskir
 */
public interface Controller {
    void preload();
    AnchorPane getView();
}
