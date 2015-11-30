<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:template>
	<div class="row">
		<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
			<c:if test="${blogEntryBean.blogEntry.imagePresent}">
				<a href="#">
					<img src="/s01e07/blog/posts/image/${blogEntryBean.blogEntry.path}.img" class="img-responsive" />
				</a>
			</c:if>
			<p>${blogEntryBean.blogEntry.content}</p>
		</div>
	</div>
</t:template>