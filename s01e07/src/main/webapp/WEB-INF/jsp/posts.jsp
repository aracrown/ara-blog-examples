<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Getting started</title>
  </head>
  <body>
    <h1>${message}</h1>
    
    <div>
	<c:forEach var="post" items="${blogEntryListBean.blogEntries}">
      <p><a href="/s01e07/blog/posts/${post.path}/">${post.title}</a></p>
    </c:forEach>
  </div>
  
  <p><a href="/s01e07/new.jsp">New</a></p>
  
  <p><a href="/s01e07/new2.jsp">New with file</a></p>
  </body>
</html>