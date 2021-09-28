<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List,java.util.HashMap, com.generation.blog.model.entities.*"%>
    
    <%
    Blogger user = (Blogger) request.getSession().getAttribute("user");
    %>

<!doctype html>
<html lang="en">
<%@include  file="head.html" %>
<body>
	<%@include  file="headerLogged.jsp" %>

	<h1 class="text-center text-light mt-4">USER OPTION</h1>
      <div class="row w-100 mt-5">
            <div class="col-sm-5 justify-content-center">
	        	<img class="d-block m-auto" width="300" height="300" src="<%= user.getImg()%>">
	        	<h2 class="display-3 text-light text-center"> <%= user.getNickname() %> </h2>
	        	<p class="sub-title text-light text-center"> <%= user.getBio() %> </p>
	        </div>
      
          <div class="col-sm-5 m-auto text-light">
          <form name="insertPost" action="Index" method="post">
			 	<div class="mb-3">
				    <label for="contentText" class="form-label">Bio:</label>
				    <textarea class="form-control" name="contentText" rows="4" cols="50"><%= user.getBio() %></textarea>
			 	</div>
				<div class="mb-3">
				    <label for="img" class="form-label">Image url:</label>
				    <input type="text" class="form-control" name="img" value="<%= user.getImg() %>" >		    
			 	</div>
			 	<input type="hidden" name="cmd" value="UPDATEPROFILE">
			  	<input type="submit" class="btn btn-primary" value="UPDATE">
			</form>
        </div>
      </div>
    

<%@include  file="footer.html" %>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

  </body>
</html>