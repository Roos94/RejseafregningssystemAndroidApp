package com.dtu.smmac.rejseafregningssystem.Logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
            return getUrl(API + "info?user=" + brugernavn + "&pass=" + kode);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
