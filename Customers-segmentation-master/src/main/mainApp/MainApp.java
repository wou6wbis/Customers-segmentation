package mainApp;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class MainApp {


    public static void main(String[] args) throws JSONException {

        SpringApplication.run(MainApp.class, args);

    }
}
