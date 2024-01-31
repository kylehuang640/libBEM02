package com.example.libBEM02.controller;

import org.junit.jupiter.api.Test; 
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.libBEM02.entity.Books;
import com.example.libBEM02.service.BooksService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(BooksController.class)
public class BooksControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BooksService bookService;

    @Test
    void insertBook() throws Exception {
        // 模擬一個Book對象
        Books mockBook = new Books();
        mockBook.setBookName("Fase Book");
        mockBook.setAuthor("Fase Author");
        mockBook.setDescription("Fase Description");
        mockBook.setListPrice(120.00);
        mockBook.setSellPrice(115.00);

        // 模擬當調用createBook時返回模擬的Book對象
        when(bookService.insertBook(any(Books.class))).thenReturn(mockBook);

        // 發送POST請求，模擬創建Book
        mockMvc.perform(MockMvcRequestBuilders.post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"bookName\": \"Test Book\", \"author\": \"Test Author\", \"description\": \"Test Description\", \"listPrice\": 20.0, \"sellPrice\": 15.0 }"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.bookName").value("Test Book"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.author").value("Test Author"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("Test Description"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.listPrice").value(20.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.sellPrice").value(15.0));
    }
}
