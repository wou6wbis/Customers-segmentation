package mainApp.services;

import mainApp.entities.Client;
import mainApp.repositories.ClientRepo;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ClientService {

    @Autowired
    private ClientRepo clientRepo;


    public List<Client> getAllClients(String managerId) {

        List<Client> clients = new ArrayList<>();
        clientRepo.findByManagerId(managerId).
                forEach(clients::add);
        return clients;
    }

    public Optional<Client> getClient(String id) {

        return clientRepo.findById(id);
    }

    public void addClient(Client client) {

        clientRepo.save(client);
    }


    public void updateClient(Client client) {

        clientRepo.save(client);
    }


    public void deleteClient(String id) {

        clientRepo.deleteById(id);
    }



    public String getString(InputStream in) throws IOException {
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


    public void clusterClient(String id) throws JSONException {

        Optional<Client> client = (Optional<Client>) clientRepo.findById(id);
        Client client1 = client.get();

        double ai=client1.getIncome();
        double sc=client1.getScore();

        String message;
        JSONObject json = new JSONObject();
        json.put("ai", ai);
        json.put("sc", sc);

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
            os.write(message.getBytes(StandardCharsets.UTF_8));
            os.close();
            // read the response
            InputStream in = new BufferedInputStream(conn.getInputStream());

            //result in JSON

            String result = getString(in);
            System.out.println(result);


            JSONObject myResponse = new JSONObject(result);

            //REZ IS MY RESULT!
            String rez = myResponse.getString("results");
            System.out.println("result: " + rez);
            in.close();
            conn.disconnect();

            client1.setCluster(rez);

            clientRepo.save(client1);


        } catch (Exception e) {
            System.out.println(e);
        }

    }

}