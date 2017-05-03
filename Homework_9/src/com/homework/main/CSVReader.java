package com.homework.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the CSV Reader class
 * In this class we have the methods what hill help us to read athletes from a csv file
 *
 * @author Pop Iosif Cristian
 */
public class CSVReader {
    List<String> lines=new ArrayList<>();

    public List<String> getLines() {
        return lines;
    }

    /**
     * This method will read the csv file and will fill our lines list with the lines
     * of the csv file
     * @param csvFile the location of the csv file
     */
    public void readFile(String csvFile) {

        BufferedReader br = null;
        String line = null;

        try {
            br = new BufferedReader(new FileReader(csvFile));
            line = br.readLine();
            while (line != null) {
                lines.add(line);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * This method will convert a string(a line from the csv file) using ","
     * separator to an array of strings
     * @param line a string(a line from the csv file)
     * @return an array of strings filled by elements from a line of the csv file
     */
    public String[] convertLine(String line) {
        String[] variables = line.split(",");
        return variables;
    }

    /**
     * This method will convert the csv file to a list of athletes
     * This method will add in a list athletes with parameters from a line of the csv file
     * lines is an array of strings filled by lines of the csv file
     * @return a list of athletes
     */
    public List<Athlete> convertFile() {
        List<Athlete> athletes = new ArrayList<Athlete>();
        String[] variables = null;

        for (String line : lines) {

            variables = convertLine(line);

            athletes.add(new Athlete(Integer.parseInt(variables[0]), variables[1], variables[2],
                    Integer.parseInt(variables[3]), Integer.parseInt(variables[4]),
                    variables[5], variables[6], variables[7]));
        }
        return athletes;
    }
}
