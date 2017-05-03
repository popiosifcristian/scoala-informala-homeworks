package com.homework.db;

/**This is the DbException class
 *
 * Created by Joseph Tuesday, 07.03.2017 at 13:25.
 *
 * @author Pop Iosif Cristian
 * @version 1.0
 */
public class DbException extends Throwable {
    public DbException(String s, Exception e){
        super(s,e);
    }
}
