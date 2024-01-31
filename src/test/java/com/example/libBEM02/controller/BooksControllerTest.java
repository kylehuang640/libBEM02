package com.example.libBEM02.controller;

import com.example.libBEM02.dto.BooksDto;
import com.example.libBEM02.service.BooksService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BooksController.class)
public class BooksControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private BooksService booksService;

    @Test
    public void testInsertBook() throws Exception {
        // 模擬 service 的行為
        BooksDto mockBooksDto = new BooksDto();
        mockBooksDto.setID(1);
        mockBooksDto.setBookName("Mock Book");
        when(booksService.insertBook(any(BooksDto.class))).thenReturn(mockBooksDto);

        // 模擬一個 POST 請求，驗證返回的 ResponseEntity 是否符合預期
        BooksDto requestDto = new BooksDto();
        requestDto.setBookName("Test Book");
        String jsonRequest = objectMapper.writeValueAsString(requestDto);

        mockMvc.perform(post("/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1)) // 檢查返回的 JSON 中是否包含正確的 ID
                .andExpect(jsonPath("$.bookName").value("Mock Book")); // 檢查返回的 JSON 中是否包含正確的書籍名稱
    }
}
