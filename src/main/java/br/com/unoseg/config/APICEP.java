package br.com.unoseg.config;

import br.com.unoseg.models.CEPModel;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

public class APICEP {
    private String cep;
    private static final String URL_API = "https://viacep.com.br/ws/01311000/json/";

    public APICEP() {
    }

    public APICEP(String cep) {
        this.cep = cep;
    }

    public CEPModel getvalor() {
        HttpURLConnection con = null;
        try {
            URL url = new URL(URL_API);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();

            switch (con.getResponseCode()){
                case 200:

                    JSONObject obj = new JSONObject(IOUtils.toString(url, Charset.forName("UTF-8")));
                    System.out.println("ok\n"+obj);
//                    JSONObject json =(JSONObject) parser.parse(url);
                    break;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        APICEP apicep = new APICEP();

        apicep.getvalor();
    }
}
