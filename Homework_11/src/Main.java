import com.homework.dao.sql.SQLAccomodationDAO;
import com.homework.dao.sql.SQLAccomodationFairRelationDAO;
import com.homework.dao.sql.SQLRoomFairDAO;
import com.homework.db.DbConnection;
import com.homework.db.DbException;
import com.homework.model.Accomodation;
import com.homework.model.RoomFair;
import com.homework.sql.DbManagement;

import java.sql.SQLException;

/**
 * Created by Joseph Thursday, 09.03.2017 at 20:27.
 *
 * @author Pop Iosif Cristian
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws DbException, SQLException {

        DbConnection dbConnection = new DbConnection();
        DbManagement dbManagement = new DbManagement(dbConnection);
        dbManagement.resetDb();
        dbManagement.createBookingDb();

        SQLAccomodationDAO accomodationDAO = new SQLAccomodationDAO(dbConnection);
        SQLRoomFairDAO roomFairDAO = new SQLRoomFairDAO(dbConnection);
        SQLAccomodationFairRelationDAO accomodationFairRelationDAO = new SQLAccomodationFairRelationDAO(dbConnection);

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


        accomodationFairRelationDAO.setAll();

    }
}
