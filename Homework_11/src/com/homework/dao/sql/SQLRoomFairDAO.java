package com.homework.dao.sql;

import com.homework.dao.RoomFairDAO;
import com.homework.db.DbConnection;
import com.homework.db.DbException;
import com.homework.model.RoomFair;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**This is SQLRoomFairDAO class where we will implement CRUD
 *
 * Created by Joseph Friday, 10.03.2017 at 00:05.
 *
 * @author Pop Iosif Cristian
 * @version 1.0
 */
public class SQLRoomFairDAO implements RoomFairDAO {

    private DbConnection dbConnection = new DbConnection();

    public SQLRoomFairDAO(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }
    /**
     * This method will insert into room_fair table a row with roomFair object proprieties from
     * @param roomFair
     * and will set id of the roomFair object with the id from room_fair table
     */
    @Override
    public void add(RoomFair roomFair) throws DbException, SQLException {
        try(Connection connection=dbConnection.connect()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO room_fair(value,season) values('"+
                    roomFair.getValue()+"','"+roomFair.getSeason()+"');");
            ResultSet resultSet = statement.executeQuery("SELECT CURRVAL('room_fair_ids');");
            resultSet.next();
            roomFair.setId(resultSet.getInt(1));
        }
    }

    /**
     * This method will get all elements from room_fair table and will
     * @return a list of room fairs
     */
    @Override
    public List<RoomFair> getAll() throws DbException, SQLException {
        try(Connection connection=dbConnection.connect()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from room_fair;");
            ArrayList<RoomFair> roomFairs = new ArrayList<>();
            while (resultSet.next()){
                roomFairs.add(mapResultSetToRoomFair(resultSet)) ;
            }
            return roomFairs;
        }
    }

    /**
     * This method will get info from
     * @param resultSet
     * and will
     * @return an RoomFair object with proprieties from result set
     */
    private RoomFair mapResultSetToRoomFair(ResultSet resultSet)throws SQLException{
        RoomFair roomFair = new RoomFair(resultSet.getDouble("value"),
                                         resultSet.getString("season"));
        roomFair.setId(resultSet.getInt("id"));
        return roomFair;
    }

    /**
     * This method will update set of proprieties of
     * @param roomFair RoomFair object
     * using his id
     */
    @Override
    public void update(RoomFair roomFair) throws DbException, SQLException {
        try(Connection connection=dbConnection.connect()){
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE room_fair SET value = '"+roomFair.getValue()+"'," +
                    " season = '"+roomFair.getSeason()+"' WHERE id = "+roomFair.getId()+";");
        }
    }

    /**
     * This method will delete by id the
     * @param roomFair
     * from the data base
     */
    @Override
    public void delete(RoomFair roomFair) throws DbException, SQLException {
        try(Connection connection = dbConnection.connect()){
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM room_fair WHERE id="+ roomFair.getId()+";");
        }
    }
}
