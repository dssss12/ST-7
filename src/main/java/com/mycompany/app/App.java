package com.mycompany.app;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) {
        Task2 task2 = new Task2();
        System.out.println(task2.getIpAdress());
        Task3 task3 = new Task3();
        task3.writeDataToFile();
    }
}
