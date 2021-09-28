<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% String error = (String) request.getAttribute("error");
    if(error==null) error="";
    %>
<!doctype html>
<html lang="en">
	<%@include  file="head.html" %>
  <body>
     <%@include  file="headerUnLogged.html" %>
      <div class="row w-100 mt-5">
          <div class="col-sm-4 m-auto">
            <img src="https://i.imgur.com/dDGZkmH.png" alt="" width="300px" height="260px" class="d-block m-auto">
            
            <h1 class="mt-3 text-center text-light">WELCOME!</h1>
            
            <form action="Index" method="post" name="loginForm">
                <input type="text" name="username" placeholder="Insert username" class="form-control mt-3">
                <input type="password" name="password" placeholder="Insert password" class="form-control mt-2">
                <input type="hidden" name="cryptPass">
                <input type="hidden" name="cmd" value="LOGIN" />
                <input type="submit" disabled name="savebutton" value="LOGIN"  class="btn btn-light mt-2 m-auto w-50" style="display: block;">
                <a href="?cmd=SIGNUPFORM" value="SIGNUPFORM" class="btn btn-light mt-2 m-auto w-50" style="display: block;">SIGNUP</a>
            </form>
        </div>
      </div>
      <div class="text-center"><p class="text-light display-5"><%= error %></p></div>
    <%@include  file="footer.html" %>
    <script src="js/FormLoginController.js"></script>
  </body>
=======
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% String error = (String) request.getAttribute("error");
    if(error==null) error="";
    %>
<!doctype html>
<html lang="en">
	<%@include  file="head.html" %>
  <body>
     <%@include  file="headerUnLogged.html" %>
      <div class="row w-100 mt-5">
          <div class="col-sm-4 m-auto">
            <img src="https://i.imgur.com/dDGZkmH.png" alt="" width="300px" height="260px" class="d-block m-auto">
            
            <h1 class="mt-3 text-center text-light">WELCOME!</h1>
            
            <form action="Index" method="post" name="loginForm">
                <input type="text" name="username" placeholder="Insert username" class="form-control mt-3">
                <input type="password" name="password" placeholder="Insert password" class="form-control mt-2">
                <input type="hidden" name="cryptPass">
                <input type="hidden" name="cmd" value="LOGIN" />
                <input type="submit" disabled name="savebutton" value="LOGIN"  class="btn btn-light mt-2 m-auto w-50" style="display: block;">
                <a href="?cmd=SIGNUPFORM" value="SIGNUPFORM" class="btn btn-light mt-2 m-auto w-50" style="display: block;">SIGNUP</a>
            </form>
        </div>
      </div>
      <div class="text-center"><p class="text-light display-5"><%= error %></p></div>
    <%@include  file="footer.html" %>
    <script src="js/FormLoginController.js"></script>
  </body>
>>>>>>> 05221816458389c629d49feafd7f22ce9b2d909f
</html>