package com.homework.test.db;

import com.homework.db.DbConnection;
import com.homework.db.DbException;
import com.homework.sql.DbManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**This class have the goal to implements the methods for @After, @Before, @AfterClass, @BeforeClass
 *
 * Created by Joseph Sunday, 3/12/2017 at 2:02 AM
 *
 * @author Pop Iosif Cristian
 * @version 1.0
 */
public class BookingDbTest extends DbConnection {

    private  Connection connectToPostgreSQL() throws SQLException, DbException {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            Connection connection = null;
            DriverManager.setLoginTimeout(60);
            String url = new StringBuilder()
                    .append("jdbc:")
                    .append("postgresql")
                    .append("://")
                    .append("localhost")
                    .append(":")
                    .append(4321)
                    .append("/")
                    .append("booking_db")
                    .append("?user=")
                    .append("iosif")
                    .append("&password=")
                    .append("password").toString();
            return DriverManager.getConnection(url);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new DbException("Could not load DB driver.", e);
        }
    }

    public Connection connect() throws DbException, SQLException {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            Connection connection = null;
            DriverManager.setLoginTimeout(60);
            String url = new StringBuilder()
                    .append("jdbc:")
                    .append("postgresql")
                    .append("://")
                    .append("localhost")
                    .append(":")
                    .append(4321)
                    .append("/")
                    .append("booking_test")
                    .append("?user=")
                    .append("iosif")
                    .append("&password=")
                    .append("password").toString();
            return DriverManager.getConnection(url);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new DbException("Could not load DB driver.", e);
        }
    }

    public static void setUpTestDB() throws DbException, SQLException {
        BookingDbTest bdt = new BookingDbTest();
        try(Connection connection = bdt.connectToPostgreSQL()) {
            Statement statement = connection.createStatement();
            statement.execute("CREATE DATABASE booking_test;");
        }

        try(Connection connection = bdt.connect()) {
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
            statement = connection.createStatement();
            statement.execute(builder.toString());
        }
    }

    public static void dropTestDB() throws DbException, SQLException {
        BookingDbTest bdt = new BookingDbTest();
        try(Connection connection = bdt.connectToPostgreSQL()) {
            Statement statement = connection.createStatement();
            statement.execute("DROP DATABASE booking_test;");
        }
    }

    public void dropDataFromTables() throws DbException, SQLException {
        try(Connection connection = connect()){
            StringBuilder builder = new StringBuilder();
            builder.append("DELETE FROM accomodation_fair_relation;");
            builder.append("DELETE FROM accomodation;");
            builder.append("DELETE FROM room_fair;");
            Statement statement = connection.createStatement();
            statement = connection.createStatement();
            statement.execute(builder.toString());
        }
        try(Connection connection = connect()){
            StringBuilder builder = new StringBuilder();
            builder.append("ALTER SEQUENCE accomodation_ids RESTART WITH 1;");
            builder.append("ALTER SEQUENCE room_fair_ids RESTART WITH 1;");
            builder.append("ALTER SEQUENCE accomodation_fair_relation_ids RESTART WITH 1;");
            Statement statement = connection.createStatement();
            statement = connection.createStatement();
            statement.execute(builder.toString());
        }

    }


}
