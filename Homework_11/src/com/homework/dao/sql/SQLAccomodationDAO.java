package com.homework.dao.sql;

import com.homework.dao.AccomodationDAO;
import com.homework.db.DbConnection;
import com.homework.db.DbException;
import com.homework.model.Accomodation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**This is SQLAccomodationDAO class where we will implement CRUD
 *
 * Created by Joseph Thursday, 09.03.2017 at 22:56.
 *
 * @author Pop Iosif Cristian
 * @version 1.0
 */
public class SQLAccomodationDAO implements AccomodationDAO {

    private DbConnection dbConnection = new DbConnection();

    public SQLAccomodationDAO(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    /**
     * This method will insert into accomodation table a row with accomodation object proprieties from
     * @param accomodation
     * and will set id of the accomodation object with the id from accomodation table
     */
    @Override
    public void add(Accomodation accomodation) throws DbException, SQLException {
        try(Connection connection=dbConnection.connect()) {
            Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO accomodation(type,bed_type,max_guests,description) values('"+
        accomodation.getType()+"','"+accomodation.getBedType()+"','"+accomodation.getMaxGuests()+"','"+
        accomodation.getDescription()+"');");
            ResultSet resultSet = statement.executeQuery("SELECT CURRVAL('accomodation_ids');");
            resultSet.next();
            accomodation.setId(resultSet.getInt(1));
        }
    }

    /**
     * This method will get all elements from accomodation table and will
     * @return a list of accomodations
     */
    @Override
    public List getAll() throws DbException, SQLException {
        try(Connection connection=dbConnection.connect()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from accomodation;");
            ArrayList<Accomodation> accomodations = new ArrayList<>();
            while (resultSet.next()){
              accomodations.add(mapResultSetToAccomodation(resultSet)) ;
            }
            return accomodations;
        }
    }

    /**
     * This method will get info from
     * @param resultSet
     * and will
     * @return an Accomodation object with proprieties from result set
     */
    private Accomodation mapResultSetToAccomodation(ResultSet resultSet) throws SQLException{
        Accomodation accomodation = new Accomodation(resultSet.getString("type"),
                                                     resultSet.getString("bed_type"),
                                                     resultSet.getInt("max_guests"),
                                                     resultSet.getString("description"));
        accomodation.setId(resultSet.getInt("id"));
        return accomodation;
    }

    /**
     * This method will update set of proprieties of
     * @param accomodation Accomodation object
     * using his id
     */
    @Override
    public void update(Accomodation accomodation) throws DbException, SQLException {
        try(Connection connection=dbConnection.connect()){
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE accomodation SET type = '"+accomodation.getType()+"'," +
                    " bed_type = '"+accomodation.getBedType()+"', max_guests = '"+accomodation.getMaxGuests()+"',"+
            " description = '"+accomodation.getDescription()+"' WHERE id = "+accomodation.getId()+";");
        }
    }

    /**
     * This method will delete by id the
     * @param accomodation
     * from the data base
     */
    @Override
    public void delete(Accomodation accomodation) throws DbException, SQLException {
        try(Connection connection = dbConnection.connect()){
        Statement statement = connection.createStatement();
        statement.execute("DELETE FROM accomodation WHERE id="+ accomodation.getId()+";");
        }
    }
}
