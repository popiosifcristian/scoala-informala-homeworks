package com.homework.sql;

import com.homework.db.DbConnection;
import com.homework.db.DbException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**This is the DbManagement class
 * I used this class when i started the project to get used with databases and DAO classes
 *
 * Created by Joseph Tuesday, 07.03.2017 at 15:22.
 *
 * @author Pop Iosif Cristian
 * @version 1.0
 */
public class DbManagement {

    private DbConnection dbConnection = new DbConnection();

    public DbManagement(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void createBookingDb() throws DbException, SQLException{

        try(Connection connection = dbConnection.connect()){
            StringBuilder builder = new StringBuilder();

            //Accomodation Table
            builder.append("CREATE SEQUENCE accomodation_ids;");
            builder.append("CREATE TABLE accomodation(id INT PRIMARY KEY DEFAULT NEXTVAL('accomodation_ids'), " +
                    "type VARCHAR(32), bed_type VARCHAR(32), max_guests INT, description VARCHAR(512));");

            //Room Fair Table
            builder.append("CREATE SEQUENCE room_fair_ids;");
            builder.append("CREATE TABLE room_fair(id INT PRIMARY KEY DEFAULT NEXTVAL('room_fair_ids'), " +
                    "value DOUBLE PRECISION, season VARCHAR(32));");

            //Accomodation Fair Relation Table
            builder.append("CREATE SEQUENCE accomodation_fair_relation_ids;");
            builder.append("CREATE TABLE accomodation_fair_relation(id INT PRIMARY KEY DEFAULT NEXTVAL " +
                    "('accomodation_fair_relation_ids'), id_accomodation INT REFERENCES accomodation(id), " +
                    "id_room_fair INT REFERENCES room_fair(id));");


            Statement statement = connection.createStatement();
            statement.execute(builder.toString());
        }
    }

    public  void resetDb() throws DbException, SQLException {
        try(Connection connection=dbConnection.connect()){
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE accomodation_fair_relation , accomodation , room_fair;");
            statement.execute("DROP SEQUENCE accomodation_ids,room_fair_ids,accomodation_fair_relation_ids;");
        }
    }
}
