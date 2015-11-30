<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template>
	<div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
            	<c:forEach var="post" items="${blogEntryListBean.blogEntries}">
       
      				<div class="post-preview">
	                    <a href="/s01e07/blog/posts/${post.path}/">
	                        <h2 class="post-title">
	                            ${post.title}
	                        </h2>
	                       
	                    </a>
	                    <p class="post-meta">Posted by <a href="#">${post.author}</a> on September 18, 2014</p>
	                </div>
	                <hr>
    			</c:forEach>
            </div>
        </div>
</t:template>