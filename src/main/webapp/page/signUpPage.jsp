<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.generation.blog.model.entities.*"%>
    
    <%
    Blogger blogger = (Blogger) request.getAttribute("blogger");
	String errormsg = (String) request.getAttribute("errorForm");

	if(blogger==null)
		blogger = Blogger.DUMMY;
    		
    %>
    
<!doctype html>
<html lang="en">
  <%@include  file="head.html" %>
  <body>
  	<%@include  file="headerUnLogged.html" %>
      <div class="row w-100 mt-5">
          <div class="col-sm-4 m-auto">
            <img src="https://i.imgur.com/dDGZkmH.png" alt="" width="300px" height="260px" class="d-block m-auto">
            
            <h1 class="mt-3 text-center text-light">WELCOME, SIGN-UP!</h1>
            
            <form action="Index" method="post" name="signupForm">
                <input type="text" name="username" placeholder="Insert username" class="form-control mt-3" value="<%= blogger.getNickname()%>">
                <input type="text" name="email" placeholder="Insert email" class="form-control mt-3"  value="<%= blogger.getEmail()%>">
                <input type="password" name="password" placeholder="Insert password" class="form-control mt-3">
                <input type="password" name="password2" placeholder="Insert password" class="form-control mt-3">
                <input type="hidden" name="cryptPass">
                <textarea class="form-control mt-3" name="contentText" rows="4" cols="50" placeholder="Insert Bio"><%= blogger.getBio()%></textarea>
                <input type="text" name="dob" placeholder="Insert Dob" class="form-control mt-3" value="<%= blogger.getDob().toString()%>">
                <input type="text" name="img" placeholder="Insert Img URL" class="form-control mt-3">
                <input type="hidden" name="cmd" value="SIGNUP" />
                <input disabled type="submit" name="savebutton" value="SIGNUP" class="btn btn-light mt-2 m-auto w-50" style="display: block;">
            </form>
            <div style="color:red">
						<%=errormsg!=null ? errormsg : "" %>
			</div>
        </div>
      </div>
    
<%@include  file="footer.html" %>

<script>

	searchBox = document.getElementById("searchBox");
	var obj;
	function searchRequest(){
		if(document.getElementById("search").value.length > 3){
			searchBox.innerHTML= '';
			const Http = new XMLHttpRequest();
			const url='http://localhost:8080/Blog/Index?cmd=GET&word='+ document.getElementById("search").value;
			Http.open("GET", url);
			Http.send();
	
			Http.onreadystatechange = (e) => {
				if(Http.readyState === XMLHttpRequest.DONE) {
				    var status = Http.status;
				    if (status === 0 || (status >= 200 && status < 400)) {
				    	obj = JSON.parse(Http.responseText)
						searchBox.style.display = "block";
						console.log(obj.length)
						for(var i=0; i<obj.length; i++){
							console.log(i)
							searchBox.innerHTML += '<a class="text-decoration-none" href="?cmd=PROFILE&nick='+ obj[i]["nickname"] +'"><div class="item p-3">'+ obj[i]["nickname"] +'</div></a>'
						}
						console.log(Http.responseText)
				    } else {
				      // Errore
				    }
				  }	

			}
		}else{
			searchBox.style.display = "none";
			searchBox.innerHTML= '';
		}
	}
	
	function hideBox(){
		searchBox.style.display = "none";
		searchBox.innerHTML= '';
	}
	
</script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	<script src="js/FormSignupController.js"></script>
  </body>
</html>