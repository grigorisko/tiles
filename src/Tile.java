import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;


public class Tile extends StackPane {
    private ImageView innerPattern;
    private ImageView middlePattern;
    private ImageView outerPattern;
    private boolean innerActive;
    private boolean middleActive;
    private boolean outerActive;

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

    public void setInnerActive(boolean innerActive) {
        if (!innerActive) {
            this.getChildren().remove(this.innerPattern);
        }
    }

    public void setMiddleActive(boolean middleActive) {
        if (!innerActive) {
            this.getChildren().remove(this.middlePattern);
        }
    }

    public void setOuterActive(boolean outerActive) {
        if (!innerActive) {
            this.getChildren().remove(this.outerPattern);
        }
    }

}
