package tiles;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Name: Vasileios Grigorios Kourakos
 * The MouseInput class contains the EventHandler
 * for the mouse clicks on tiles.
 */
public class MouseInput {
    private Tile tile;
    private Board board;

    /**
     * Constructor for the class
     * @param board The Board of the application
     */
    public MouseInput(Board board) {
        this.board = board;
    }

    /**
     * The Event Handler for mouse clicks.
     * Gets the Tile object that was clicked
     * and passes it to the Board so that it can
     * be checked for matching/highlighting.
     * @return event
     */
    public EventHandler<MouseEvent>getMouseHandler() {
        return event -> {
            tile = (Tile) event.getSource();
            board.setSelectedTile(tile);
        };
    }
}
