<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List,java.util.HashMap, com.generation.blog.model.entities.*"%>
    
    <%
    Blogger user = (Blogger) request.getSession().getAttribute("user");
    List<Post> posts = (List<Post>) request.getAttribute("posts");
    %>


<!doctype html>
<html lang="en">
<%@include  file="head.html" %>
      <%if(user instanceof Admin){
    		System.out.println("Sono un admin");%>
    		<style> .admin{display:block;} </style>	
    	<% }%>
  <body>
  	<%@include  file="headerLogged.jsp" %>

	<h1 class="text-left text-light mt-5 ms-5">TAG POST</h1>
      <div class="row w-100 mt-5 h-50">
          <div class="col-sm-5 m-auto">
          <% if(posts.size() == 0){ %>
          		<h2 class="text-light">No Post Found.</h2>
          <%} %>
          	
         	 <%for(Post p : posts) { %>
					<div class="card text-dark p-2 m-auto mt-4 col-sm-10">
					 <img src="<%= p.getImg() %>" class="card-img-top" alt="..." width="100px" height="70px">
					  <div class="card-body">
					  	<h5 class="card-title">Author: <a class="text-decoration-none" href="?cmd=PROFILE&nick=<%= p.getAuthor().getNickname() %>"> <%= p.getAuthor().getNickname() %></a></h5>
					    <h5 class="card-title">Title: <%= p.getTitle() %></h5>
					    <p class="card-text"><%=p.getContent() %>.</p>
					    <p class="card-text lead">Tags: <%= p.getTagsString() %></p>
						<p class="card-text lead">Date of pubblication: <%= p.getDop() %>.</p>
						<p># Like</p>
						<a href="?cmd=GETPOST&postid=<%= p.getId() %>">See Comments</a>
						<a href="?cmd=DELETEPOST&postid=<%= p.getId() %>" class="btn btn-danger float-end admin">DELETE POST</a>					
					  </div>
					</div>
			<% } %>		
        </div>
        
        <div class="col-sm-3">
        	<div class="card text-dark p-2 m-auto mt-4 col-sm-10">
				  <div class="card-body">
				  <h3>Tag:</h3>
					<ul>
						<li><a href="?cmd=SEARCHTAG&tag=food">Food</a></li>
						<li><a href="?cmd=SEARCHTAG&tag=car">Car</a></li>
						<li><a href="?cmd=SEARCHTAG&tag=technology">Technology</a></li>
						<li><a href="?cmd=SEARCHTAG&tag=java">Java</a></li>
					</ul>
				  </div>
				</div>
        </div>
      </div>
    

<%@include  file="footer.html" %>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

  </body>
</html>