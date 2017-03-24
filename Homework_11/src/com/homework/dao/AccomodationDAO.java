package com.homework.dao;

import com.homework.db.DbException;
import com.homework.model.Accomodation;

import java.sql.SQLException;
import java.util.List;

/**This is the DAO interface for accomodation
 *
 * This class contains signatures for CRUD methods
 *
 * Created by Joseph Thursday, 09.03.2017 at 23:47.
 *
 * @author Pop Iosif Cristian
 * @version 1.0
 */
public interface AccomodationDAO {
    //C
    void add(Accomodation accomodation) throws DbException, SQLException;

    //R
    List<Accomodation> getAll() throws DbException, SQLException;

    //U
    void update(Accomodation accomodation) throws DbException, SQLException;

    //D
    void delete(Accomodation accomodation) throws DbException, SQLException;
}
