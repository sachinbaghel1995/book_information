package com.bookinformation.book.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Author {
    private String name;



    public Author(String name) {
        this.name = name;
    }
}