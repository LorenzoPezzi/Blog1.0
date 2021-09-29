<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List,java.util.HashMap, com.generation.blog.model.entities.*"%>
    
    <%
    Blogger user = (Blogger) request.getSession().getAttribute("user");
	Post p = (Post) request.getAttribute("post");
	%>

<!doctype html>
<html lang="en">
  <%@include  file="head.html" %>
  	<%for(String nameLike : p.getLike())
		if(nameLike.equals(user.getNickname())){
		System.out.println("ok");
		%>
		<script>
			window.onload = function() {
				document.getElementById("likes").style.color = '#00f';
				color = document.getElementById("likes").style.color;
			};
		</script>
	<%}%>
	      <%if(user instanceof Admin){
    		System.out.println("Sono un admin");%>
    		<style> .admin{display:block;} </style>	
    	<% }%>
  <body>
  	<%@include  file="headerLogged.jsp" %>


	<div class="row w-100 mt-5 text-light">
         <div class="col-sm-7 me-auto">
         <h1 class="text-left mt-5 ms-5">POST</h1>
				<div class="card text-dark p-2 m-auto mt-4 col-sm-10">
				 <img src="<%= p.getImg() %>" class="card-img-top" alt="..." width="100px" height="70px">
				  <div class="card-body">
				  	<h5 class="card-title">Author: <a class="text-decoration-none" href="?cmd=PROFILE&nick=<%= p.getAuthor().getNickname()%>"> <%= p.getAuthor().getNickname() %></a></h5>
				    <h5 class="card-title">Title: <%= p.getTitle() %></h5>
				    <p class="card-text"><%=p.getContent() %>.</p>
				    <p class="card-text">Tags: <%= p.getTagsString() %></p>
					<p class="card-text">Date of pubblication: <%= p.getDop() %>.</p>
					<p><a style="cursor: pointer;" onclick="setLike(<%= p.getId() %>, '<%= user.getNickname() %>')"><i id="likes" class="fas fa-thumbs-up link"></i></a> <span id="like"><%= p.getNumberLike() %></span> Like</p>				
				  <a href="?cmd=DELETEPOST&postid=<%= p.getId() %>" class="btn btn-danger float-end admin">DELETE POST</a>
				  </div>
				</div>	
         <!-- </div>

         <div class="col-sm-5 ms-5 text-light m-auto mt-4"> -->
         <div class="m-auto mt-4 col-sm-10">
	         <h2 class="">Insert comment</h2>
	       		<form name="insertPost" action="Index" method="post">
					 <div class="mb-3">
					    <label for="title" class="form-label">Title:</label>
					    <input type="text" class="form-control" name="title">
				 	</div>
				 	<div class="mb-3">
					    <label for="contentText" class="form-label">Content:</label>
					    <textarea class="form-control" name="contentText" rows="4" cols="50"></textarea>
				 	</div>
				 	<input type="hidden" name="postid" value="<%=p.getId()%>">
				 	<input type="hidden" name="cmd" value="SAVECOMMENT">
				  	<input type="submit" class="btn btn-primary" value="POST COMMENT">
				</form>
			</div>
        </div>

         <div class="col-sm-4 mt-5">
         <h3 class="text-light">COMMENTS</h3>
        	<div class="card text-dark p-2 m-auto mt-4 col-sm-10">
				  <div class="card-body">
				  <% if(p.getComments() != null){ %> 
					<%for(Comment c : p.getComments()) { %>
					<div class="card text-dark p-2 m-auto mt-4 col-sm-10">
					  <div class="card-body">
					  	<h5 class="card-title">Author: <a class="text-decoration-none" href="?cmd=PROFILE&nick=<%= c.getAuthor()%>"> <%= c.getAuthor() %></a></h5>
					    <h5 class="card-title">Title: <%= c.getTitle() %></h5>
					    <p class="card-text"><%=c.getContent() %>.</p>
						<p class="card-text">Date of pubblication: <%= c.getDop() %>.</p>
						<p># Like</p>	
						<a href="?cmd=DELETECOMMENT&commentid=<%= c.getId() %>" class="btn btn-danger float-end admin">DELETE POST</a>
					  </div>
					</div>
					<% } %>
					<%}%>	
				  </div>
				</div>
        </div>

	</div>

    
<%@include  file="footer.html" %>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	<script>		
	function setLike(postid, nick){
		color = document.getElementById("likes").style.color = color === '#00f' ? '#000' : '#00f';
		const Http = new XMLHttpRequest();
		const url='http://localhost:8080/Blog/Index?cmd=SETLIKE&postid='+postid+'&nick='+nick;
		Http.open("POST", url);
		Http.send();
	
		Http.onreadystatechange = (e) => {
			if(Http.readyState === XMLHttpRequest.DONE) {
			    var status = Http.status;
			    if (status === 0 || (status >= 200 && status < 400)) {
			    	document.getElementById("like").innerText = Http.responseText;
					console.log("like totali " + Http.responseText)
			    } else {
			      // Errore
			    }
			  }	

		}
	}
		
	</script>
  </body>
</html>