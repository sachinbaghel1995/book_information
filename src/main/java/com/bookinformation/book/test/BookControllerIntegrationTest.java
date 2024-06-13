package com.bookinformation.book.test;

import com.bookinformation.book.pojo.BookRequest;
import com.bookinformation.book.pojo.BookResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetBook() {
        BookRequest request = new BookRequest();
        request.setIsbn("1234567890");

        ResponseEntity<BookResponse> responseEntity = restTemplate.postForEntity("/book", request, BookResponse.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        BookResponse response = responseEntity.getBody();
        assertThat(response).isNotNull();
        assertThat(response.getTitle()).isEqualTo("Qamer Javed writes");
    }
}
