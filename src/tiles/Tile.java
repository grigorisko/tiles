package tiles;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;


public class Tile extends StackPane {
    private ImageView innerPattern;
    private ImageView middlePattern;
    private ImageView outerPattern;
    private ImageView highlightImg;
    private boolean innerInitialized = false;
    private boolean middleInitialized = false;
    private boolean outerInitialized = false;
    private boolean innerActive = true;
    private boolean middleActive = true;
    private boolean outerActive = true;
    private boolean highlighted;

    public void setInnerPattern(Image innerPattern) {
        this.innerPattern = new ImageView(innerPattern);
        this.getChildren().add(this.innerPattern);
    }

    public void setMiddlePattern(Image middlePattern) {
        this.middlePattern = new ImageView(middlePattern);
        this.getChildren().add(this.middlePattern);
    }

    public void setOuterPattern(Image outerPattern) {
        this.outerPattern = new ImageView(outerPattern);
        this.getChildren().add(this.outerPattern);
    }

    public Tile() {

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

    public boolean isInnerInitialized() {
        return innerInitialized;
    }

    public void setInnerInitialized(boolean innerInitialized) {
        this.innerInitialized = innerInitialized;
    }

    public boolean isMiddleInitialized() {
        return middleInitialized;
    }

    public void setMiddleInitialized(boolean middleInitialized) {
        this.middleInitialized = middleInitialized;
    }

    public boolean isOuterInitialized() {
        return outerInitialized;
    }

    public void setOuterInitialized(boolean outerInitialized) {
        this.outerInitialized = outerInitialized;
    }
}
