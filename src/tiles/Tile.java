package tiles;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 * Name: Vasileios Grigorios Kourakos
 * The Tile class handles the logic and graphics
 * for the individual Tile objects.
 * It expands StackPane as that is a way to
 * layer images on top of each other in JavaFX.
 * That way we can have different patterns chosen
 * randomly in each Tile.
 */
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

    /**
     * Sets the inner pattern of the Tile
     * @param innerPattern The Image to set the pattern to.
     */
    public void setInnerPattern(Image innerPattern) {
        this.innerPattern = new ImageView(innerPattern);
        this.getChildren().add(this.innerPattern);
    }

    /**
     * Sets the middle pattern of the Tile
     * @param middlePattern The Image to set the pattern to.
     */
    public void setMiddlePattern(Image middlePattern) {
        this.middlePattern = new ImageView(middlePattern);
        this.getChildren().add(this.middlePattern);
    }

    /**
     * Sets the outer pattern of the Tile
     * @param outerPattern The Image to set the pattern to.
     */
    public void setOuterPattern(Image outerPattern) {
        this.outerPattern = new ImageView(outerPattern);
        this.getChildren().add(this.outerPattern);
    }

    /**
     * Constructor of Tile
     */
    public Tile() {

    }

    /**
     * Getter for the Tile's inner pattern
     * @return innerPattern
     */
    public ImageView getInnerPattern() {
        return this.innerPattern;
    }

    /**
     * Getter for the Tile's middle pattern
     * @return middlePattern
     */
    public ImageView getMiddlePattern() {
        return this.middlePattern;
    }

    /**
     * Getter for the Tile's outer pattern
     * @return outerPattern
     */
    public ImageView getOuterPattern() {
        return this.outerPattern;
    }

    /**
     * Getter for variable innerActive
     * @return innerActive
     */
    public boolean isInnerActive() {
        return innerActive;
    }

    /**
     * Getter for variable middleActive
     * @return middleActive
     */
    public boolean isMiddleActive() {
        return middleActive;
    }

    /**
     * Getter for variable outerActive
     * @return outerActive
     */
    public boolean isOuterActive() {
        return outerActive;
    }

    /**
     * This method sets the inner pattern of
     * the Tile as active or not and removes the
     * image if necessary.
     * After getting matched it is set as inactive.
     * @param innerActive Whether the pattern should be active or not.
     */
    public void setInnerActive(boolean innerActive) {
        if (!innerActive) {
            this.getChildren().remove(this.innerPattern);
            this.innerActive = false;
        }
    }

    /**
     * This method sets the middle pattern of
     * the Tile as active or not and removes the
     * image if necessary.
     * After getting matched it is set as inactive.
     * @param middleActive Whether the pattern should be active or not.
     */
    public void setMiddleActive(boolean middleActive) {
        if (!middleActive) {
            this.getChildren().remove(this.middlePattern);
            this.middleActive = false;
        }
    }

    /**
     * This method sets the outer pattern of
     * the Tile as active or not and removes the
     * image if necessary.
     * After getting matched it is set as inactive.
     * @param outerActive Whether the pattern should be active or not.
     */
    public void setOuterActive(boolean outerActive) {
        if (!outerActive) {
            this.getChildren().remove(this.outerPattern);
            this.outerActive = false;
        }
    }

    /**
     * This method sets a Tile as highlighted or not
     * @param highlightImg The Image that shows the Tile is highlighted
     * @param highlight Boolean that decides whether this Tile should
     *                  be highlighted or not
     */
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

    /**
     * Getter for innerInitialized
     * @return innerInitialized
     */
    public boolean isInnerInitialized() {
        return innerInitialized;
    }

    /**
     * Setter for innerInitialized
     * @param innerInitialized Boolean that decides if inner is
     *                         initialized or not
     */
    public void setInnerInitialized(boolean innerInitialized) {
        this.innerInitialized = innerInitialized;
    }

    /**
     * Getter for middleInitialized
     * @return middleInitialized
     */
    public boolean isMiddleInitialized() {
        return middleInitialized;
    }

    /**
     * Setter for middleInitialized
     * @param middleInitialized Boolean that decides if inner is
     *                         initialized or not
     */
    public void setMiddleInitialized(boolean middleInitialized) {
        this.middleInitialized = middleInitialized;
    }

    /**
     * Getter for outerInitialized
     * @return outerInitialized
     */
    public boolean isOuterInitialized() {
        return outerInitialized;
    }

    /**
     * Setter for outerInitialized
     * @param outerInitialized Boolean that decides if inner is
     *                         initialized or not
     */
    public void setOuterInitialized(boolean outerInitialized) {
        this.outerInitialized = outerInitialized;
    }
}
