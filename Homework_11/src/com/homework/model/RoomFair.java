package com.homework.model;

/**This is the RoomFair class
 * This class have the goal to define a room fair
 * Created by Joseph Thursday, 09.03.2017 at 17:30.
 *
 * @author Pop Iosif Cristian
 * @version 1.0
 */
public class RoomFair {
    private int id;
    private double value;
    private String season;

    public RoomFair(double value, String season) {
        this.value = value;
        this.season = season;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomFair roomFair = (RoomFair) o;

        if (id != roomFair.id) return false;
        if (Double.compare(roomFair.value, value) != 0) return false;
        return season != null ? season.equals(roomFair.season) : roomFair.season == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        temp = Double.doubleToLongBits(value);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (season != null ? season.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RoomFair{" +
                "id=" + id +
                ", value=" + value +
                ", season='" + season + '\'' +
                '}';
    }
}
