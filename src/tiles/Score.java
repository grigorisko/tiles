package tiles;

import javafx.scene.text.Text;

/**
 * Name: Vasileios Grigorios Kourakos
 * The Score class simply updates values of the
 * current and max scores and also updates
 * the text with the new values.
 */
public class Score {
    private int currentScore;
    private int maxScore;

    private Text currentScoreText = new Text(10,50, "Current Score: 0");
    private Text maxScoreText = new Text(10, 50, "Max Score : 0");

    /**
     * Getter for the current score Text object.
     * @return currentScoreText
     */
    public Text getCurrentScoreText() {
        return currentScoreText;
    }

    /**
     * Getter for the max score Text object.
     * @return maxScoreText
     */
    public Text getMaxScoreText() {
        return maxScoreText;
    }

    /**
     * Getter for the current score value
     * @return currentScore
     */
    public int getCurrentScore() {
        return currentScore;
    }

    /**
     * Setter for the current score value. Updates the text
     * with the new score.
     * Also checks if max score should be updated.
     * @param currentScore Value of the current score
     */
    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
        currentScoreText.setText("Current Score : " + this.currentScore);
        if (currentScore>maxScore) {
            setMaxScore(currentScore);
        }

    }

    /**
     * Updates the max score value and updates the text.
     * @param maxScore The max score value.
     */
    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
        maxScoreText.setText("Max Score : " + maxScore);
    }
}
