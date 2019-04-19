package com;

import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class MainApp {

    public static void main(String[] args) throws JSONException, IOException, InterruptedException {

        Process process = Runtime.getRuntime().exec("python /home/syrine/PFA2/scriptPython/a.py");

//
//        InputStream stdout = process.getInputStream();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(stdout, StandardCharsets.UTF_8));
//        String line;
//        try{
//            while((line = reader.readLine()) != null){
//                System.out.println("stdout: "+ line);
//            }
//        }catch(IOException e){
//            System.out.println("Exception in reading output"+ e.toString());
//        }

//        System.out.println("Python program");

        SpringApplication.run(MainApp.class, args);

    }
}
