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


    public static String getString (InputStream in) throws IOException
    {
        Reader reader = new InputStreamReader(in, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(reader);

        StringBuilder sb = new StringBuilder();
        String line = null;

        while (true) {
            try {
                if (!((line = br.readLine()) != null)) break;
            } catch (java.lang.Exception exception) {
                exception.printStackTrace();
            }
            sb.append(line);
            sb.append('\n');
        }
        try {
            br.close();
        } catch (java.lang.Exception exception) {
            exception.printStackTrace();
        }

        return sb.toString();
    }


    public static void main(String[] args) throws JSONException {

        //SpringApplication.run(MainApp.class, args);
        //


        String message;
        JSONObject json = new JSONObject();
        json.put("ai", "26");
        json.put("sc","60");

        message = json.toString();

        String query_url = "http://localhost:9000/api";

        try {
            URL url = new URL(query_url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            OutputStream os = conn.getOutputStream();
            os.write(message.getBytes("UTF-8"));
            os.close();
            // read the response
            InputStream in = new BufferedInputStream(conn.getInputStream());

            //result in JSON

            String result = getString(in);
            System.out.println(result);

            
            JSONObject myResponse = new JSONObject(result);
            
            //REZ IS MY RESULT!
            String rez = myResponse.getString("results");
            System.out.println("result: "+ rez);
            in.close();
            conn.disconnect();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
