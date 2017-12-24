package com.connector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Get2 {
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
    }
}