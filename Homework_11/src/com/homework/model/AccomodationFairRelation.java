package com.homework.model;

/**This is the AccomodationFairRelation class
 * This class have the goal to define an relation between  accomodation table and fair_room table
 *
 * Created by Joseph Thursday, 09.03.2017 at 17:31.
 *
 * @author Pop Iosif Cristian
 * @version 1.0
 */
public class AccomodationFairRelation {

    private int id;
    private int idAccomodation;
    private int idRoomFair;

    public AccomodationFairRelation(int idAccomodation, int idRoomFair) {
        this.idAccomodation = idAccomodation;
        this.idRoomFair = idRoomFair;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAccomodation() {
        return idAccomodation;
    }

    public void setIdAccomodation(int idAccomodation) {
        this.idAccomodation = idAccomodation;
    }

    public int getIdRoomFair() {
        return idRoomFair;
    }

    public void setIdRoomFair(int idRoomFair) {
        this.idRoomFair = idRoomFair;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccomodationFairRelation that = (AccomodationFairRelation) o;

        if (id != that.id) return false;
        if (idAccomodation != that.idAccomodation) return false;
        return idRoomFair == that.idRoomFair;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idAccomodation;
        result = 31 * result + idRoomFair;
        return result;
    }

    @Override
    public String toString() {
        return "AccomodationFairRelation{" +
                "id=" + id +
                ", idAccomodation=" + idAccomodation +
                ", idRoomFair=" + idRoomFair +
                '}';
    }
}
