package com.homework.dao.sql;

import com.homework.dao.AccomodationFairRelationDAO;
import com.homework.db.DbConnection;
import com.homework.db.DbException;
import com.homework.model.AccomodationFairRelation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**This is SQLAccomodationFairRelationDAO class where we will implement CRUD
 *
 * Created by Joseph Friday, 10.03.2017 at 00:19.
 *
 * @author Pop Iosif Cristian
 * @version 1.0
 */
public class SQLAccomodationFairRelationDAO implements AccomodationFairRelationDAO {

    private DbConnection dbConnection = new DbConnection();

    public SQLAccomodationFairRelationDAO(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    /**
     * This method will get all elements from accomodation_fair_relation table and will
     * @return a list of accomodation fair relations
     */
    @Override
    public List<AccomodationFairRelation> getAll() throws DbException, SQLException {
        try(Connection connection = dbConnection.connect()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from accomodation_fair_relation;");
            ArrayList<AccomodationFairRelation> afr = new ArrayList<>();
            while (resultSet.next()){
                afr.add(mapResultSetToAccomodationFairRelation(resultSet)) ;
            }
            return afr;
        }
    }
    /**
     * This method will get info from
     * @param resultSet
     * and will
     * @return an AccomodationFairRelation object with proprieties from result set
     */
    private AccomodationFairRelation mapResultSetToAccomodationFairRelation(ResultSet resultSet) throws SQLException{
        AccomodationFairRelation afr = new AccomodationFairRelation(resultSet.getInt(1),
                                                                    resultSet.getInt(2));
        afr.setId(resultSet.getInt("id"));
        return afr;
    }

    /**
     *This method will set up the accomodation_fair_relation table
     * using a inner join with accomodation and room_fair tables
     */
    @Override
    public void setAll() throws DbException, SQLException {
        try(Connection connection = dbConnection.connect()){
            StringBuilder builder = new StringBuilder();
            builder.append("DELETE FROM accomodation_fair_relation;");
            builder.append("ALTER SEQUENCE accomodation_ids RESTART WITH 1;");
            Statement statement = connection.createStatement();
            statement = connection.createStatement();
            statement.execute(builder.toString());
        }
        try(Connection connection = dbConnection.connect()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT accomodation.id,room_fair.id FROM accomodation JOIN room_fair ON accomodation.id=room_fair.id;");
            statement = connection.createStatement();

            while(resultSet.next()){
                statement.executeUpdate("INSERT INTO accomodation_fair_relation(id_accomodation,id_room_fair) values('"+
                        resultSet.getInt(1)+"','"+resultSet.getInt(2)+"');");
            }
        }
    }

}
