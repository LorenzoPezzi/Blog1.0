<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.generation.blog.model.entities.*"%>
    
    <%
    Blogger user = (Blogger) request.getSession().getAttribute("user");
    %>


<!doctype html>
<html lang="en">
	<%@include  file="head.html" %>
  <body>
     <%@include  file="headerLogged.jsp" %>
      <div class="row w-100 mt-5">      
	    <div class="col-sm-4 ms-auto text-light">
	      	<form name="insertPost" action="Index" method="post">
				 <div class="mb-3">
				    <label for="title" class="form-label">Title:</label>
				    <input type="text" class="form-control" name="title">
			 	</div>
			 	<div class="mb-3">
				    <label for="contentText" class="form-label">Content:</label>
				    <textarea class="form-control" name="contentText" rows="4" cols="50"></textarea>
			 	</div>
				<div class="mb-3">
				    <label for="img" class="form-label">Image url:</label>
				    <input type="text" class="form-control" name="img">		    
			 	</div>
			 	<div class="mb-3">
				    <label for="tag" class="form-label">Tag (comma-separated):</label>
				    <input type="text" class="form-control" name="tag">		    
			 	</div>
			 	<input type="hidden" name="idpost">
			 	<!-- <input type="hidden" name="dop" value="" id="data">
			 	<input type="hidden" name="authorID" value=""> -->
			 	<input type="hidden" name="cmd" value="SAVEPOST">
			  	<input type="submit" class="btn btn-primary" value="POST">
			</form>
		</div>
	              <div class="col-sm-4 m-auto"> 
	              <h2 class="text-center text-light">YOUR POSTS</h2>
						<%for(Post p: user.getPosts()){ %>
							<div class="card text-dark justify-content-center p-2 m-auto mt-4 col-sm-10">
								  <div class="card-body">
								  	<h5 class="card-title">Author: <%= user.getNickname() %></h5>
								    <h5 class="card-title">Title: <%= p.getTitle() %></h5>
								    <p class="card-text"><%= p.getContent() %>.</p>
								    <p class="card-text">Tags: <%= p.getTagsString() %></p>
									<p class="card-text">Date of pubblication: <%= p.getDop() %>.</p>
									<a href="?cmd=DELETEPOST&id=<%= p.getId() %>" class="btn btn-outline-danger">DELETE</a>
								  	<a class="btn btn-outline-warning" onclick="fillForm(<%=p.getId()%>, '<%=p.getTitle()%>', '<%=p.getContent()%>', '<%=p.getImg()%>')">UPDATE</a>
								  </div>
								</div>
						<% } %>
			        </div>
	     
	     
      </div>
    
<%@include  file="footer.html" %>
	<script>
		var today = new Date();
		var dd = String(today.getDate()).padStart(2, '0');
		var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
		var yyyy = today.getFullYear();
		today = dd + '/' + mm + '/' + yyyy;
		document.getElementById("data").value = today;
		
		
		function fillForm(id, title, content, img){
			insertPost.title.value = title
			insertPost.contentText.value = content
			insertPost.img.value = img
			insertPost.idpost.value = id	
		}
		
		
	</script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

  </body>
</html>