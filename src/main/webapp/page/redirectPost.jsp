<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.generation.blog.model.entities.*"%>
    
    <% Post p = (Post) request.getAttribute("post");
    System.out.println("post in redirect: "+ p + " id: " +p.getId());
    %>
<!DOCTYPE html>
<html>
<head>
<script>
	window.location.replace("Index?cmd=GETPOST&postid="+ <%=p.getId()%>);
</script>
</head>
<body>
</body>
</html>