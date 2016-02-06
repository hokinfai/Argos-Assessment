package Servlet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Item {
	public String name;
	public Object price;
	public double temperature;
	public String urlDeal;
	public String des;
	public String urlImage;
	public String urlProduct;
	public String differentPrice;
	public String walPro;

	public Item(String name, Object price, double temperature, String urlDeal,
			String des, String urlImage, String differentPrice, String walPro) {
		this.name = name;
		this.price = price;
		this.des = des;
		this.temperature = temperature;
		this.urlDeal = urlDeal;
		this.urlImage = urlImage;
		if (name.toLowerCase().contains("argos")) {
			urlProduct = "http://www.hotukdeals.com/visit?m=5&q="
					+ urlImage.substring(urlImage.indexOf("res") + 4,
							urlImage.indexOf(".jpg"));
			// System.out.println("Argos url: " + urlProduct);
			this.differentPrice = differentPrice;
			this.walPro = walPro;

		}

	}

}
