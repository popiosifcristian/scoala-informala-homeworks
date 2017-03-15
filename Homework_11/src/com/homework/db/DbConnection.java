package com.homework.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**This is the DbConnection class where we will have the info of connection
 * and the connection with driver on our database
 *
 * Created by Joseph Tuesday, 07.03.2017 at 13:23.
 *
 * @author Pop Iosif Cristian
 * @version 1.0
 */
public class DbConnection {
    public Connection connect() throws DbException, SQLException{
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            DriverManager.setLoginTimeout(60);
            connection = DriverManager.getConnection(urlBuilder());
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e ){
        throw new DbException("Could not load DB driver", e);
        }
        return connection;
    }

    private String urlBuilder(){
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
        return url;
    }
}
