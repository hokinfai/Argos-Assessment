package Servlet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DecimalFormat;

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

	public ExtractionWalmart(String name) {
		this.name = name;

	}

	public void extract() throws Exception {
		String charset = "UTF-8";
		url = "http://api.walmartlabs.com/v1/search?&format=xml&apiKey=9ng2w467x4t3dbe34gzja27d&numItems=1&query="
				+ URLEncoder.encode(name, "UTF-8");
		URL passUrl = new URL(url);
		// System.out.println("hahahahahhahahhaha: " + url);
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				passUrl.openStream(), charset));
		while ((inputLine = reader.readLine()) != null) {
			// System.out.println(inputLine);

			DocumentBuilder builder = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
			InputSource src = new InputSource();
			src.setCharacterStream(new StringReader(inputLine));

			Document doc = builder.parse(src);
			String element = doc.getElementsByTagName("salePrice").item(0)
					.getTextContent();
			pUrl = doc.getElementsByTagName("productUrl").item(0)
					.getTextContent();
			double sale = Double.parseDouble(element) * 0.69 + 20;
			price = df2.format(sale);
			System.out.println(sale);
			System.out.println("hahaha" + price);
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
