package com.homework.test.sql;

import com.homework.dao.sql.SQLAccomodationDAO;
import com.homework.dao.sql.SQLAccomodationFairRelationDAO;
import com.homework.dao.sql.SQLRoomFairDAO;
import com.homework.db.DbException;
import com.homework.model.Accomodation;
import com.homework.model.AccomodationFairRelation;
import com.homework.model.RoomFair;
import com.homework.test.db.BookingDbTest;
import org.junit.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**This is the main test class.
 * I used this class to test my code and to verify the database
 *
 * Created by Joseph Sunday, 3/12/2017 at 3:47 AM
 *
 * @author Pop Iosif Cristian
 * @version 1.0
 */
public class SQLBookingTest {

    BookingDbTest bookingDbTest;

    SQLAccomodationDAO accomodationDAO ;
    SQLRoomFairDAO roomFairDAO ;
    SQLAccomodationFairRelationDAO accomodationFairRelationDAO;

    @BeforeClass
    public static void initTests() throws DbException, SQLException {
        BookingDbTest.setUpTestDB();
    }

    @AfterClass
    public static void discardTests() throws DbException, SQLException {
        BookingDbTest.dropTestDB();
    }

    @Before
    public void setUp(){
        bookingDbTest = new BookingDbTest();
        accomodationDAO = new SQLAccomodationDAO(bookingDbTest);
        roomFairDAO = new SQLRoomFairDAO(bookingDbTest);
        accomodationFairRelationDAO = new SQLAccomodationFairRelationDAO(bookingDbTest);
    }

    @After
    public void tearDown() throws DbException, SQLException {
        bookingDbTest.dropDataFromTables();
    }

    @Test
    public void insert_accomodations_into_db() throws DbException, SQLException{
        Accomodation a1 = new Accomodation("Single","Full size",1,"-");
        Accomodation a2 = new Accomodation("Double","Full extra long",2,"-");
        Accomodation a3 = new Accomodation("Triple","Twin extra long",3,"-");
        Accomodation a4 = new Accomodation("Quad","Cal-king",4,"-");
        Accomodation a5 = new Accomodation("Queen","Queen size",1,"-");
        Accomodation a6 = new Accomodation("King","King size",2,"-");
        accomodationDAO.add(a1);
        accomodationDAO.add(a2);
        accomodationDAO.add(a3);
        accomodationDAO.add(a4);
        accomodationDAO.add(a5);
        accomodationDAO.add(a6);

        List<Accomodation> list = accomodationDAO.getAll();

        Assert.assertArrayEquals(new Accomodation[]{a1,a2,a3,a4,a5,a6}, list.toArray());
    }

    @Test
    public void delete_accomodations_from_db() throws DbException, SQLException{
        Accomodation a1 = new Accomodation("Single","Full size",1,"-");
        Accomodation a2 = new Accomodation("Double","Full extra long",2,"-");
        accomodationDAO.add(a1);
        accomodationDAO.add(a2);

        accomodationDAO.delete(a1);
        accomodationDAO.delete(a2);

        List<Accomodation> list = accomodationDAO.getAll();

        Assert.assertEquals(0,list.size());
    }

    @Test
    public void update_accomodation_into_db() throws DbException, SQLException{
        Accomodation a1 = new Accomodation("Single","Full size",1,"-");
        Accomodation a2 = new Accomodation("Double","Full extra long",2,"-");
        accomodationDAO.add(a1);
        accomodationDAO.add(a2);

        a1.setType(a2.getType());
        a1.setBedType(a2.getBedType());
        a1.setMaxGuests(a2.getMaxGuests());
        a1.setDescription(a2.getDescription());

        accomodationDAO.update(a1);

        List<Accomodation> list = accomodationDAO.getAll();

        Assert.assertEquals(a2,list.get(0));
    }

    @Test
    public void insert_room_fair_into_db() throws DbException, SQLException{
        RoomFair r1 = new RoomFair(100,"Summer");
        RoomFair r2 = new RoomFair(200,"Summer");
        RoomFair r3 = new RoomFair(300,"Summer");
        RoomFair r4 = new RoomFair(400,"Summer");
        RoomFair r5 = new RoomFair(200,"Summer");
        RoomFair r6 = new RoomFair(200,"Summer");
        roomFairDAO.add(r1);
        roomFairDAO.add(r2);
        roomFairDAO.add(r3);
        roomFairDAO.add(r4);
        roomFairDAO.add(r5);
        roomFairDAO.add(r6);

        List<RoomFair> list = roomFairDAO.getAll();

        Assert.assertArrayEquals(new RoomFair[]{r1,r2,r3,r4,r5,r6}, list.toArray());
    }

