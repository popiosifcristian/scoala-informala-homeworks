package com.homework.tests;
import com.homework.main.FestivalGate;
import com.homework.main.TicketType;
import org.junit.Assert;
import org.junit.Test;

/**This is the Tests class
 *
 * Created by Joseph Sunday, 26.02.2017 at 21:00.
 * @author Pop Iosif Cristian
 * @version 1.0
 */
public class Tests {
    @Test
    public void counting_full_tickets_test(){
        FestivalGate gate = new FestivalGate();
        gate.addTicket(TicketType.FULL);
        gate.addTicket(TicketType.FULL);

        gate.countTickets();
        Assert.assertEquals(2,gate.getFullTickets());
    }
    @Test
    public void counting_free_tickets_test(){
        FestivalGate gate = new FestivalGate();
        gate.addTicket(TicketType.FREE_PASS);
        gate.addTicket(TicketType.FREE_PASS);
        gate.addTicket(TicketType.FREE_PASS);

        gate.countTickets();
        Assert.assertEquals(3,gate.getFreePasses());
    }
    @Test
    public void counting_VIP_tickets_test(){
        FestivalGate gate = new FestivalGate();
        gate.addTicket(TicketType.FULL_VIP);

        gate.countTickets();
        Assert.assertEquals(1,gate.getFullVip());
    }
    @Test
    public void counting_oneDay_tickets_test(){
        FestivalGate gate = new FestivalGate();
        gate.addTicket(TicketType.ONE_DAY);
        gate.addTicket(TicketType.ONE_DAY);
        gate.addTicket(TicketType.ONE_DAY);
        gate.addTicket(TicketType.ONE_DAY);

        gate.countTickets();
        Assert.assertEquals(4,gate.getOneDay());
    }
    @Test
    public void counting_oneDayVip_tickets_test(){
        FestivalGate gate = new FestivalGate();
        gate.addTicket(TicketType.ONE_DAY_VIP);
        gate.addTicket(TicketType.ONE_DAY_VIP);

        gate.countTickets();
        Assert.assertEquals(2,gate.getOneDayVip());
    }
    @Test
    public void counting_tickets_test(){
        FestivalGate gate = new FestivalGate();
        gate.addTicket(TicketType.FULL);
        gate.addTicket(TicketType.FULL);
        gate.addTicket(TicketType.FREE_PASS);
        gate.addTicket(TicketType.FULL_VIP);
        gate.addTicket(TicketType.FULL_VIP);
        gate.addTicket(TicketType.FULL_VIP);
        gate.addTicket(TicketType.ONE_DAY);
        gate.addTicket(TicketType.ONE_DAY);
        gate.addTicket(TicketType.ONE_DAY);
        gate.addTicket(TicketType.ONE_DAY);
        gate.addTicket(TicketType.ONE_DAY);

        gate.countTickets();
        Assert.assertEquals(2,gate.getFullTickets());
        Assert.assertEquals(1,gate.getFreePasses());
        Assert.assertEquals(3,gate.getFullVip());
        Assert.assertEquals(5,gate.getOneDay());
        Assert.assertEquals(0,gate.getOneDayVip());
    }

    @Test
    public void resetCount_test(){
        FestivalGate gate = new FestivalGate();
        gate.addTicket(TicketType.FULL);
        gate.addTicket(TicketType.FULL);
        gate.addTicket(TicketType.FREE_PASS);
        gate.addTicket(TicketType.FULL_VIP);
        gate.addTicket(TicketType.FULL_VIP);
        gate.addTicket(TicketType.FULL_VIP);
        gate.addTicket(TicketType.ONE_DAY);
        gate.addTicket(TicketType.ONE_DAY);
        gate.countTickets();
        gate.resetCount();
        Assert.assertEquals(0,gate.getFullTickets());
        Assert.assertEquals(0,gate.getFreePasses());
        Assert.assertEquals(0,gate.getFullVip());
        Assert.assertEquals(0,gate.getOneDay());
        Assert.assertEquals(0,gate.getOneDayVip());
    }

    @Test
    public void add_tickets_test(){
        FestivalGate gate = new FestivalGate();
        gate.addTicket(TicketType.FULL);
        gate.addTicket(TicketType.FULL);

        Assert.assertEquals(2,gate.getQueue().size());
    }



}
