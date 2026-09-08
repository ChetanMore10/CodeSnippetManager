package com.CodeSnippetManager.repository;

import com.CodeSnippetManager.entity.CodeSnippet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CodeSnippetRepository extends JpaRepository<CodeSnippet, Long> {

    List<CodeSnippet> findByTitleContainingIgnoreCase(String title);

    List<CodeSnippet> findByLanguageIgnoreCase(String language);
}
