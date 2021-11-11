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
    private static final String URL_API = "https://viacep.com.br/ws/";
    private static final String json = "/json/";

    public APICEP(String cep) {
        setCep(cep);
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public CEPModel getvalor() {
        String cept = getCep();
        CEPModel cepModel = new CEPModel(cept);
        HttpURLConnection con = null;
        try {
            URL url = new URL(URL_API+getCep()+json);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();

            switch (con.getResponseCode()){
                case 200:
                    JSONObject obj = new JSONObject(IOUtils.toString(url, Charset.forName("UTF-8")));
                    if(obj.length() == 1){
                        cepModel.setError((Boolean) obj.get("erro"));
                        break;
                    }else {
                        cepModel.setUf((String) obj.get("uf"));
                        cepModel.setComplemento((String) obj.get("complemento"));
                        cepModel.setDdd((String) obj.get("ddd"));
                        cepModel.setLogradouro((String) obj.get("logradouro"));
                        cepModel.setBairro((String) obj.get("bairro"));
                        cepModel.setLocalidade((String) obj.get("localidade"));
                        cepModel.setIbge((String) obj.get("ibge"));
                        cepModel.setGia((String) obj.get("gia"));
                        cepModel.setSiafi((String) obj.get("siafi"));
                        break;
                    }
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return cepModel;
    }

}
