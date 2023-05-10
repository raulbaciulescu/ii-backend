package com.university.iibackend.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "_question")
public class Question {
    @Id
    private Integer id;

    private String text;

    @ElementCollection
    private List<String> options;

    private Integer correctOption;
}