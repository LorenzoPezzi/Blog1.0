<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List, com.generation.blog.model.entities.*"%>
    
    <%
    Blogger user = (Blogger) request.getSession().getAttribute("user");    	
    List<Post> posts = (List<Post>) request.getAttribute("posts");
    List<Post> postsRecent = (List<Post>) request.getAttribute("postsRecent");
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
<h1 class="text-left text-light mt-5 ms-5">RECENT POST</h1>
      <div class="row w-100 mt-5">
          <div class="col-sm-5 m-auto">
			<nav>
			  <div class="nav nav-tabs" id="nav-tab" role="tablist">
			    <button class="nav-link active" id="nav-home-tab" data-bs-toggle="tab" data-bs-target="#nav-home" type="button" role="tab" aria-controls="nav-home" aria-selected="true">Home</button>
			    <button class="nav-link" id="nav-recent-tab" data-bs-toggle="tab" data-bs-target="#nav-recent" type="button" role="tab" aria-controls="nav-profile" aria-selected="false">Latest Post (24h)</button>
			  </div>
			</nav>
			<div class="tab-content" id="nav-tabContent">
				<div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
					<%for(Post p : posts) { %>
					<div class="card text-dark p-2 m-auto mt-4 col-sm-10">
					 <img src="<%= p.getImg() %>" class="card-img-top" alt="..." width="100px" height="70px">
					  <div class="card-body">
					  	<h5 class="card-title">Author: <a class="text-decoration-none" href="?cmd=PROFILE&nick=<%= p.getAuthor().getNickname()  %>"> <%= p.getAuthor().getNickname() %></a></h5>
					    <h5 class="card-title">Title: <%= p.getTitle() %></h5>
					    <p class="card-text"><%=p.getContent() %>.</p>
					    <p class="card-text">Tags: <%= p.getTagsString() %></p>
						<p class="card-text">Date of pubblication: <%= p.getDop() %>.</p>
						<p><i class="fas fa-thumbs-up"></i> - <span id="like"><%= p.getNumberLike() %></span></p>
						<a href="?cmd=GETPOST&postid=<%= p.getId() %>">See Comments</a>
						<a href="?cmd=DELETEPOST&postid=<%= p.getId() %>" class="btn btn-danger float-end admin">DELETE POST</a>					
					  </div>
					</div>
					<% } %>	
				</div>
			  
			  <div class="tab-pane fade" id="nav-recent" role="tabpanel" aria-labelledby="nav-recent-tab">
			  	<%for(Post p : postsRecent) { %>
					<div class="card text-dark p-2 m-auto mt-4 col-sm-10">
					 <img src="<%= p.getImg() %>" class="card-img-top" alt="..." width="100px" height="70px">
					  <div class="card-body">
					  	<h5 class="card-title">Author: <a class="text-decoration-none" href="?cmd=PROFILE&nick=<%= p.getAuthor().getNickname()  %>"> <%=p.getAuthor().getNickname()  %></a></h5>
					    <h5 class="card-title">Title: <%= p.getTitle() %></h5>
					    <p class="card-text"><%=p.getContent() %>.</p>
					    <p class="card-text">Tags: <%= p.getTagsString() %></p>
						<p class="card-text">Date of pubblication: <%= p.getDop() %>.</p>
						<p><i class="fas fa-thumbs-up"></i> - <span id="like"><%= p.getNumberLike() %></span></p>
						<a href="?cmd=GETPOST&postid=<%= p.getId() %>">See Comments</a>
						<a href="?cmd=DELETEPOST&postid=<%= p.getId() %>" class="btn btn-danger float-end admin">DELETE POST</a>					
					  </div>
					</div>
					<% } %>	
			  
			  </div>
			</div>
          
          
          
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
=======
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List, com.generation.blog.model.entities.*"%>
    
    <%
    Blogger user = (Blogger) request.getSession().getAttribute("user");
    List<Post> posts = (List<Post>) request.getAttribute("posts");
    List<Post> postsRecent = (List<Post>) request.getAttribute("postsRecent");
    %>


<!doctype html>
<html lang="en">
  <%@include  file="head.html" %>
  <body>
  	<%@include  file="headerLogged.jsp" %>
<h1 class="text-left text-light mt-5 ms-5">RECENT POST</h1>
      <div class="row w-100 mt-5">
          <div class="col-sm-5 m-auto">
			<nav>
			  <div class="nav nav-tabs" id="nav-tab" role="tablist">
			    <button class="nav-link active" id="nav-home-tab" data-bs-toggle="tab" data-bs-target="#nav-home" type="button" role="tab" aria-controls="nav-home" aria-selected="true">Home</button>
			    <button class="nav-link" id="nav-recent-tab" data-bs-toggle="tab" data-bs-target="#nav-recent" type="button" role="tab" aria-controls="nav-profile" aria-selected="false">Latest Post (24h)</button>
			  </div>
			</nav>
			<div class="tab-content" id="nav-tabContent">
				<div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
					<%for(Post p : posts) { %>
					<div class="card text-dark p-2 m-auto mt-4 col-sm-10">
					 <img src="<%= p.getImg() %>" class="card-img-top" alt="..." width="100px" height="70px">
					  <div class="card-body">
					  	<h5 class="card-title">Author: <a class="text-decoration-none" href="?cmd=PROFILE&nick=<%= p.getAuthor().getNickname()  %>"> <%= p.getAuthor().getNickname() %></a></h5>
					    <h5 class="card-title">Title: <%= p.getTitle() %></h5>
					    <p class="card-text"><%=p.getContent() %>.</p>
					    <p class="card-text">Tags: <%= p.getTagsString() %></p>
						<p class="card-text">Date of pubblication: <%= p.getDop() %>.</p>
						<p><i class="fas fa-thumbs-up"></i> - <span id="like"><%= p.getNumberLike() %></span></p>
						<a href="?cmd=GETPOST&postid=<%= p.getId() %>">See Comments</a>					
					  </div>
					</div>
					<% } %>	
				</div>
			  
			  <div class="tab-pane fade" id="nav-recent" role="tabpanel" aria-labelledby="nav-recent-tab">
			  	<%for(Post p : postsRecent) { %>
					<div class="card text-dark p-2 m-auto mt-4 col-sm-10">
					 <img src="<%= p.getImg() %>" class="card-img-top" alt="..." width="100px" height="70px">
					  <div class="card-body">
					  	<h5 class="card-title">Author: <a class="text-decoration-none" href="?cmd=PROFILE&nick=<%= p.getAuthor().getNickname()  %>"> <%=p.getAuthor().getNickname()  %></a></h5>
					    <h5 class="card-title">Title: <%= p.getTitle() %></h5>
					    <p class="card-text"><%=p.getContent() %>.</p>
					    <p class="card-text">Tags: <%= p.getTagsString() %></p>
						<p class="card-text">Date of pubblication: <%= p.getDop() %>.</p>
						<p><i class="fas fa-thumbs-up"></i> - <span id="like"><%= p.getNumberLike() %></span></p>
						<a href="?cmd=GETPOST&postid=<%= p.getId() %>">See Comments</a>					
					  </div>
					</div>
					<% } %>	
			  
			  </div>
			</div>
          
          
          
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
>>>>>>> 05221816458389c629d49feafd7f22ce9b2d909f
</html>