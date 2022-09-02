package tiles;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MouseInput {
    private Tile tile;
    private Board board;

    public MouseInput(Board board) {
        this.board = board;
    }

    public EventHandler<MouseEvent>getMouseHandler() {
        return event -> {
            tile = (Tile) event.getSource();
            board.setSelectedTile(tile);
        };
    }
}
