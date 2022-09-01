package cs351.project1.vasileios.grigorios.kourakos;

import javafx.application.Application;
import javafx.animation.AnimationTimer;
import java.time.Duration;

public class MainLoop {

    public static void main (String [] args ) {
        Application.launch(Display.class, args);


        AnimationTimer a = new AnimationTimer() {
            private long nextTime = 0;

            @Override
            public void handle(long now) {
                if (now > nextTime) {
                    nextTime = now + Duration.ofSeconds(1).toNanos();
                }
            }
        };
        a.start();
    }
}
