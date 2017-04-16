package com.homework.main;
/**This is FestivalAttendeeThread class that extend Thread and have the goal to
 * add Festival Attendees to our gate and to our data base(the queue from gate)
 *
 * Created by Joseph Saturday, 25.02.2017 at 22:14.
 * @author Pop Iosif Cristian
 * @version 1.0
 */
public class FestivalAttendeeThread extends Thread {

    private FestivalGate festivalGate;
    private FestivalAttendee festivalAttendee = new FestivalAttendee();
    private int no;
    private int attendeesNumber=111;//we will set as default 111 attendees
    public FestivalAttendeeThread(FestivalGate festivalGate) {
        this.festivalGate = festivalGate;
    }

    @Override
    public void run() {
        synchronized (festivalGate) {

            for (int i=1;i<=attendeesNumber;i++){
            try {
                Thread.sleep(350);
                festivalAttendee = new FestivalAttendee();
                festivalGate.addTicket(festivalAttendee.getTicketType());

            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
            setNo(getNo()+1);
            System.out.println("no "+getNo()+" attendee with: " + festivalAttendee.getTicketType());
        }
        }
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

}
