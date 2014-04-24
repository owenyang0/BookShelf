package yang;

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
        res.getWriter().println("<form action=\"add\" method=\"POST\">\n" +
                "  <label>ISBN\n" +
                "  <input id=\"isbn\" type=\"text\">\n" +
                "  </label>\n" +
                "  <label>Name\n" +
                "  <input id=\"name\" type=\"text\">\n" +
                "  </label>\n" +
                "  <label>Price\n" +
                "  <input id=\"price\" type=\"text\">\n" +
                "  </label>\n" +
                "  <label>Author\n" +
                "  <input id=\"author\" type=\"text\">\n" +
                "  </label>\n" +
                "  <label>\n" +
                "  <input type=\"submit\">" +
                "  </label>\n" +
                "</form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
