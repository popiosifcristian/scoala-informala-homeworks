package com.homework.main;
/**This is the FestivalStatisticsThread class that have
 * the goal to implement our festival statistics
 * This class extends Thread and it will be a daemon thread
 *
 * Created by Joseph Thursday, 23.02.2017 at 16:37.
 * @author Pop Iosif Cristian
 * @version 1.0
 */
public class FestivalStatisticsThread extends Thread {

    private FestivalGate gate = new FestivalGate();

    public FestivalStatisticsThread(FestivalGate festivalGate) {
        this.gate = festivalGate;
        setDaemon(true);
    }


    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
                //if the que is not empty, it will print the statistics
                if (!gate.getQueue().isEmpty())
                gate.getInfo();
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
        }
    }
}
