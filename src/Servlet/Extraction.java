package Servlet;

import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

public class Extraction extends PrintURL {
	private String inputLine;
	private String url;
	public static int PRETTY_PRINT_INDENT_FACTOR = 4;
	public String content;
	public StringBuilder jsonFormat = new StringBuilder();
	public Item[] items = new Item[10];

	public Extraction(String url) throws Exception {
		this.url = url;

	}

	public void search() throws Exception {
		String charset = "UTF-8";
		URL passUrl = new URL(url);
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				passUrl.openStream(), charset));
		while ((inputLine = reader.readLine()) != null) {
			inputLine = inputLine.replace("<api_response><deals>", "");
			inputLine = inputLine.replace("</api_response>", "");
			inputLine = inputLine.replace("</deals>", "");
			content = content + inputLine;
		}

		reader.close();
		JSONObject xmlJSONObj = XML.toJSONObject(content);
		String jsonPrettyPrintString = xmlJSONObj
				.toString(PRETTY_PRINT_INDENT_FACTOR);
		jsonFormat.append(jsonPrettyPrintString);

	}

	public void element() throws Exception {
		// System.out.println(jsonFormat);
		JSONObject obj = new JSONObject(jsonFormat.toString());
		JSONArray geodata = obj.getJSONArray("api_item");
		int n = geodata.length();
		for (int i = 0; i < n; ++i) {
			final JSONObject argos = geodata.getJSONObject(i);
			String name = argos.getString("title").replaceAll("&#xa3;",
					"\u00a3");
			name = name.replace("&amp;", "");
			name = name.replace("#xae;", "");
			System.out.println(name);

			ExtractionWalmart wal = new ExtractionWalmart(name);
			wal.extract();
			wal.getPrice();
			Item item = new Item(name, argos.get("price"),
					argos.getDouble("temperature"),
					argos.getString("deal_link"),
					argos.getString("description"),
					argos.getString("deal_image_highres"), wal.getPrice(),
					wal.getpUrl());

			items[i] = item;

		}
	}
}
