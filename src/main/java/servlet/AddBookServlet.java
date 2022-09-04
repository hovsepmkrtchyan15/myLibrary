package servlet;

import maneger.AuthorManager;
import maneger.BookManager;
import model.Author;
import model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/book/add")
public class AddBookServlet extends HttpServlet {

    private AuthorManager authorManager = new AuthorManager();

    private BookManager bookManager = new BookManager();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");
        String description = req.getParameter("description");
        double price = Double.parseDouble(req.getParameter("price"));
        int authorId = Integer.parseInt(req.getParameter("authorId"));

        Book books = Book.builder()
                .title(title)
                .description(description)
                .price(price)
                .author(authorManager.getById(authorId))
                .build();
        bookManager.add(books);
        resp.sendRedirect("/books");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Author> authorList = authorManager.getAll();
        req.setAttribute("authors", authorList);
        req.getRequestDispatcher("/WEB-INF/addBook.jsp").forward(req, resp);
    }
}
