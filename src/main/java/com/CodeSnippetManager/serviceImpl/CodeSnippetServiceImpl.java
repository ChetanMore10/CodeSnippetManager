package com.CodeSnippetManager.serviceImpl;

import com.CodeSnippetManager.entity.CodeSnippet;
import com.CodeSnippetManager.repository.CodeSnippetRepository;
import com.CodeSnippetManager.service.CodeSnippetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CodeSnippetServiceImpl implements CodeSnippetService {

    @Autowired
    private CodeSnippetRepository codeSnippetRepository;

    @Override
    public CodeSnippet createSnippet(CodeSnippet snippet) {
        snippet.setCreatedDate(LocalDateTime.now());
        snippet.setUpdatedDate(LocalDateTime.now());

        return codeSnippetRepository.save(snippet);
    }

    @Override
    public List<CodeSnippet> getAllSnippet() {
        return codeSnippetRepository.findAll();
    }

    @Override
    public CodeSnippet getSnippetById(Long id) {
        return codeSnippetRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Code Snippet not found with id: " + id));
    }

    @Override
    public CodeSnippet updateSnippet(Long id, CodeSnippet snippet) {

        CodeSnippet existingSnippet = getSnippetById(id);

        existingSnippet.setTitle(snippet.getTitle());
        existingSnippet.setLanguage(snippet.getLanguage());
        existingSnippet.setCategory(snippet.getCategory());
        existingSnippet.setDifficulty(snippet.getDifficulty());
        existingSnippet.setCode(snippet.getCode());
        existingSnippet.setDescription(snippet.getDescription());
        existingSnippet.setUpdatedDate(LocalDateTime.now());

        return codeSnippetRepository.save(existingSnippet);
    }

    @Override
    public void deleteSnippet(Long id) {
        CodeSnippet deleteSnippet = codeSnippetRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Snippet not found with id: " + id));
        codeSnippetRepository.delete(deleteSnippet);
    }

    @Override
    public List<CodeSnippet> searchByTitle(String title) {
        return codeSnippetRepository.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public List<CodeSnippet> findByLanguage(String language) {
        return codeSnippetRepository.findByLanguageIgnoreCase(language);
    }
}
