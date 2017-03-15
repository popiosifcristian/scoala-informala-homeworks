package com.homework.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**This is the Competition Management class
 * here we will have the methods that will give us the result of competition
 * @author Pop Iosif Cristian
 */
public class CompetitionManagement {


    List<Athlete>athletes=new ArrayList<Athlete>();
    /**This method will calculate shooting of an athlete
     * This method will get a string of shooting and will store the characters in an array of strings
     * if one character is "o" it means that the athlete missed a shot
     * for every missed shot the method will add 10 seconds
     * @param shooting the shooting result of the athlete
     * @return seconds caused by missed shots
     */
    public int calculateShooting(String shooting){
        int seconds=0;
        String[] splitedShooting=shooting.split("(?!^)");

        for(int i=0;i<5;i++){
            if(splitedShooting[i].equals("o"))
                seconds=seconds+10;
        }
        return seconds;
    }

    /**
     * This method will calculate the time of an athlete using all shootings
     * we will add seconds to the athlete using calculateShooting method
     * @param athlete an athlete
     */
    public void calculateTime(Athlete athlete){
        athlete.setSeconds(athlete.getSeconds()+calculateShooting(athlete.getFirstShooting())+
                calculateShooting(athlete.getSecondShooting())+
                calculateShooting(athlete.getThirdShooting()));

        if (athlete.getSeconds()>=60)
        while(athlete.getSeconds()>=60){
            athlete.setMinutes(athlete.getMinutes()+1);
            athlete.setSeconds(athlete.getSeconds()-60);
        }
    }

    /**
     * This is the Time Comparator of athletes
     * we will use this comparator to get the order of finishing of the competition
     */
    static class TimeComparator implements Comparator<Athlete>{
        @Override
        public int compare(Athlete a1, Athlete a2) {
            if (a1.getMinutes()==a2.getMinutes()&&a1.getSeconds()==a2.getSeconds())
                return 0;
            if (a1.getMinutes()==a2.getMinutes()&&a1.getSeconds()>a2.getSeconds())
                return 1;
            if (a1.getMinutes()>a2.getMinutes())
                return 1;
            return -1;
        }
    }

    /**
     * This method will calculate results of our competition
     * This method will calculate time of all athletes using calculateTime method
     * and will sort our list of athletes using TimeComparator
     */
    public void calculateResults(){
        for (Athlete athlete : athletes){
            calculateTime(athlete);
        }
        Collections.sort(athletes,new TimeComparator());

    }

    /**
     * This method  will show the winners of the competition
     */
    public void showResults(){
        calculateResults();
        System.out.println('\n'+"----====The Competition results====----");
        System.out.println("--- Winner --- "+athletes.get(0).getAthleteName()+" "+athletes.get(0).getMinutes()+
                ":"+athletes.get(0).getSeconds());
        System.out.println("-- Runner-up -- "+athletes.get(1).getAthleteName()+" "+athletes.get(1).getMinutes()+
                ":"+athletes.get(1).getSeconds());
        System.out.println("- Third Place - "+athletes.get(2).getAthleteName()+" "+athletes.get(2).getMinutes()+
                ":"+athletes.get(2).getSeconds());
    }

}
