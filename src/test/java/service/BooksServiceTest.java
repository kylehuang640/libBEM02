//package service;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertNull;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import com.example.libBEM02.dto.BooksDto;
//import com.example.libBEM02.entity.Books;
//import com.example.libBEM02.service.BooksService;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//public class BooksServiceTest {
//
//    @Autowired
//    private BooksService booksService;
//
//    @Test
//    public void testFindByBookName() {
//        BooksDto bookDto = booksService.findByBookName("Book1");
//        assertNotNull(bookDto);
//        assertEquals("Book1", bookDto.getBookName());
//    }
//
//    @Test
//    public void testInsertBook() {
//        BooksDto bookDto = new BooksDto();
//        bookDto.setBookName("Book2");
//        bookDto.setAuthor("Author2");
//        bookDto.setDescription("Description2");
//        bookDto.setListPrice(100.0);
//        bookDto.setSellPrice(90.0);
//
//        BooksDto savedBookDto = booksService.insertBook(bookDto);
//        assertNotNull(savedBookDto);
//        assertEquals("Book2", savedBookDto.getBookName());
//    }
//
//    @Test
//    public void testDeleteBook() {
//        BooksDto bookDto = new BooksDto();
//        bookDto.setBookName("Book3");
//        bookDto.setAuthor("Author3");
//        bookDto.setDescription("Description3");
//        bookDto.setListPrice(100.0);
//        bookDto.setSellPrice(90.0);
//
//        BooksDto savedBookDto = booksService.insertBook(bookDto);
//        assertNotNull(savedBookDto);
//        assertEquals("Book3", savedBookDto.getBookName());
//
//        booksService.deleteBook(savedBookDto.getID());
//        BooksDto deletedBookDto = booksService.findByBookName("Book3");
//        assertNull(deletedBookDto);
//    }
//
//    @Test
//    public void testUpdateBook() {
//        BooksDto bookDto = new BooksDto();
//        bookDto.setBookName("Book4");
//        bookDto.setAuthor("Author4");
//        bookDto.setDescription("Description4");
//        bookDto.setListPrice(100.0);
//        bookDto.setSellPrice(90.0);
//
//        BooksDto savedBookDto = booksService.insertBook(bookDto);
//        assertNotNull(savedBookDto);
//        assertEquals("Book4", savedBookDto.getBookName());
//
//        savedBookDto.setBookName("Updated Book4");
//        savedBookDto.setAuthor("Updated Author4");
//        savedBookDto.setDescription("Updated Description4");
//        savedBookDto.setListPrice(110.0);
//        savedBookDto.setSellPrice(100.0);
//
//        booksService.updateBook(savedBookDto.getID(), savedBookDto);
//        BooksDto updatedBookDto = booksService.findByBookName("Updated Book4");
//        assertNotNull(updatedBookDto);
//        assertEquals("Updated Book4", updatedBookDto.getBookName());
//    }
//}