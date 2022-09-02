package tiles;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Board {
    private boolean match = false;
    private BufferedImage inner1 = loadImage("/cross.png");
    private BufferedImage inner2 = loadImage("/x.png");
    private BufferedImage inner3 = loadImage("/rhombus.png");
    private BufferedImage middle1 = loadImage("/circle.png");
    private BufferedImage middle2 = loadImage("/hexagon.png");
    private BufferedImage middle3 = loadImage("/square.png");
    private BufferedImage outer1 = loadImage("/edges.png");
    private BufferedImage outer2 = loadImage("/squareedges.png");
    private BufferedImage outer3 = loadImage("/inverseedges.png");
    private BufferedImage highlightImgLoc = loadImage("/highlight.png");

    private final Image innerImage1 = SwingFXUtils.toFXImage(inner1, null);
    private final Image innerImage2 = SwingFXUtils.toFXImage(inner2, null);
    private final Image innerImage3 = SwingFXUtils.toFXImage(inner3, null);
    private final Image middleImage1 = SwingFXUtils.toFXImage(middle1, null);
    private final Image middleImage2 = SwingFXUtils.toFXImage(middle2, null);
    private final Image middleImage3 = SwingFXUtils.toFXImage(middle3, null);
    private final Image outerImage1 = SwingFXUtils.toFXImage(outer1, null);
    private final Image outerImage2 = SwingFXUtils.toFXImage(outer2, null);
    private final Image outerImage3 = SwingFXUtils.toFXImage(outer3, null);
    private final Image highlightImg = SwingFXUtils.toFXImage(highlightImgLoc, null);

    private final int ROWS = 5;
    private final int COLUMNS = 6;
    private final int NUMBER_OF_PATTERNS = 3;

    private Tile selectedTile;

    private Score score;
    private Display display;

    private Tile[] tiles;

    public Board(Display display, Score score) {
        this.display = display;
        this.score = score;
        selectedTile=null;
    }

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
            int randomPatternNum = randomPattern.nextInt(patternRange) + 1;
            switch (randomPatternNum) {
                case 1 -> {
                    tiles[randomTileNum].setInnerPattern(innerImage1);
                    tiles[randomTileNum].setInnerInitialized(true);
                }
                case 2 -> {
                    tiles[randomTileNum].setInnerPattern(innerImage2);
                    tiles[randomTileNum].setInnerInitialized(true);
                }
                case 3 -> {
                    tiles[randomTileNum].setInnerPattern(innerImage3);
                    tiles[randomTileNum].setInnerInitialized(true);
                }
            }
            randomTileNum = rnTile.nextInt(tileRange);
            while (tiles[randomTileNum].isInnerInitialized()) {
                randomTileNum = rnTile.nextInt(tileRange);
            }
            switch (randomPatternNum) {
                case 1 -> {
                    tiles[randomTileNum].setInnerPattern(innerImage1);
                    tiles[randomTileNum].setInnerInitialized(true);
                }
                case 2 -> {
                    tiles[randomTileNum].setInnerPattern(innerImage2);
                    tiles[randomTileNum].setInnerInitialized(true);
                }
                case 3 -> {
                    tiles[randomTileNum].setInnerPattern(innerImage3);
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
                int randomPatternNum = randomPattern.nextInt(patternRange) + 1;
                switch (randomPatternNum) {
                    case 1 -> {
                        tiles[randomTileNum].setMiddlePattern(middleImage1);
                        tiles[randomTileNum].setMiddleInitialized(true);
                    }
                    case 2 -> {
                        tiles[randomTileNum].setMiddlePattern(middleImage2);
                        tiles[randomTileNum].setMiddleInitialized(true);
                    }
                    case 3 -> {
                        tiles[randomTileNum].setMiddlePattern(middleImage3);
                        tiles[randomTileNum].setMiddleInitialized(true);
                    }
                }
                randomTileNum = rnTile.nextInt(tileRange);
                while (tiles[randomTileNum].isMiddleInitialized()) {
                    randomTileNum = rnTile.nextInt(tileRange);
                }
                switch (randomPatternNum) {
                    case 1 -> {
                        tiles[randomTileNum].setMiddlePattern(middleImage1);
                        tiles[randomTileNum].setMiddleInitialized(true);
                    }
                    case 2 -> {
                        tiles[randomTileNum].setMiddlePattern(middleImage2);
                        tiles[randomTileNum].setMiddleInitialized(true);
                    }
                    case 3 -> {
                        tiles[randomTileNum].setMiddlePattern(middleImage3);
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
                int randomPatternNum = randomPattern.nextInt(patternRange) + 1;
                switch (randomPatternNum) {
                    case 1 -> {
                        tiles[randomTileNum].setOuterPattern(outerImage1);
                        tiles[randomTileNum].setOuterInitialized(true);
                    }
                    case 2 -> {
                        tiles[randomTileNum].setOuterPattern(outerImage2);
                        tiles[randomTileNum].setOuterInitialized(true);
                    }
                    case 3 -> {
                        tiles[randomTileNum].setOuterPattern(outerImage3);
                        tiles[randomTileNum].setOuterInitialized(true);
                    }
                }
                randomTileNum = rnTile.nextInt(tileRange);

                while (tiles[randomTileNum].isOuterInitialized()) {
                    randomTileNum = rnTile.nextInt(tileRange);
                }
                switch (randomPatternNum) {
                    case 1 -> {
                        tiles[randomTileNum].setOuterPattern(outerImage1);
                        tiles[randomTileNum].setOuterInitialized(true);
                    }
                    case 2 -> {
                        tiles[randomTileNum].setOuterPattern(outerImage2);
                        tiles[randomTileNum].setOuterInitialized(true);
                    }
                    case 3 -> {
                        tiles[randomTileNum].setOuterPattern(outerImage3);
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

    public int getROWS() {
        return ROWS;
    }

    public int getCOLUMNS() {
        return COLUMNS;
    }

    public void setSelectedTile(Tile selectedTile) {

        if(this.selectedTile==null) {
            this.selectedTile = selectedTile;
            selectedTile.setHighlighted(highlightImg, true);
        }
        else {
            if (selectedTile.getInnerPattern().getImage().equals(
                    this.selectedTile.getInnerPattern().getImage())
                    && !selectedTile.equals(this.selectedTile)) {
                if (selectedTile.isInnerActive() && this.selectedTile.isInnerActive()) {
                    this.selectedTile.setInnerActive(false);
                    selectedTile.setInnerActive(false);
                    this.selectedTile.setHighlighted(highlightImg, false);
                    match = true;
                }
            }
            if (selectedTile.getMiddlePattern().getImage().equals(
                    this.selectedTile.getMiddlePattern().getImage())
                    && !selectedTile.equals(this.selectedTile)) {
                if (selectedTile.isMiddleActive() && this.selectedTile.isMiddleActive()) {
                    this.selectedTile.setMiddleActive(false);
                    selectedTile.setMiddleActive(false);
                    this.selectedTile.setHighlighted(highlightImg, false);
                    match = true;
                }
            }
            if (selectedTile.getOuterPattern().getImage().equals(
                    this.selectedTile.getOuterPattern().getImage())
                    && !selectedTile.equals(this.selectedTile)) {
                if (selectedTile.isOuterActive() && this.selectedTile.isOuterActive()) {
                    this.selectedTile.setOuterActive(false);
                    selectedTile.setOuterActive(false);
                    this.selectedTile.setHighlighted(highlightImg, false);
                    match = true;
                }
            }
            if (match) {
                score.setCurrentScore(score.getCurrentScore() + 1);
                if(!this.selectedTile.isInnerActive() && !this.selectedTile.isMiddleActive()
                        && !this.selectedTile.isOuterActive()) {
                    display.getGridPane().getChildren().remove(this.selectedTile);
                }
                if(!selectedTile.isInnerActive() && !selectedTile.isMiddleActive()
                        && !selectedTile.isOuterActive()) {
                    display.getGridPane().getChildren().remove(selectedTile);
                    this.selectedTile = null;
                    checkIfDone();
                }
                else {
                    this.selectedTile = selectedTile;
                    selectedTile.setHighlighted(highlightImg, true);
                }
                match = false;
            } else {
                score.setCurrentScore(0);
                this.selectedTile.setHighlighted(highlightImg, false);
                this.selectedTile = null;
            }
        }
    }

    private void checkIfDone() {
        boolean gameIsDone = true;
        for (int i=0; i<tiles.length; i++) {
            if(tiles[i].isInnerActive() || tiles[i].isMiddleActive() || tiles[i].isOuterActive()) {
                gameIsDone = false;
                break;
            }
        }
        if(gameIsDone){
            display.endGame();
        }
    }
}
