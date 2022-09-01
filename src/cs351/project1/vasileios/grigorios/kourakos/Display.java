package cs351.project1.vasileios.grigorios.kourakos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
public class Display extends Application{
    private final GridPane gridPane = new GridPane();


    @Override
    public void start(Stage stage) throws FileNotFoundException {
        Board board = new Board();
        initializeScene(board.initializeBoard(), 4, 5);
        MouseInput input = new MouseInput();
        gridPane.getChildren().forEach(tile ->
                tile.setOnMouseClicked(input.getMouseHandler()));
        stage.setTitle("Tiles");
        Scene scene = new Scene(gridPane, 1280, 720);
        stage.setScene(scene);
        stage.show();
    }

    public void initializeScene(Tile[] tiles, int rows, int columns) {
        gridPane.getChildren().clear();
        int i = 0;
        for (int j=0; j< rows;j++) {
            for (int k=0; k < columns; k++) {
                gridPane.add(tiles[i],k,j);
                i++;
            }
        }
    }

}
