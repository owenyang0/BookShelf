<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>BookShelf</title>
  <link rel="stylesheet" type="text/css" href="/BookShelf/dest/css/bookshelf.css" />
  <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
  <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.js"></script>
  <script type="text/javascript" src="/BookShelf/dest/js/bookshelf.min.js"></script>
</head>
<body>
  <div class="book-container">
    <div class="header">
      <h3>BookShelf</h3>
    </div>
    <div class="content">
      <form id="book" action="add" method="POST">
        <div class="control-group">
          <label class="control-label" for="isbn">ISBN</label>
          <div class="controls">
            <input type="text" name="isbn" placeholder="ISBN">
          </div>
        </div>
        <div class="control-group">
          <label class="control-label" for="name">Name</label>
          <div class="controls">
            <input type="text" name="name" placeholder="Name">
          </div>
        </div>
        <div class="control-group">
          <label class="control-label" for="price">Price</label>
          <div class="controls">
            <input type="text" name="price" placeholder="Price">
          </div>
        </div>
        <div class="control-group">
          <label class="control-label" for="author">Author</label>
          <div class="controls">
            <input type="text" name="author" placeholder="Author">
          </div>
        </div>
        <div class="control-group">
          <div class="controls">
            <input class="submit" type="submit">
          </div>
        </div>
      </form>
    </div>
    <div class="footer">
      <p>From Song Yang 2014-4-24</p>
    </div>
  </div>
</body>
</html>
