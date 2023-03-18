package com.example.demo.model;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Builder
public class Recipe {
    private int id;
    private String author;
    private String title;
    private String description;
}
