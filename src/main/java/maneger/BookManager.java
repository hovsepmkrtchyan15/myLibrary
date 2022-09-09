package maneger;

import db.DBConnectionProvider;
import model.Book;
import model.Author;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class BookManager {
    private Connection connection = DBConnectionProvider.getInstance().getConnection();
    private AuthorManager authorManager = new AuthorManager();


    public void add(Book book) {
        String sql = "Insert into book(title, description, price, author_id, book_pic) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getDescription());
            ps.setDouble(3, book.getPrice());
            ps.setInt(4, book.getAuthor().getId());
            ps.setString(5, book.getBookPic());
            ps.executeUpdate();
            ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                book.setId(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> getAll() {
        String sql = "Select * from book";
        List<Book> books = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                books.add(getBookFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return books;
    }

    public Book getById(int id) {
        String sql = "Select * from book where id = " + id;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {

                return getBookFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    private Book getBookFromResultSet(ResultSet resultSet) throws SQLException {
        Book book = new Book();
        book.setId(resultSet.getInt(1));
        book.setTitle(resultSet.getString(2));
        book.setDescription(resultSet.getString(3));
        book.setPrice(resultSet.getDouble(4));
        int authorId = resultSet.getInt(5);
        book.setBookPic(resultSet.getString(6));
        Author author = authorManager.getById(authorId);
        book.setAuthor(author);

        return book;
    }

    public void removeBookById(int bookId) {
        String sql = "delete from book where id = " + bookId;

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void edit(Book book) {
        String sql = "update book set title=?, description=?, price=?, author_id=?, book_pic=? WHERE id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getDescription());
            ps.setDouble(3, book.getPrice());
            ps.setInt(4, book.getAuthor().getId());
            ps.setString(5,book.getBookPic());
            ps.setInt(6, book.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

