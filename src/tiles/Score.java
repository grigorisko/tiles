package tiles;

import javafx.scene.text.Text;

public class Score {
    private int currentScore;
    private int maxScore;

    private Text currentScoreText = new Text(10,50, "Current Score: 0");
    private Text maxScoreText = new Text(10, 50, "Max Score : 0");


    public Text getCurrentScoreText() {
        return currentScoreText;
    }

    public Text getMaxScoreText() {
        return maxScoreText;
    }


    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
        currentScoreText.setText("Current Score : " + this.currentScore);
        if (currentScore>maxScore) {
            setMaxScore(currentScore);
        }

    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
        maxScoreText.setText("Max Score : " + maxScore);
    }
}
