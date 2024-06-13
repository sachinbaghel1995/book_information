package com.bookinformation.book.service;


import com.bookinformation.book.pojo.BookResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookService {
    private final RestTemplate restTemplate;

    public BookService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public BookResponse getBookDetails(String isbn) {
        String url = "https://openlibrary.org/api/books?bibkeys=ISBN:" + isbn + "&format=json&jscmd=data";
        try {
            String response = restTemplate.getForObject(url, String.class);
            JSONObject jsonObject = new JSONObject(response).getJSONObject("ISBN:" + isbn);

            String title = jsonObject.optString("title");
            JSONArray authorsJsonArray = jsonObject.optJSONArray("authors");
            String[] authors = new String[authorsJsonArray.length()];
            for (int i = 0; i < authorsJsonArray.length(); i++) {
                authors[i] = authorsJsonArray.getJSONObject(i).optString("name");
            }
            String publishDate = jsonObject.optString("publish_date");

            return BookResponse.builder()
                    .title(title)
                    .authors(authors)
                    .publishDate(publishDate)
                    .isbn(isbn)
                    .build();
        } catch (Exception e) {
            throw new RuntimeException("Error fetching book details", e);
        }
    }
}

