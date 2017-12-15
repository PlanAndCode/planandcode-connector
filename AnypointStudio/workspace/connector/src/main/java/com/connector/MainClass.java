package com.connector;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainClass {
    private final String USER_AGENT = "Mozilla/5.0";
    public String asd() {
        String line = "";
        String result = "";
        try {
	        Runtime r = Runtime.getRuntime();
	        Process p;
	        BufferedReader is;
	
	        p = r.exec("python3 /home/fkiraz/planCodeAPI.py");
	        is = new BufferedReader(new InputStreamReader(p.getInputStream()));

			System.out.println("RUNNING");
			while ((line = is.readLine()) != null) {
				System.out.println("RES " + result);
				  result += line;
			}

			System.out.println("WAITING");
	        try {
	          p.waitFor();
	        } catch (InterruptedException e) {
	          System.err.println(e);
	          return "";
	        }
			System.out.println("END");
		} catch (IOException e1) {
			e1.printStackTrace();
		}

        return result;
    	//return "{\"id\":5,\"countryName\":\"USA\",\"population\":8000}";
    }
 /*
    public static void main(String[] args) throws Exception {
    	MainClass http = new MainClass();
 
        http.sendingGetRequest();
        http.sendingPostRequest();
    }
    
    private void sendingGetRequest() throws Exception {
        String urlString = "http://localhost:8081/test";
  
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        // By default it is GET request
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("Sending get request : "+ url);
        System.out.println("Response code : "+ responseCode);

        // Reading response from input Stream
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String output;
        StringBuffer response = new StringBuffer();

        while ((output = in.readLine()) != null) {
            response.append(output);
        }
        
        in.close();

        //printing result from response
        System.out.println(response.toString());
 
    }
 
    // HTTP Post request
    private void sendingPostRequest() throws Exception {
        String url = "http://localhost:8081/test";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // Setting basic post request
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        con.setRequestProperty("Content-Type","application/json");

        String postJsonData = "";//"{"id":5,"countryName":"USA","population":8000}";

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(postJsonData);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("nSending 'POST' request to URL : " + url);
        System.out.println("Post Data : " + postJsonData);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String output;
        StringBuffer response = new StringBuffer();

        while ((output = in.readLine()) != null) {
            response.append(output);
        }
        in.close();

        //printing result from response
        System.out.println(response.toString());
    }*/
}