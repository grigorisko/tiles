package tiles;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Name: Vasileios Grigorios Kourakos
 * The Board class handles the Tile board
 * and contains logic to check and manipulate
 * the board during the game. The number of
 * rows/columns can be change here by changing
 * the variables ROWS and COLUMNS.
 */
public class Board {
    private boolean match = false;
    private final BufferedImage INNER_1 = loadImage("/cross.png");
    private final BufferedImage INNER_2 = loadImage("/x.png");
    private final BufferedImage INNER_3 = loadImage("/rhombus.png");
    private final BufferedImage MIDDLE_1 = loadImage("/circle.png");
    private final BufferedImage MIDDLE_2 = loadImage("/hexagon.png");
    private final BufferedImage MIDDLE_3 = loadImage("/square.png");
    private final BufferedImage OUTER_1 = loadImage("/edges.png");
    private final BufferedImage OUTER_2 = loadImage("/squareedges.png");
    private final BufferedImage OUTER_3 = loadImage("/inverseedges.png");
    private final BufferedImage HIGHLIGHT_IMG_LOC =
                  loadImage("/highlight.png");

    private final Image INNER_IMAGE_1 = SwingFXUtils.toFXImage(INNER_1, null);
    private final Image INNER_IMAGE_2 = SwingFXUtils.toFXImage(INNER_2, null);
    private final Image INNER_IMAGE_3 = SwingFXUtils.toFXImage(INNER_3, null);
    private final Image MIDDLE_IMAGE_1 = SwingFXUtils.toFXImage(MIDDLE_1, null);
    private final Image MIDDLE_IMAGE_2 = SwingFXUtils.toFXImage(MIDDLE_2, null);
    private final Image MIDDLE_IMAGE_3 = SwingFXUtils.toFXImage(MIDDLE_3, null);
    private final Image OUTER_IMAGE_1 = SwingFXUtils.toFXImage(OUTER_1, null);
    private final Image OUTER_IMAGE_2 = SwingFXUtils.toFXImage(OUTER_2, null);
    private final Image OUTER_IMAGE_3 = SwingFXUtils.toFXImage(OUTER_3, null);
    private final Image HIGHLIGHT_IMG=
                  SwingFXUtils.toFXImage(HIGHLIGHT_IMG_LOC, null);

    private final int ROWS = 5;
    private final int COLUMNS = 6;
    private final int NUMBER_OF_PATTERNS = 3;

    private Tile selectedTile;

    private Score score;
    private Display display;

    private Tile[] tiles;

    /**
     * Constructor for Board class
     * @param display The display instance that displays graphics
     * @param score The score instance that handles the score
     *              and text updates
     */
    public Board(Display display, Score score) {
        this.display = display;
        this.score = score;
        selectedTile=null;
    }

