package com.CodeSnippetManager.serviceImpl;

import com.CodeSnippetManager.entity.CodeSnippet;
import com.CodeSnippetManager.repository.CodeSnippetRepository;
import com.CodeSnippetManager.service.CodeSnippetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CodeSnippetServiceImpl implements CodeSnippetService {

    private final CodeSnippetRepository codeSnippetRepository;

    // CREATE
    @Override
    public CodeSnippet createSnippet(CodeSnippet snippet) {

        LocalDateTime currentDateTime = LocalDateTime.now();

        snippet.setCreatedDate(currentDateTime);
        snippet.setUpdatedDate(currentDateTime);

        return codeSnippetRepository.save(snippet);
    }

    // GET ALL
    @Override
    public List<CodeSnippet> getAllSnippet() {
        return codeSnippetRepository.findAll();
    }

    // GET BY ID
    @Override
    public CodeSnippet getSnippetById(Long id) {

        return codeSnippetRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Code Snippet not found with id: " + id
                        )
                );
    }

    // UPDATE
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

    // DELETE
    @Override
    public void deleteSnippet(Long id) {

        CodeSnippet existingSnippet = getSnippetById(id);

        codeSnippetRepository.delete(existingSnippet);
    }

    // SEARCH BY TITLE
    @Override
    public List<CodeSnippet> searchByTitle(String title) {

        return codeSnippetRepository
                .findByTitleContainingIgnoreCase(title);
    }

    // SEARCH BY LANGUAGE
    @Override
    public List<CodeSnippet> findByLanguage(String language) {

        return codeSnippetRepository
                .findByLanguageIgnoreCase(language);
    }
}