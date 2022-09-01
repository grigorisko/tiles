import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.io.FileNotFoundException;

public class MouseInput {
    private Tile tile;

    public EventHandler<MouseEvent>getMouseHandler() {
        return event -> {
            tile = (Tile) event.getSource();
            tile.getChildren().remove(tile.getInnerPattern());
            tile.getChildren().remove(tile.getMiddlePattern());
            tile.getChildren().remove(tile.getOuterPattern());
        };
    }
}
