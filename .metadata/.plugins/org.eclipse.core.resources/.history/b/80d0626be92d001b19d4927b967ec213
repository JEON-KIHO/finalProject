package com.example.domain;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class KakaoAPI {
	public static String search(String apiURL) {
        try {
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", "KakaoAK 5ce0232a77c703831f4d0a375cece966");
            int responseCode = con.getResponseCode();
            BufferedReader br;

            // 정상 호출인 경우
            if(responseCode==200) {
                br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            //에러가 발생한 경우
            } else {
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }

            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());
            return response.toString();
        }catch (Exception e) { 
            return e.toString();
        }
    }
}
