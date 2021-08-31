package com.example.model;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Post {
  @Id
  private Long id;
  String title;
  String description;
  String image;
}
