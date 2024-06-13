package com.bookinformation.book.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookResponse {
    private String title;
    private String[] authors;
    private String publishDate;
    private String isbn;
}
