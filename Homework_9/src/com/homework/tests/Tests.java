package com.homework.tests;

import com.homework.main.Athlete;
import com.homework.main.CSVReader;
import com.homework.main.CompetitionManagement;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Tests {
    @Test
    public void file_reader(){
        List<String> lines=new ArrayList<>();
        lines.add("11,Umar Jorgson,SK,30,27,xxxox,xxxxx,xxoxo");
        lines.add("1,Jimmy Smiles,UK,29,15,xxoox,xooxo,xxxxo");
        lines.add("27,Piotr Smitzer,CZ,30,10,xxxxx,xxxxx,xxxxx");
        CSVReader csvReader = new CSVReader();
        String csvFile = "C:\\Users\\pop_i\\IdeaProjects\\Homework_9\\src\\com\\homework\\main\\Tabel.csv";
        csvReader.readFile(csvFile);
        Assert.assertEquals(lines,csvReader.getLines());
    }
    @Test
    public void convert_line(){
        String string="11,Umar Jorgson,SK,30,27,xxxox,xxxxx,xxoxo";
        String [] split= string.split(",");
        CSVReader csvReader = new CSVReader();
        Assert.assertEquals(split,csvReader.convertLine(string));
    }
    @Test
    public void calculate_shooting(){
        String string = "xxxxo";
        CompetitionManagement cm = new CompetitionManagement();
        Assert.assertEquals(10,cm.calculateShooting(string));
    }
    @Test
    public void calculate_shooting_all_missed(){
        String string = "ooooo";
        CompetitionManagement cm = new CompetitionManagement();
        Assert.assertEquals(50,cm.calculateShooting(string));
    }
    @Test
    public void calculate_shooting_0_missed(){
        String string = "xxxxx";
        CompetitionManagement cm = new CompetitionManagement();
        Assert.assertEquals(0,cm.calculateShooting(string));
    }
    @Test
    public void calculate_time(){
        Athlete athlete = new Athlete(11,
                "Umar Jorgson","SK",0,
                0,"xxxox","xxxxx","xxxxx");
        CompetitionManagement cm = new CompetitionManagement();
        cm.calculateTime(athlete);
        Assert.assertEquals(10,athlete.getSeconds());
    }
    @Test
    public void calculate_time_all_missed(){
        Athlete athlete = new Athlete(11,
                "Umar Jorgson","SK",0,
                0,"ooooo","ooooo","ooooo");
        CompetitionManagement cm = new CompetitionManagement();
        cm.calculateTime(athlete);
        Assert.assertEquals(30,athlete.getSeconds());
        Assert.assertEquals(2,athlete.getMinutes());
    }
}
