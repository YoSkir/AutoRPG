module ys.gme.autorpg {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires static lombok;
    requires com.fasterxml.jackson.databind;

    opens ys.gme.autorpg to javafx.fxml;
    exports ys.gme.autorpg;
    exports ys.gme.autorpg.controller;
    opens ys.gme.autorpg.controller to javafx.fxml;
    exports ys.gme.autorpg.character;
    opens ys.gme.autorpg.character to javafx.fxml;
    exports ys.gme.autorpg.util;
    opens ys.gme.autorpg.util to javafx.fxml;
    exports ys.gme.autorpg.component;
    opens ys.gme.autorpg.component to javafx.fxml;
    exports ys.gme.autorpg.component.name to com.fasterxml.jackson.databind;
    exports ys.gme.autorpg.character.history;
    opens ys.gme.autorpg.character.history to javafx.fxml;
}