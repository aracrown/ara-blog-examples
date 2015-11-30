<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Getting started</title>
  </head>
  <body>
    <h1>New blog post:</h1>
    
    <form name="form" action="blog/posts/" method="post" >
    	<input type="text" name="title"/>
    	<br/>
    	<textarea  name="content"></textarea>
    	<br/>
    	<p>
       </p>
    	
    	<input type="submit" value="submit"/>
	</form>
  </body>
</html>