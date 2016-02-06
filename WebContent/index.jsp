<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="Servlet.Extraction" import="Servlet.Item"
	import="Servlet.PrintURL" import="org.json.JSONArray"
	import="org.json.JSONObject" import="org.json.XML"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="generator"
	content="HTML Tidy for HTML5 (experimental) for Windows https://github.com/w3c/tidy-html5/tree/c63cc39" />
<meta charset="UTF-8" />
<title>Argos Products</title>
<meta name="description" content="A description of your website" />
<meta name="keywords" content="keyword1, keyword2, keyword3" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>

	<%
		String url = "http://api.hotukdeals.com/rest_api/v2/?key=9f3b85fff6375f74f25d0f24dc8f152e&order=hot&merchant=argos&exclude_expired=true&results_per_page=10";
		Extraction ext1 = new Extraction(url);
		ext1.search();
		ext1.element();
	%>
	<div id="wrapper">
		<div id="header">
			<div class="top_banner">
				<h1>Argos's Top 10 Hottest Products</h1>

			</div>
		</div>
		<div id="page_content">
			<div class="navigation" style="padding-left: 10px">
				<ul>
					<li>Hottest products:</li>
					<li><a href="index.jsp">Top 1 - 2</a></li>
					<li><a href="thirdFourth.jsp">Top 3 - 4</a></li>
					<li><a href="FifthSixth.jsp">Top 5 - 6</a></li>
					<li><a href="seventhEighth.jsp">Top 7 - 8</a></li>
					<li><a href="ninthTenth.jsp">Top 9 - 10</a></li>


				</ul>
			</div>

			<div class="left_side_bar">
				<div class="col_1">
					<h1>Merchants</h1>
					<div class="box">
						<ul>
							<li><a href="http://www.hotukdeals.com/">HotUKDeals</a></li>
							<li><a href="http://www.argos.co.uk/">Argos</a></li>

							<li><a href="http://www.amazon.co.uk/">Amazon</a></li>
							<li><a href="http://www.tesco.com/">TESCO</a></li>
							<!-- 							<li><a href="http://www.sainsburys.co.uk/">Sainsburys</a></li> -->
							<li><a href="http://www.walmart.com/">Walmart</a></li>
							<li><a
								href="http://www.sears.com/content/shc/sears/en_gb.html">SEARS</a></li>
						</ul>
					</div>
				</div>
				<div class="col_1">
					<h1>Introduction</h1>
					<div class="box">

						<p>This website is a prototype that showing the top 10 hottest
							products of Argos on HUKD. It also contains the information of
							the products including price, description, and the temperature
							from HUKD. Customers can view more product comments by accessing
							to HUKD website and directly visit to the product detail page on
							Argos.</p>
					</div>
				</div>
			</div>
			<div class="right_section">
				<div class="common_content">
					<h2>Products</h2>
					<h3>Top 1 and 2 hottest Argos products</h3>
					<table border="1" style="width: 100" cellpadding="5">
						<tr>

							<td align="center" valign="center" style="width: 50%"><p
									id="tooltip1">
									<a href="<%out.println(ext1.items[0].urlProduct);%>>"> <img
										border="0" alt="HUKD"
										src="<%out.println(ext1.items[0].urlImage);%>" width="200px"
										height="200"> <span> <%
 	out.println("<strong>Description: </strong><br />"
 			+ ext1.items[0].des + "<br />");
 %>
									</span>
									</a>
								</p> <br /> <%
 	out.println(ext1.items[0].name);
 %> <br /></td>

							<td align="center" valign="center" style="width: 50%"><p
									id="tooltip1">
									<a href="<%out.println(ext1.items[1].urlProduct);%>>"> <img
										border="0" alt="HUKD"
										src="<%out.println(ext1.items[1].urlImage);%>" width="200px"
										height="200"><span> <%
 	out.println("<strong>Description: </strong><br />"
 			+ ext1.items[1].des);
 %>
									</span>
									</a>
								</p> <br /> <%
 	out.println(ext1.items[1].name);
 %> <br /></td>
						<tr align="center" valign="center">
							<td>
								<%
									out.println("\u00A3" + ext1.items[0].price + "<br />");
								%>
							</td>
							<td>
								<%
									out.println("\u00A3" + ext1.items[1].price + "<br />");
								%>

							</td>
						</tr>
						<tr align="center" valign="center">
							<td>
								<%
									out.println(ext1.items[0].temperature + "&#8451;<br />");
								%>
							</td>
							<td>
								<%
									out.println(ext1.items[1].temperature + "&#8451;<br />");
								%>
							</td>
						</tr>

						<tr align="center" valign="center">
							<td>
								<%
									out.println("<a href=" + ext1.items[0].urlDeal
											+ ">View on HUKD.com</a>");
								%>
							</td>
							<td>
								<%
									out.println("<a href=" + ext1.items[1].urlDeal
											+ ">View on HUKD.com</a>");
								%>
							</td>
						</tr>
						<tr align="center" valign="center">
							<td>
								<%
								out.println("<a href=" +ext1.items[0].walPro+ ">\u00A3"
										+ ext1.items[0].differentPrice + "</a> on Walmart!*");
								%>
							</td>
							<td>
								<%
									out.println("<a href=" +ext1.items[1].walPro+ ">\u00A3"
											+ ext1.items[1].differentPrice + "</a> on Walmart!*");
								%>
							</td>
						</tr>
						<tr align="center" valign="center">
							<td>
								<%
									out.println("<a href=" + ext1.items[0].urlProduct
											+ ">Purchase this product from Argos</a>");
								%>
							</td>
							<td>
								<%
									out.println("<a href=" + ext1.items[1].urlProduct
											+ ">Purchase this product from Argos</a>");
								%>
							</td>
						</tr>

					</table>
<p>*including &pound;20 delivery fee. </p>



				</div>
			</div>
			<div class="clear"></div>
			<!--start footer from here-->
			<div id="footer">
				&copy; Copyright 2016. Design by <a
					href="https://www.linkedin.com/in/kinfaiho" target="_blank">Alan
					Ho (University of Manchester)</a> <br />
				<!--DO NOT remove footer link-->

				<!--Template designed by-->

				<a href="http://www.casino.biz"> <img
					src="images/design_img.gif" class="copyright"
					alt="http://www.casino.biz" />
				</a>
			</div>
			<!--/. end footer from here-->
		</div>
	</div>
</body>
</html>
