package com.mycompany.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task3 {
   private String [] temperature;
   private String [] rain;
   private String [] time;
    Task3(){
        System.setProperty(" webdriver.chrome.driver", "C:\\Projects\\chrome-win64.zip");
        WebDriver webDriver = new ChromeDriver();
        try {
            webDriver.get("https://api.open-meteo.com/v1/forecast?latitude=56&longitude=44&hourly=temperature_2m,rain&current=cloud_cover&timezone=Europe%2FMoscow&forecast_days=1&wind_speed_unit=ms");
            var elem = webDriver.findElement(By.tagName("pre"));
            JSONParser parser = new JSONParser();
            var obj = (JSONObject) parser.parse(elem.getText());
            var horlyData = (JSONObject) obj.get("hourly");
            this.temperature = horlyData.get("temperature_2m").toString().split(",");
            this.time = horlyData.get("time").toString().split(",");
            this.rain  = horlyData.get("rain").toString().split(",");
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
    void writeDataToFile(){
        try {
            var writer = new FileWriter("..\\result\\forecast.txt");
            for (int i = 0; i < time.length; ++i){
                String result = new String(String.valueOf(i) + " ");
                if (i == 0){
                    result += time[i].substring(1) + " " + temperature[i].substring(1) + " " + rain[i].substring(1) + '\n';
                }
                else if (i < time.length - 2){
                    result += time[i] + " " + temperature[i] + " " + rain[i] + '\n';
                }else{
                    result += time[i].split("]")[0] + " " + temperature[i].split("]")[0] + " " + rain[i].split("]")[0] + '\n';
                }
                System.out.print(result);
                writer.write(result);
                writer.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
