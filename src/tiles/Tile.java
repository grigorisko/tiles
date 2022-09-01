package tiles;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;


public class Tile extends StackPane {
    private ImageView innerPattern;
    private ImageView middlePattern;
    private ImageView outerPattern;
    private ImageView highlightImg;
    private boolean innerActive = true;
    private boolean middleActive = true;
    private boolean outerActive = true;
    private boolean highlighted;

    public void setInnerPattern(ImageView innerPattern) {
        this.innerPattern = innerPattern;
    }

    public void setMiddlePattern(ImageView middlePattern) {
        this.middlePattern = middlePattern;
    }

    public void setOuterPattern(ImageView outerPattern) {
        this.outerPattern = outerPattern;
    }

    public Tile(Image innerPattern, Image middlePattern, Image outerPattern) {
        this.innerPattern = new ImageView(innerPattern);
        this.middlePattern = new ImageView(middlePattern);
        this.outerPattern = new ImageView(outerPattern);
        this.getChildren().add(this.innerPattern);
        this.getChildren().add(this.middlePattern);
        this.getChildren().add(this.outerPattern);

    }

    public ImageView getInnerPattern() {
        return this.innerPattern;
    }

    public ImageView getMiddlePattern() {
        return this.middlePattern;
    }

    public ImageView getOuterPattern() {
        return this.outerPattern;
    }

    public boolean isInnerActive() {
        return innerActive;
    }

    public boolean isMiddleActive() {
        return middleActive;
    }

    public boolean isOuterActive() {
        return outerActive;
    }

    public void setInnerActive(boolean innerActive) {
        if (!innerActive) {
            this.getChildren().remove(this.innerPattern);
            this.innerActive = false;
        }
    }

    public void setMiddleActive(boolean middleActive) {
        if (!middleActive) {
            this.getChildren().remove(this.middlePattern);
            this.middleActive = false;
        }
    }

    public void setOuterActive(boolean outerActive) {
        if (!outerActive) {
            this.getChildren().remove(this.outerPattern);
            this.outerActive = false;
        }
    }

    public void setHighlighted(Image highlightImg,boolean highlight){
        if (!highlighted && highlight) {
            this.highlightImg = new ImageView((highlightImg));
            this.getChildren().add(this.highlightImg);
            highlighted = true;
        }
        else if (highlighted && !highlight) {
            this.getChildren().remove(this.highlightImg);
            highlighted = false;
        }
    }

}
