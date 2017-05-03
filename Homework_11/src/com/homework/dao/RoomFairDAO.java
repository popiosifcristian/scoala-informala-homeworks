package com.homework.dao;

import com.homework.db.DbException;
import com.homework.model.Accomodation;
import com.homework.model.RoomFair;

import java.sql.SQLException;
import java.util.List;

/**This is the DAO interface for room_fair
 *
 *  *This class contains signatures for CRUD methods

 * Created by Joseph Friday, 10.03.2017 at 00:04.
 *
 * @author Pop Iosif Cristian
 * @version 1.0
 */
public interface RoomFairDAO {
    //C
    void add(RoomFair roomFair) throws DbException, SQLException;

    //R
    List<RoomFair> getAll() throws DbException, SQLException;

    //U
    void update(RoomFair roomFair) throws DbException, SQLException;

    //D
    void delete(RoomFair roomFair) throws DbException, SQLException;
}
