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
        res.getWriter().println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "  <meta charset=\"UTF-8\">\n" +
                "  <title>BookShelf</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "  <form action=\"add\" method=\"POST\">\n" +
                "  <label>ISBN\n" +
                "  <input name=\"isbn\" type=\"text\">\n" +
                "  </label>\n" +
                "  <label>Name\n" +
                "  <input name=\"name\" type=\"text\">\n" +
                "  </label>\n" +
                "  <label>Price\n" +
                "  <input name=\"price\" type=\"text\">\n" +
                "  </label>\n" +
                "  <label>Author\n" +
                "  <input name=\"author\" type=\"text\">\n" +
                "  </label>\n" +
                "  <label>\n" +
                "  <input type=\"submit\">\n" +
                "  </label>\n" +
                "</form>\n" +
                "  </form>\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(req.getParameter("name"));
        int isbn = Integer.parseInt(req.getParameter("isbn"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String author = req.getParameter("author");
        Conn.insert(isbn, name, price, author);
    }
}
