$(function() {
  $("#book").validate({
    rules: {
      isbn: {
        required: true,
        digits: true,
        maxlength: 13
      },
      name: {
        required: true
      },
      price: {
        required: true,
        number: true
      },
      author: {
        required: true
      }
    },
    messages: {
      isbn: {
        required: "please enter digits",
        digits: "please enter a valid isbn digits"
      },
      name: "please enter a book name",
      price: {
        required: "please enter book price",
        number: "please enter a valid number"
      },
      author: "please enter a book's author name"
    }
  });

  $('.book-delete').on('click', function() {
    var isbn = $($('.book-delete').parents('tr').find('td').get(0)).text();
    $(location).path('/delete/' + isbn);
    console.log($(this));
  });
  $('.book-nav').on('click', 'li', function() {
    $(this).css('active');
  });
});
