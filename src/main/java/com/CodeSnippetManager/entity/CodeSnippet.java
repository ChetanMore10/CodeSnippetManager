package com.CodeSnippetManager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "code-snippet")
public class CodeSnippet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String language;
    private String category;

    @Column(columnDefinition = "TEXT")
    private String code;
    private String difficulty;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
