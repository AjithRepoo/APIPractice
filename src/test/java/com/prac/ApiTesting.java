package com.prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ApiTesting {

	public void get() throws IOException {
		URL u = new URL("https://dummy.restapiexample.com/api/v1/employees");
		HttpURLConnection http = (HttpURLConnection) u.openConnection();
		http.setRequestMethod("GET");
		http.connect();
		int responseCode = http.getResponseCode();
		System.out.println(responseCode);
		String responseMessage = http.getResponseMessage();
		System.out.println(responseMessage);
		InputStream inputStream = http.getInputStream();
		InputStreamReader input = new InputStreamReader(inputStream);
		
		BufferedReader buf = new BufferedReader(input);
		String line;
		StringBuffer strbuf = new StringBuffer();
		while ((line=buf.readLine())!=null) {
			
			strbuf.append(line);
		}
		System.out.println(strbuf);
	}
	public void post() throws IOException {
		URL u = new URL("https://dummy.restapiexample.com/api/v1/create");
		HttpURLConnection http = (HttpURLConnection) u.openConnection();
		http.setRequestMethod("POST");
		http.setRequestProperty("content-Type", "application/json");
		http.setDoOutput(true);
		
		String jsonbody="{\"name\":\"John\"}";
		byte[] bytes = jsonbody.getBytes();
		OutputStream outputStream = http.getOutputStream();
		outputStream.write(bytes);
		int responseCode = http.getResponseCode();
		String responseMessage = http.getResponseMessage();
		System.out.println(responseCode);
		System.out.println(responseMessage);
		InputStream inputStream = http.getInputStream();
		InputStreamReader input = new InputStreamReader(inputStream);
		
		BufferedReader buf = new BufferedReader(input);
		String line;
		StringBuffer strbuf = new StringBuffer();
		while ((line=buf.readLine())!=null) {
			
			strbuf.append(line);
		}
		System.out.println(strbuf);
		
	}
	public static void main(String[] args) throws IOException   {
		ApiTesting s= new ApiTesting();
		s.get();
		s.post();
	}

}