    @Test
    public void delete_room_fairs_from_db() throws DbException, SQLException{
        RoomFair r1 = new RoomFair(100,"Summer");
        RoomFair r2 = new RoomFair(200,"Summer");
        roomFairDAO.add(r1);
        roomFairDAO.add(r2);

        roomFairDAO.delete(r1);

        List<RoomFair> list = roomFairDAO.getAll();

        Assert.assertEquals(1,list.size());
    }

    @Test
    public void update_room_fair_into_db() throws DbException, SQLException{
        RoomFair r1 = new RoomFair(100,"Summer");
        RoomFair r2 = new RoomFair(200,"Summer");
        roomFairDAO.add(r1);
        roomFairDAO.add(r2);

        r1.setValue(r2.getValue());
        r1.setSeason(r2.getSeason());


        roomFairDAO.update(r1);

        List<RoomFair> list = roomFairDAO.getAll();

        Assert.assertEquals(r2,list.get(0));
    }

    @Test
    public void set_relation_table() throws DbException, SQLException{
        Accomodation a1 = new Accomodation("Single","Full size",1,"-");
        Accomodation a2 = new Accomodation("Double","Full extra long",2,"-");
        Accomodation a3 = new Accomodation("Triple","Twin extra long",3,"-");
        Accomodation a4 = new Accomodation("Quad","Cal-king",4,"-");
        accomodationDAO.add(a1);
        accomodationDAO.add(a2);
        accomodationDAO.add(a3);
        accomodationDAO.add(a4);
        RoomFair r1 = new RoomFair(100,"Summer");
        RoomFair r2 = new RoomFair(200,"Summer");
        roomFairDAO.add(r1);
        roomFairDAO.add(r2);

        accomodationFairRelationDAO.setAll();
        List list = accomodationFairRelationDAO.getAll();
        AccomodationFairRelation o1 = new AccomodationFairRelation(1,1);
        o1.setId(1);
        AccomodationFairRelation o2 = new AccomodationFairRelation(2,2);
        o2.setId(2);

        Assert.assertArrayEquals(new AccomodationFairRelation[]{o1,o2},list.toArray());
    }

    @Test
    public void room_value_interogation() throws DbException, SQLException {
        Accomodation a4 = new Accomodation("Quad","Cal-king",4,"-");
        Accomodation a5 = new Accomodation("Queen","Queen size",1,"-");
        Accomodation a6 = new Accomodation("King","King size",2,"-");
        accomodationDAO.add(a4);
        accomodationDAO.add(a5);
        accomodationDAO.add(a6);
        RoomFair r4 = new RoomFair(400,"Summer");
        RoomFair r5 = new RoomFair(200,"Summer");
        RoomFair r6 = new RoomFair(200,"Summer");
        roomFairDAO.add(r4);
        roomFairDAO.add(r5);
        roomFairDAO.add(r6);

        List list = new ArrayList();
        list.add(a4.getId());list.add(a4.getType());list.add(a4.getBedType());list.add(a4.getMaxGuests());list.add(a4.getDescription());list.add(r4.getValue());
        list.add(a5.getId());list.add(a5.getType());list.add(a5.getBedType());list.add(a5.getMaxGuests());list.add(a5.getDescription());list.add(r5.getValue());
        list.add(a6.getId());list.add(a6.getType());list.add(a6.getBedType());list.add(a6.getMaxGuests());list.add(a6.getDescription());list.add(r6.getValue());

        List rs = new ArrayList();

        try(Connection connection = bookingDbTest.connect()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT accomodation.id,accomodation.type,accomodation.bed_type,accomodation.max_guests,accomodation.description,room_fair.value FROM accomodation INNER JOIN room_fair ON accomodation.id=room_fair.id;");

            while(resultSet.next()){
                rs.add(resultSet.getInt(1));
                rs.add(resultSet.getString(2));
                rs.add(resultSet.getString(3));
                rs.add(resultSet.getInt(4));
                rs.add(resultSet.getString(5));
                rs.add(resultSet.getDouble(6));
            }
        }
    Assert.assertArrayEquals(list.toArray(),rs.toArray());
    }

}
