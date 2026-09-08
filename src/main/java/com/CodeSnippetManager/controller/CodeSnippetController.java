package com.CodeSnippetManager.controller;

import com.CodeSnippetManager.entity.CodeSnippet;
import com.CodeSnippetManager.service.CodeSnippetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/snippets")
@RequiredArgsConstructor
public class CodeSnippetController {

    @Autowired
    private CodeSnippetService codeSnippetService;

    @PostMapping
    public ResponseEntity<CodeSnippet> createCodeSnippet(@RequestBody CodeSnippet snippet){
        CodeSnippet codeSnippet = codeSnippetService.createSnippet(snippet);
        return new ResponseEntity<>(codeSnippet, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CodeSnippet>> getAllSnippet(){
        List<CodeSnippet> snippets = codeSnippetService.getAllSnippet();
        return new ResponseEntity<>(snippets, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CodeSnippet> getById(@PathVariable Long id){
        CodeSnippet codeSnippet = codeSnippetService.getSnippetById(id);
        return new ResponseEntity<>(codeSnippet, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CodeSnippet> updateCodeSnippet(@PathVariable Long id, @RequestBody CodeSnippet snippet){
        CodeSnippet codeSnippet = codeSnippetService.updateSnippet(id, snippet);
        return new ResponseEntity<>(codeSnippet, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSnippet(@PathVariable Long id){
        codeSnippetService.deleteSnippet(id);
        return new ResponseEntity<>("Code Snippet deleted Successfully...!", HttpStatus.OK);
    }
}