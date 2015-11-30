<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Getting started</title>
</head>
<body>
	<h1>New blog post:</h1>
	<form name="form" action="blog/posts/upload/" method="post" enctype="multipart/form-data">
		<input type="text" name="title" />
		<br />
		<textarea name="content"></textarea>
		<br />
		<br />
		<div class="form-group">
			<label for="uploadfile">
				<b>File</b>
			</label>
			<input type="file" name="uploadfile">
		</div>
		<input type="submit" value="submit" />
	</form>
</body>
</html>