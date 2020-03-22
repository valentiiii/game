<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.ContactBean,java.util.List" %>
<%  List<ContactBean> beanlist = (List<ContactBean>)request.getAttribute("beanlist");%>

<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta name="description" cpntent="ゲーム通販です">
    <meta charset="utf-8">
    <title>ゲーム通販まとめ</title>
    <link rel="stylesheet" href="../css/manager.css">
    <script src="js/contact.js"></script>
  </head>

  <body>
    <div class="header">
      <div class="title">
        <h1><a href="home.html">ゲーム通販サイト</a></h1>
        <p>日本国内のゲーム関係の販売サイトをまとめました。</p>
        <p>問い合わせ内容</p>
      </div>
    </div>
<!--------------------------------------------------------------------------------------header　ここまで  -->
	<div class="main">
		<table class="m_table" border="1" align="center">
			<tr>
		 		<th class="date">日時</th>
			 	<th class="no">No.</th>
			 	<th class="name">名前</th>
			 	<th class="adress">アドレス</th>
			 	<th class="content">問い合わせ内容</th>
			</tr>
			<%for(ContactBean listbean : beanlist ){ %>
			<tr>
				<td>2020/03/22</td>
				<td>No.111</td>
				<td><%=listbean.getName() %></td>
				<td><%=listbean.getAddress() %></td>
				<td><%=listbean.getContent() %></td>
			</tr>
			<%} %>


		</table>
	</div>
<!--------------------------------------------------------------------------------------main　ここまで  -->


	<div class="footer">
	  <div class="footer-title">
	    <h1>ゲーム通販サイト</h1>
	  </div>
	      <p>Copyright © 2014-2019 Connetcnat Inc. All Rights Reserved.</p>
	    </div>
	  </body>
	</html>