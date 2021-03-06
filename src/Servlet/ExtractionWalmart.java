package Servlet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class ExtractionWalmart {
	private static DecimalFormat df2 = new DecimalFormat(".##");
	private String inputLine;
	public StringBuilder jsonFormat = new StringBuilder();
	String url;
	String name;
	public String content;
	public static int PRETTY_PRINT_INDENT_FACTOR = 4;
	String price;
	String pUrl;
	String element;

	public ExtractionWalmart(String name) {
		int index = name.indexOf("\u00A3");
		this.name = name.substring(0, index - 1);
		if (name.contains("Half Price.")) {
			this.name = name.substring(0, name.length()/2);

			System.out.println(name);
		}
	}

	public void extract() throws Exception {
		String charset = "UTF-8";
		url = "http://api.walmartlabs.com/v1/search?&format=xml&apiKey=9ng2w467x4t3dbe34gzja27d&numItems=1&query="
				+ URLEncoder.encode(name, "UTF-8");
		URL passUrl = new URL(url);
		System.out.println("hahahahahhahahhaha: " + url);
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				passUrl.openStream(), charset));
		while ((inputLine = reader.readLine()) != null) {
			// System.out.println(inputLine);

			DocumentBuilder builder = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
			InputSource src = new InputSource();
			src.setCharacterStream(new StringReader(inputLine));

			Document doc = builder.parse(src);
			System.out.println(inputLine);
			//All the items contains "salePrice" this element;
			if (inputLine.contains("salePrice")) {
				element = doc.getElementsByTagName("salePrice").item(0)
						.getTextContent();
				double sale = Double.parseDouble(element) * 0.69 + 20;
				price = df2.format(sale);
			}else {
				element = "null"; 
			}
			pUrl = doc.getElementsByTagName("productUrl").item(0)
					.getTextContent();
			
			// System.out.println(sale);
			// System.out.println("hahaha" + price);
		}
		reader.close();
	}

	public String getPrice() {
		return price;
	}

	public String getpUrl() {
		return this.pUrl;
	}
}
