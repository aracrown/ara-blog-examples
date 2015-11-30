<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:template>
	<form name="form" action="blog/posts/" method="post">
		<div class="row control-group">
			<div class="form-group col-xs-12 floating-label-form-group controls">
				<label>Title</label>
				<input type="text" class="form-control" placeholder="Title" id="title" name="title" required data-validation-required-message="Please enter blog entry title.">
				<p class="help-block text-danger"></p>
			</div>
		</div>
		<div class="row control-group">
			<div class="form-group col-xs-12 floating-label-form-group controls">
				<label>Content</label>
				<textarea rows="5" class="form-control" placeholder="Content" id="content" name="content" required data-validation-required-message="Please enter a content."></textarea>
				<p class="help-block text-danger"></p>
			</div>
		</div>
		<br>
		<div id="success"></div>
		<div class="row">
			<div class="form-group col-xs-12">
				<button type="submit" class="btn btn-default">Post</button>
			</div>
		</div>
		
	</form>
</t:template>