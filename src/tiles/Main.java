package tiles;

import javafx.application.Application;

/**
 * Name: Vasileios Grigorios Kourakos
 * Main class of the project.
 * Simply launches the JavaFX application
 * that is contained in the Display class.
 * I did not find a need for an Animation Timer
 * here as all the graphics get automatically
 * updated by JavaFX when there is a change.
 */
public class Main {

    public static void main (String [] args ) {
        Application.launch(Display.class, args);

    }
}
