package com.mycompany.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class Task2 {
    private String ipAdress;
    Task2(){
        System.setProperty(" webdriver.chrome.driver", "C:\\Projects\\chrome-win64.zip");
        WebDriver webDriver = new ChromeDriver();
        try {
            webDriver.get("https://api.ipify.org/?format=json");
            var elem = webDriver.findElement(By.tagName("pre"));
            var ipAdress = elem.getText();
            this.ipAdress = ipAdress.split(":")[1].substring(1, 12);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
    String getIpAdress(){
        return ipAdress;
    }
}
