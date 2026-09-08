package com.CodeSnippetManager.service;

import com.CodeSnippetManager.entity.CodeSnippet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CodeSnippetService {

    CodeSnippet createSnippet(CodeSnippet snippet);
    List<CodeSnippet> getAllSnippet();
    CodeSnippet getSnippetById(Long id);
    CodeSnippet updateSnippet(Long id, CodeSnippet snippet);
    void deleteSnippet(Long id);
    List<CodeSnippet> searchByTitle(String title);
    List<CodeSnippet> findByLanguage(String language);
}
