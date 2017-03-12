package com.homework.dao;

import com.homework.db.DbException;
import com.homework.model.AccomodationFairRelation;

import java.sql.SQLException;
import java.util.List;

/**This is the DAO interface for accomodation_fair_relation
 * Created by Joseph Friday, 10.03.2017 at 00:17.
 *
 *  *This class contains signatures for CRUD methods

 * @author Pop Iosif Cristian
 * @version 1.0
 */
public interface AccomodationFairRelationDAO {


    void setAll() throws DbException, SQLException;


    List<AccomodationFairRelation> getAll() throws DbException, SQLException;

}
