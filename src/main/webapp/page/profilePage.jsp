<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.generation.blog.model.entities.*"%>
    
    <%
    Blogger user = (Blogger) request.getSession().getAttribute("user");
    Blogger blogger = (Blogger) request.getAttribute("blogger");
    %>


<!doctype html>
<html lang="en">
  <%@include  file="head.html" %>
  <body>
  	<%@include  file="headerLogged.jsp" %>


      <div class="row w-100 mt-5">
        <div class="col-sm-5 justify-content-center">
        	<img class="d-block m-auto" width="300" height="300" src="<%= blogger.getImg()%>">
        	<h2 class="display-3 text-light text-center"> <%= blogger.getNickname() %> </h2>
        	<p class="sub-title text-light text-center"> "<%= blogger.getBio() %>" </p>
        </div>
      
          <div class="col-sm-6 m-auto">
			<%for(Post p: blogger.getPosts()){ %>
				<div class="card text-dark justify-content-center p-2 m-auto mt-4 col-sm-10">
					  <div class="card-body">
					  	<h5 class="card-title">Author: <a class="text-decoration-none" href="?cmd=PROFILE&nick=<%= blogger.getNickname() %>"> <%= blogger.getNickname() %></a></h5>
					    <h5 class="card-title">Title: <%= p.getTitle() %></h5>
					    <p class="card-text"><%= p.getContent() %>.</p>
					    <p class="card-text">Tags: <%= p.getTagsString() %></p>
						<p class="card-text">Date of pubblication: <%= p.getDop() %>.</p>
					  </div>
					</div>
				
				
			<% } %>
        </div>
      </div>
    

<%@include  file="footer.html" %>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

  </body>
</html>