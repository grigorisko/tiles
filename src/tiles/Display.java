package tiles;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Name: Vasileios Grigorios Kourakos
 * This Display class extends JavaFX Application and is the
 * GUI class of my project. It creates, displays and manipulates
 * the GUI for the game.
 */
public class Display extends Application{
    private final GridPane gridPane = new GridPane();


    /**
     * The launch method for the application. Creates all the GUI
     * elements and displays them.
     * I also add the Mouse Event Handlers to the tiles here.
     * @param stage the primary stage for this application, onto which
     * the application scene can be set.
     * Applications may create other stages, if needed, but they will not be
     * primary stages.
     */
    @Override
    public void start(Stage stage) {
        Score score = new Score();
        Board board = new Board(this, score);
        score.getCurrentScoreText().setFont(new Font(20));
        score.getMaxScoreText().setFont(new Font(20));
        int rows = board.getROWS();
        int columns = board.getCOLUMNS();
        for (int i = 0; i < board.getCOLUMNS(); i++) {
            ColumnConstraints column = new ColumnConstraints(100);
            gridPane.getColumnConstraints().add(column);
        }
        for (int i = 0; i < board.getROWS(); i++) {
            RowConstraints row = new RowConstraints(100);
            gridPane.getRowConstraints().add(row);
        }
        initializeScene(board.initializeBoard(), rows, columns);
        MouseInput input = new MouseInput(board);
        gridPane.getChildren().forEach(tile ->
                tile.setOnMouseClicked(input.getMouseHandler()));
        stage.setTitle("Tiles");
        gridPane.add(score.getCurrentScoreText(),board.getCOLUMNS()+1 ,0,1,1);
        gridPane.add(score.getMaxScoreText(), board.getCOLUMNS()+1,1,1,1);
        Scene scene = new Scene(gridPane, 1280, 720);
        stage.setScene(scene);
        stage.show();
    }


    private void initializeScene(Tile[] tiles, int rows, int columns) {
        gridPane.getChildren().clear();
        int i = 0;
        for (int j=0; j< rows;j++) {
            for (int k=0; k < columns; k++) {
                gridPane.add(tiles[i],k,j);
                i++;
            }
        }
    }

    /**
     * Getter for the GridPane of the scene
     * @return gridPane
     */
    public GridPane getGridPane() {
        return gridPane;
    }

    /**
     * This method is called when the Board logic
     * finds that the game has ended. Simply adds a text
     * that notifies the player that the game is over.
     */
    public void endGame() {
        String overString = "Congratulations! You matched all the tiles.";
        Text gameOver = new Text(10,50, overString);
        gameOver.setFont(new Font(25));
        gridPane.add(gameOver,0,3,1,1);
    }
}
