package com.bookinformation.book.test;

import com.bookinformation.book.pojo.BookResponse;
import com.bookinformation.book.service.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BookServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private BookService bookService;

    @Test
    void testGetBookDetails() {
        String isbn = "1234567890";
        String apiResponse = "{\"ISBN:1234567890\": {\"title\": \"Fantastic Mr. Foxs\", \"authors\": [{\"name\": \"Roald Dahl\"}], \"publish_date\": \"1988-10-01\"}}";

        when(restTemplate.getForObject("https://openlibrary.org/api/books?bibkeys=ISBN:" + isbn + "&format=json&jscmd=data", String.class))
                .thenReturn(apiResponse);

        BookResponse response = bookService.getBookDetails(isbn);

        assertThat(response).isNotNull();
        assertThat(response.getTitle().trim()).isEqualTo("Fantastic Mr. Foxs");
        assertThat(response.getAuthors()).containsExactly("Roald Dahl");
        assertThat(response.getPublishDate()).isEqualTo("1988-10-01");
        assertThat(response.getIsbn()).isEqualTo(isbn);
    }
}

