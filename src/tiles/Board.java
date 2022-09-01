package tiles;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Board {
    private final FileInputStream innerImageLoc1 = new FileInputStream("resources/cross.png");
    private final FileInputStream innerImageLoc2 = new FileInputStream("resources/circle.png");
    private final FileInputStream innerImageLoc3 = new FileInputStream("resources/triangle.png");
    private final FileInputStream middleImageLoc1 = new FileInputStream("resources/triangle.png");
    private final FileInputStream middleImageLoc2 = new FileInputStream("resources/triangle.png");
    private final FileInputStream middleImageLoc3 = new FileInputStream("resources/triangle.png");
    private final FileInputStream outerImageLoc1 = new FileInputStream("resources/triangle.png");
    private final FileInputStream outerImageLoc2 = new FileInputStream("resources/triangle.png");
    private final FileInputStream outerImageLoc3 = new FileInputStream("resources/triangle.png");
    private final FileInputStream highlightImgLoc = new FileInputStream("resources/highlight.png");
    private final Image innerImage1 = new Image(innerImageLoc1);
    private final Image innerImage2 = new Image(innerImageLoc2);
    private final Image innerImage3 = new Image(innerImageLoc3);
    private final Image middleImage1 = new Image(middleImageLoc1);
    private final Image middleImage2 = new Image(middleImageLoc2);
    private final Image middleImage3 = new Image(middleImageLoc3);
    private final Image outerImage1 = new Image(outerImageLoc1);
    private final Image outerImage2 = new Image(outerImageLoc2);
    private final Image outerImage3 = new Image(outerImageLoc3);
    private final Image highlightImg = new Image(highlightImgLoc);

    private final int rows = 4;
    private final int columns = 5;

    private Tile selectedTile;

    public Board() throws FileNotFoundException {
        selectedTile=null;
    }

    public Tile[] initializeBoard(){
        Tile[] tiles = new Tile[20];
        for(int i=0; i<20;i++) {
            tiles[i] = new Tile(innerImage1,innerImage2,innerImage3);
        }
        return tiles;



        /*for(int i=0; i<rows*columns;i++) {
            Random rn = new Random();
            int range = rows * columns + 1;
            int randomNum = rn.nextInt(range);
        }*/

    }

    public void setSelectedTile(Tile selectedTile) {

        if(this.selectedTile==null) {
            this.selectedTile = selectedTile;
            selectedTile.setHighlighted(highlightImg, true);
            System.out.println((this.selectedTile.getInnerPattern().getImage()));
            System.out.println((selectedTile.getInnerPattern().getImage()));
        }
        else if(selectedTile.getInnerPattern().getImage().equals(
                this.selectedTile.getInnerPattern().getImage())
                && !selectedTile.equals(this.selectedTile)) {
            if (selectedTile.isInnerActive() && this.selectedTile.isInnerActive()) {
                this.selectedTile.setInnerActive(false);
                selectedTile.setInnerActive(false);
                this.selectedTile.setHighlighted(highlightImg, false);
                selectedTile.setHighlighted(highlightImg, true);
                this.selectedTile = selectedTile;
                System.out.println("test");
            }
        }
    }
}
