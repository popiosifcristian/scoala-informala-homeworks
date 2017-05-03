package com.homework.main;

/**This is the FestivalAttendee class that have the goal to define the festival attendee
 *
 * Created by Joseph Thursday, 23.02.2017 at 16:37.
 * @author Pop Iosif Cristian
 * @version 1.0
 */
public class FestivalAttendee {
    private TicketType ticket;

    public FestivalAttendee() {
        this.ticket = TicketType.getRandomTicketType();
    }

    public TicketType getTicketType() {
        return ticket;
    }

}
