<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Getting started</title>
  </head>
  <body>
    <h1>${blogEntryBean.blogEntry.title}</h1>
    
    <div>
	<p>${blogEntryBean.blogEntry.content}</p>
	
	<c:if test="${blogEntryBean.blogEntry.imagePresent}">
		<img src="/s01e07/blog/posts/image/${blogEntryBean.blogEntry.path}.img" width="100px" height="100px"/>
	</c:if>
  </div>
  </body>
</html>