    /**
     * This method creates the Tile objects for the game
     * and randomizes what image patterns they each contain.
     * When a pattern is chosen randomly the first time,
     * it is also added to a second random Tile to ensure
     * that the patterns are in pairs and the game can
     * always be completed.
     * @return the Tile array created
     */
    public Tile[] initializeBoard() {
        tiles = new Tile[ROWS * COLUMNS];
        for (int i = 0; i < ROWS * COLUMNS; i++) {
            tiles[i] = new Tile();
        }

        for (int p = 0; p < ROWS * COLUMNS / 2; p++) {
            Random rnTile = new Random();
            int tileRange = ROWS * COLUMNS;
            int randomTileNum = rnTile.nextInt(tileRange);
            while (tiles[randomTileNum].isInnerInitialized()) {
                randomTileNum = rnTile.nextInt(tileRange);
            }
            Random randomPattern = new Random();
            int patternRange = NUMBER_OF_PATTERNS;
            int randomPatternNum = randomPattern.nextInt(patternRange)+1;
            switch (randomPatternNum) {
                case 1 -> {
                    tiles[randomTileNum].setInnerPattern(INNER_IMAGE_1);
                    tiles[randomTileNum].setInnerInitialized(true);
                }
                case 2 -> {
                    tiles[randomTileNum].setInnerPattern(INNER_IMAGE_2);
                    tiles[randomTileNum].setInnerInitialized(true);
                }
                case 3 -> {
                    tiles[randomTileNum].setInnerPattern(INNER_IMAGE_3);
                    tiles[randomTileNum].setInnerInitialized(true);
                }
            }
            randomTileNum = rnTile.nextInt(tileRange);
            while (tiles[randomTileNum].isInnerInitialized()) {
                randomTileNum = rnTile.nextInt(tileRange);
            }
            switch (randomPatternNum) {
                case 1 -> {
                    tiles[randomTileNum].setInnerPattern(INNER_IMAGE_1);
                    tiles[randomTileNum].setInnerInitialized(true);
                }
                case 2 -> {
                    tiles[randomTileNum].setInnerPattern(INNER_IMAGE_2);
                    tiles[randomTileNum].setInnerInitialized(true);
                }
                case 3 -> {
                    tiles[randomTileNum].setInnerPattern(INNER_IMAGE_3);
                    tiles[randomTileNum].setInnerInitialized(true);
                }
            }
        }

            for (int j = 0; j < ROWS * COLUMNS / 2; j++) {
                Random rnTile = new Random();
                int tileRange = ROWS * COLUMNS;
                int randomTileNum = rnTile.nextInt(tileRange);
                while (tiles[randomTileNum].isMiddleInitialized()) {
                    randomTileNum = rnTile.nextInt(tileRange);
                }
                Random randomPattern = new Random();
                int patternRange = NUMBER_OF_PATTERNS;
                int randomPatternNum = randomPattern.nextInt(patternRange)+1;
                switch (randomPatternNum) {
                    case 1 -> {
                        tiles[randomTileNum].setMiddlePattern(MIDDLE_IMAGE_1);
                        tiles[randomTileNum].setMiddleInitialized(true);
                    }
                    case 2 -> {
                        tiles[randomTileNum].setMiddlePattern(MIDDLE_IMAGE_2);
                        tiles[randomTileNum].setMiddleInitialized(true);
                    }
                    case 3 -> {
                        tiles[randomTileNum].setMiddlePattern(MIDDLE_IMAGE_3);
                        tiles[randomTileNum].setMiddleInitialized(true);
                    }
                }
                randomTileNum = rnTile.nextInt(tileRange);
                while (tiles[randomTileNum].isMiddleInitialized()) {
                    randomTileNum = rnTile.nextInt(tileRange);
                }
                switch (randomPatternNum) {
                    case 1 -> {
                        tiles[randomTileNum].setMiddlePattern(MIDDLE_IMAGE_1);
                        tiles[randomTileNum].setMiddleInitialized(true);
                    }
                    case 2 -> {
                        tiles[randomTileNum].setMiddlePattern(MIDDLE_IMAGE_2);
                        tiles[randomTileNum].setMiddleInitialized(true);
                    }
                    case 3 -> {
                        tiles[randomTileNum].setMiddlePattern(MIDDLE_IMAGE_3);
                        tiles[randomTileNum].setMiddleInitialized(true);
                    }
                }
            }
            for (int q = 0; q < ROWS * COLUMNS / 2; q++) {
                Random rnTile = new Random();
                int tileRange = ROWS * COLUMNS;
                int randomTileNum = rnTile.nextInt(tileRange);
                while (tiles[randomTileNum].isOuterInitialized()) {
                    randomTileNum = rnTile.nextInt(tileRange);
                }
                Random randomPattern = new Random();
                int patternRange = NUMBER_OF_PATTERNS;
                int randomPatternNum = randomPattern.nextInt(patternRange)+1;
                switch (randomPatternNum) {
                    case 1 -> {
                        tiles[randomTileNum].setOuterPattern(OUTER_IMAGE_1);
                        tiles[randomTileNum].setOuterInitialized(true);
                    }
                    case 2 -> {
                        tiles[randomTileNum].setOuterPattern(OUTER_IMAGE_2);
                        tiles[randomTileNum].setOuterInitialized(true);
                    }
                    case 3 -> {
                        tiles[randomTileNum].setOuterPattern(OUTER_IMAGE_3);
                        tiles[randomTileNum].setOuterInitialized(true);
                    }
                }
                randomTileNum = rnTile.nextInt(tileRange);

                while (tiles[randomTileNum].isOuterInitialized()) {
                    randomTileNum = rnTile.nextInt(tileRange);
                }
                switch (randomPatternNum) {
                    case 1 -> {
                        tiles[randomTileNum].setOuterPattern(OUTER_IMAGE_1);
                        tiles[randomTileNum].setOuterInitialized(true);
                    }
                    case 2 -> {
                        tiles[randomTileNum].setOuterPattern(OUTER_IMAGE_2);
                        tiles[randomTileNum].setOuterInitialized(true);
                    }
                    case 3 -> {
                        tiles[randomTileNum].setOuterPattern(OUTER_IMAGE_3);
                        tiles[randomTileNum].setOuterInitialized(true);
                    }
                }
            }
        return tiles;
    }

