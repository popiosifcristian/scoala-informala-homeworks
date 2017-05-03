package com.homework.main;

/**This is the Festival class where we will have the main
 * where we will create a gate a festival attendee thread and a festival statistics thread
 *
 * Created by Joseph Thursday, 23.02.2017 at 22:57.
 * @author Pop Iosif Cristian
 * @version 1.0
 */
public class Festival {

    public static void main(String[] args) throws InterruptedException {
        FestivalGate fg = new FestivalGate();
        FestivalAttendeeThread fat = new FestivalAttendeeThread(fg);
        FestivalStatisticsThread fst = new FestivalStatisticsThread(fg);
        fst.start();
        fat.start();

  /*//if you want to get the latest attendees who enter in the festival after the latest statistics
    //just uncomment this. I commented this because the requirements of the statistics thread
    //were to display the statistics every 5 seconds
         fat.join();
         fg.getInfo();
  */


    }
}
