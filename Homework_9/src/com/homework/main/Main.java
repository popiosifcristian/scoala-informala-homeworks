package com.homework.main;

/**This is the main class where we will create the CSVReader and the CompetitionManagement
 * where we will read from file and where we will show the results
 * @author Pop Iosif Cristian
 */
public class Main {
    public static void main(String[] args) {
        CSVReader csvReader = new CSVReader();
        CompetitionManagement am = new CompetitionManagement();
        String csvFile = "E:\\Learning\\Git\\scoala-informala-homeworks\\Homework_9\\src\\com\\homework\\main\\Tabel.csv";

        csvReader.readFile(csvFile);
        am.athletes=csvReader.convertFile();
        am.showResults();

    }
}
