package servlet;

import maneger.AuthorManager;
import maneger.BookManager;
import model.Author;
import model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/book/add")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 100)
public class AddBookServlet extends HttpServlet {

    private AuthorManager authorManager = new AuthorManager();

    private BookManager bookManager = new BookManager();

    private static final String IMAGE_PATH = "C:\\Users\\Hoso\\Desktop\\Java project\\EventRegisterImages\\";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");
        String description = req.getParameter("description");
        double price = Double.parseDouble(req.getParameter("price"));
        int authorId = Integer.parseInt(req.getParameter("authorId"));
        Part bookPicPart = req.getPart("bookPic");

        String filePath = null;
        if (bookPicPart.getSize() != 0) {
            long fileName = System.nanoTime();
            filePath = fileName + "_" +bookPicPart.getSubmittedFileName();
            bookPicPart.write(IMAGE_PATH + filePath);
        }

        Book books = Book.builder()
                .title(title)
                .description(description)
                .price(price)
                .author(authorManager.getById(authorId))
                .bookPic(filePath)
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
