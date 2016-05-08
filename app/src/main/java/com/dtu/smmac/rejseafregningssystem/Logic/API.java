package com.dtu.smmac.rejseafregningssystem.Logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Roos on 03/05/16.
 */
public class API {

    private final String API = "http://ec2-52-50-239-39.eu-west-1.compute.amazonaws.com:8080/rejseafregningssystem/webapi/";

    public String getUrl(String url) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
        StringBuilder sb = new StringBuilder();
        String linje = br.readLine();
        while (linje != null) {
            sb.append(linje + "\n");
            linje = br.readLine();
        }
        return sb.toString();
    }

    public String login(String brugernavn, String kode) {
        try {
            return getUrl(API + "info/" + brugernavn + "/" + kode);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String changeTlf(String brugernavn, String kode, String nyTlf) {
        String urlParameters = "telefon/" + brugernavn + "/" + kode + "/" + nyTlf;
        try {
            return PUT(API + urlParameters, urlParameters);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String PUT(String url, String urlParameters) throws IOException {
        String resp = null;

        URL newURL = new URL(url);

        HttpURLConnection conn = (HttpURLConnection) newURL.openConnection();
        conn.setReadTimeout(10000);
        conn.setConnectTimeout(15000);
        conn.setRequestMethod("PUT");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setDoInput(true);
        conn.setDoOutput(true);

        String requestBody = urlParameters.toString();
        byte[] outputBytes = requestBody.getBytes();
        OutputStream os = conn.getOutputStream();
        os.write(outputBytes);

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line = "";
        StringBuilder responseOutput = new StringBuilder();

        while((line = br.readLine()) != null)
        {
            responseOutput.append(line);
        }

        resp = responseOutput.toString();

        os.close();

        return resp;
    }


}
