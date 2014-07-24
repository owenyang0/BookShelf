package yang;

import com.yang.model.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yang on 4/24/14.
 */
public class AddBook extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req,
                      HttpServletResponse res) throws IOException {
        res.getWriter().println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "\n" +
                "<head>\n" +
                "  <meta charset=\"UTF-8\">\n" +
                "  <title>BookShelf</title>\n" +
                "  <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bookshelf.css\" />\n" +
                "  <script src=\"http://libs.baidu.com/jquery/1.9.0/jquery.js\"></script>\n" +
                "  <script type=\"text/javascript\" src=\"http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.js\"></script>\n" +
                "  <script type=\"text/javascript\" src=\"js/bookshelf.js\"></script>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "  <div class=\"container\">\n" +
                "    <div class=\"header\">\n" +
                "      <h3>BookShelf</h3>\n" +
                "    </div>\n" +
                "    <div class=\"content\">\n" +
                "      <form id=\"book\" action=\"add\" method=\"POST\">\n" +
                "        <div class=\"control-group\">\n" +
                "          <label class=\"control-label\" for=\"isbn\">ISBN</label>\n" +
                "          <div class=\"controls\">\n" +
                "            <input type=\"text\" name=\"isbn\" placeholder=\"ISBN\">\n" +
                "          </div>\n" +
                "        </div>\n" +
                "        <div class=\"control-group\">\n" +
                "          <label class=\"control-label\" for=\"name\">Name</label>\n" +
                "          <div class=\"controls\">\n" +
                "            <input type=\"text\" name=\"name\" placeholder=\"Name\">\n" +
                "          </div>\n" +
                "        </div>\n" +
                "        <div class=\"control-group\">\n" +
                "          <label class=\"control-label\" for=\"price\">Price</label>\n" +
                "          <div class=\"controls\">\n" +
                "            <input type=\"text\" name=\"price\" placeholder=\"Price\">\n" +
                "          </div>\n" +
                "        </div>\n" +
                "        <div class=\"control-group\">\n" +
                "          <label class=\"control-label\" for=\"author\">Author</label>\n" +
                "          <div class=\"controls\">\n" +
                "            <input type=\"text\" name=\"author\" placeholder=\"Author\">\n" +
                "          </div>\n" +
                "        </div>\n" +
                "        <div class=\"control-group\">\n" +
                "          <div class=\"controls\">\n" +
                "            <input class=\"submit\" type=\"submit\">\n" +
                "          </div>\n" +
                "        </div>\n" +
                "      </form>\n" +
                "    </div>\n" +
                "    <div class=\"footer\">\n" +
                "      <p>From Song Yang 2014-4-24</p>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</body>\n" +
                "\n" +
                "</html>\n");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String isbn = req.getParameter("isbn");
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String author = req.getParameter("author");

        Book book = new Book(isbn, name, price, author);

        int count = DBCPManager.insert(book);
        if(count != -1) {
            resp.getWriter().println("Inserted " + count + " items successed!");
        }

        // Basic DataSource
        // JSP EL display books
        // Head first servlet and jsp chap1-4
    }
}
