package org.example;

public class Wait {

    public void waitForSeconds(int sec){
        try {
            Thread.sleep(1000 * sec);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
