<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html> 
<html> 
<head> 
<title> Java File Upload Servlet Example </title> 
</head> 
<body>

  <form method="post" action="Index2" enctype="multipart/form-data">
    <input type="file" name="file" />
    <input type="hidden" name="cmd" value="UPLOADFILE">
    <input type="submit" value="Upload" />
  </form>

</body>
</html>