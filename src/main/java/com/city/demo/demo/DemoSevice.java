package com.city.demo.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DemoSevice {

    public String getcitiesConnected(String city1, String city2) throws IOException {

        FileReader fileReader = new FileReader("src/main/java/com/city/demo/demo/city.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuffer stringBuffer = new StringBuffer();
        String line;

        while((line=bufferedReader.readLine()) != null) {
            stringBuffer.append(line);
            String[] arrOfStr = line.split(",", 2);
            if(isConnected(city1.trim(), city2.trim(), arrOfStr[0].trim(), arrOfStr[1].trim())) {
                fileReader.close();
                return "yes";
            }
        }

        fileReader.close();
        return "no";
    }

    private boolean isConnected(String city1, String city2, String arrOfStr1, String arrOfStr2) {
        return ((arrOfStr1.equalsIgnoreCase(city1) && arrOfStr2.equalsIgnoreCase(city2))
                || (arrOfStr2.equalsIgnoreCase(city1) && arrOfStr1.equalsIgnoreCase(city2)));
    }

}
