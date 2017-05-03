package com.homework.main;

import java.util.LinkedList;
import java.util.Queue;

/**This is the FestivalGate class that have the goal to define a festival gate
 * In this class we will store the tickets in a que and count the tickets
 *
 * Created by Joseph Thursday, 23.02.2017 at 16:36.
 * @author Pop Iosif Cristian
 * @version 1.0
 */
public class FestivalGate {
    private int people,fullTickets, freePasses, fullVip, oneDay, oneDayVip;
    private Queue<TicketType> queue = new LinkedList<>();

    /**
     * This method will count tickets and  get the info stored for the statistics thread
     */
    public void getInfo(){
        countTickets();
        setPeople(queue.size());
        System.out.println("\n"+getPeople()+ " people entered" + '\n' +
                getFullTickets() + " with full tickets" + '\n' +
                getFreePasses() + " with free passes" + '\n' +
                getFullVip() + " with full VIP passes" + '\n' +
                getOneDay() + " with one day passes" + '\n' +
                getOneDayVip() + " with one day VIP passes" + '\n');
    }

    /**We will use this method to add the tickets from the attendees in a que
     * @param ticketType ticket type from a attendee
     */
    public void addTicket(TicketType ticketType){
        queue.add(ticketType);
    }

    /**
     * This method will reset our count to 0
     */
    public void resetCount(){
        setFullVip(0);
        setOneDayVip(0);
        setOneDay(0);
        setFullTickets(0);
        setFreePasses(0);
    }

    /**
     * This method will check our queue and it will count our tickets by type
     */
    public void countTickets(){
        resetCount();
        for (TicketType ticketType : queue) {
            switch (ticketType) {
                case FREE_PASS:
                    freePasses++;
                    break;
                case FULL:
                    fullTickets++;
                    break;
                case FULL_VIP:
                    fullVip++;
                    break;
                case ONE_DAY:
                    oneDay++;
                    break;
                case ONE_DAY_VIP:
                    oneDayVip++;
                    break;
            }
        }
    }

    public Queue<TicketType> getQueue() {
        return queue;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public int getFullTickets() {
        return fullTickets;
    }


    public int getFreePasses() {
        return freePasses;
    }


    public int getFullVip() {
        return fullVip;
    }


    public int getOneDay() {
        return oneDay;
    }


    public int getOneDayVip() {
        return oneDayVip;
    }

    public void setFullTickets(int fullTickets) {
        this.fullTickets = fullTickets;
    }

    public void setFreePasses(int freePasses) {
        this.freePasses = freePasses;
    }

    public void setFullVip(int fullVip) {
        this.fullVip = fullVip;
    }

    public void setOneDay(int oneDay) {
        this.oneDay = oneDay;
    }

    public void setOneDayVip(int oneDayVip) {
        this.oneDayVip = oneDayVip;
    }
}
