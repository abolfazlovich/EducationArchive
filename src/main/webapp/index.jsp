<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<form method="post" action="containerServlet">
    <lable>Title:</lable>
    <input name="title" placeholder="title" required><br>
    <label>Description: </label>
    <input name="description" placeholder="description" required><br>
    <label>File Path: </label>
    <input name = filePath placeholder="file path" required><br>
    <label>File Size: </label>
    <input name = "fileSize" placeholder="file size" type="number" required><br>
    <label>Price: </label>
    <input name = "price" placeholder="price" required><br>
    <lable>Uploader: </lable>
    <input name="uploader" placeholder="uploader" type="text" required><br>
    <button type="submit">Submit</button>
</form>
</body>
</html>