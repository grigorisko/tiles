package tiles;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.io.FileNotFoundException;

public class MouseInput {
    private Tile tile;
    private Board board = new Board();

    public MouseInput() throws FileNotFoundException {
    }

    public EventHandler<MouseEvent>getMouseHandler() {
        return event -> {
            tile = (Tile) event.getSource();
            board.setSelectedTile(tile);
            //tile.getChildren().remove(tile.getInnerPattern());
            //tile.getChildren().remove(tile.getMiddlePattern());
            //tile.getChildren().remove(tile.getOuterPattern());
        };
    }
}
