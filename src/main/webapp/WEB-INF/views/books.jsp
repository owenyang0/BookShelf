<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf8"%>
<html>
    <head>
        <title>All the books</title>
    </head>
<body>
<table class="table table-hover">
    <tr>
      <th>ISBN</th>
      <th>Name</th>
      <th>Price</th>
      <th>Author</th>
    </tr>
<c:forEach var="book" items="${books}" varStatus="status">
    <tr>
      <td>${book.isbn}</td>
      <td>${book.name}</td>
      <td>${book.price}</td>
      <td>${book.author}</td>
    </tr>
</c:forEach>
    </table>
</body>
</html>