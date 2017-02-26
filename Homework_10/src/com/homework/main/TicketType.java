package com.homework.main;
import java.util.Random;
/**This is the TicketType class
 * and have the goal to define ticket types
 * we have 5 types of tickets
 * and a method that will return a random ticket type
 *
 * Created by Joseph Thursday, 23.02.2017 at 16:37.
 * @author Pop Iosif Cristian
 * @version 1.0
 */
public enum TicketType {
    FULL,FULL_VIP,FREE_PASS,ONE_DAY,ONE_DAY_VIP;

    private static final TicketType[] TYPES = values();
    private static final int SIZE = TYPES.length;
    private static final Random RANDOM = new Random();

    /**
     * We will use this method in festival attendee to set up the
     * festival attendees with random tickets
     * @return a random ticket type
     */
    public static TicketType getRandomTicketType(){
        return TYPES[RANDOM.nextInt(SIZE)];
    }
}