    private BufferedImage loadImage(String filepath) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getResourceAsStream(filepath));
        } catch (IOException e) {
            return null;
        }
        return image;
    }

    /**
     * Getter for ROWS
     * @return ROWS
     */
    public int getROWS() {
        return ROWS;
    }

    /**
     * Getter for COLUMNS
     * @return COLUMNS
     */
    public int getCOLUMNS() {
        return COLUMNS;
    }

    /**
     * This method handles the Tile selection with information from
     * MouseInput. It also controls the state of the Tiles/Board
     * and handles all the logic of matching patterns.
     * @param selectedTile The Tile object clicked by the player.
     */
    public void setSelectedTile(Tile selectedTile) {

        if(this.selectedTile==null) {
            this.selectedTile = selectedTile;
            selectedTile.setHighlighted(HIGHLIGHT_IMG, true);
        }
        else {
            if (selectedTile.getInnerPattern().getImage().equals(
                    this.selectedTile.getInnerPattern().getImage())
                    && !selectedTile.equals(this.selectedTile)) {
                if (selectedTile.isInnerActive() &&
                        this.selectedTile.isInnerActive()) {
                    this.selectedTile.setInnerActive(false);
                    selectedTile.setInnerActive(false);
                    this.selectedTile.setHighlighted(HIGHLIGHT_IMG, false);
                    match = true;
                }
            }
            if (selectedTile.getMiddlePattern().getImage().equals(
                    this.selectedTile.getMiddlePattern().getImage())
                    && !selectedTile.equals(this.selectedTile)) {
                if (selectedTile.isMiddleActive() &&
                        this.selectedTile.isMiddleActive()) {
                    this.selectedTile.setMiddleActive(false);
                    selectedTile.setMiddleActive(false);
                    this.selectedTile.setHighlighted(HIGHLIGHT_IMG, false);
                    match = true;
                }
            }
            if (selectedTile.getOuterPattern().getImage().equals(
                    this.selectedTile.getOuterPattern().getImage())
                    && !selectedTile.equals(this.selectedTile)) {
                if (selectedTile.isOuterActive() &&
                        this.selectedTile.isOuterActive()) {
                    this.selectedTile.setOuterActive(false);
                    selectedTile.setOuterActive(false);
                    this.selectedTile.setHighlighted(HIGHLIGHT_IMG, false);
                    match = true;
                }
            }
            if (match) {
                score.setCurrentScore(score.getCurrentScore() + 1);
                if(!this.selectedTile.isInnerActive() &&
                        !this.selectedTile.isMiddleActive() &&
                            !this.selectedTile.isOuterActive()) {
                    display.getGridPane().getChildren().remove
                                           (this.selectedTile);
                }
                if(!selectedTile.isInnerActive() &&
                        !selectedTile.isMiddleActive() &&
                            !selectedTile.isOuterActive()) {
                    display.getGridPane().getChildren().remove(selectedTile);
                    this.selectedTile = null;
                    checkIfDone();
                }
                else {
                    this.selectedTile = selectedTile;
                    selectedTile.setHighlighted(HIGHLIGHT_IMG, true);
                }
                match = false;
            } else {
                score.setCurrentScore(0);
                this.selectedTile.setHighlighted(HIGHLIGHT_IMG, false);
                this.selectedTile = null;
            }
        }
    }

    private void checkIfDone() {
        boolean gameIsDone = true;
        for (int i=0; i<tiles.length; i++) {
            if(tiles[i].isInnerActive() ||
                    tiles[i].isMiddleActive() ||
                        tiles[i].isOuterActive()) {
                gameIsDone = false;
                break;
            }
        }
        if(gameIsDone){
            display.endGame();
        }
    }
}
