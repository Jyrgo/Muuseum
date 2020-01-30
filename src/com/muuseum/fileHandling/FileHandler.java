package com.muuseum.fileHandling;

import com.muuseum.model.Direction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileHandler {

    private String filePath;

    public FileHandler(String filePath) {
        this.filePath = filePath;
    }


    public List<LocalTime> getSortedTime(Direction direction) {
        BufferedReader objReader = null;
        List<LocalTime> times = new ArrayList<>();

        try {
            String currentLine;
            objReader = new BufferedReader(new FileReader(this.filePath));

            if(Direction.ARRIVE.equals(direction)) {
                while((currentLine = objReader.readLine()) != null) {
                    String[] tempArray = currentLine.split(",");
                    times.add(LocalTime.parse(tempArray[0]));
                }
            } else if (Direction.LEAVE.equals(direction)) {
                while((currentLine = objReader.readLine()) != null) {
                    String[] tempArray = currentLine.split(",");
                    times.add(LocalTime.parse(tempArray[1]));
                }
            }
            Collections.sort(times);

            return times;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objReader != null) {
                    objReader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

}
