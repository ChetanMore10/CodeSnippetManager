package com.CodeSnippetManager.controller;

import com.CodeSnippetManager.entity.CodeSnippet;
import com.CodeSnippetManager.service.CodeSnippetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/snippets")
@RequiredArgsConstructor
public class PageController {

    private final CodeSnippetService codeSnippetService;

    // Show all snippets
    @GetMapping
    public String listSnippets(Model model) {
        model.addAttribute("snippets", codeSnippetService.getAllSnippet());
        return "snippets/list";
    }

    // Show create form
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("snippet", new CodeSnippet());
        return "snippets/form";
    }

    // Save new snippet
    @PostMapping
    public String createSnippet(@ModelAttribute CodeSnippet snippet) {
        codeSnippetService.createSnippet(snippet);
        return "redirect:/snippets";
    }

    // Show one snippet
    @GetMapping("/{id}")
    public String viewSnippet(@PathVariable Long id, Model model) {
        model.addAttribute("snippet", codeSnippetService.getSnippetById(id));
        return "snippets/details";
    }

    // Show edit form
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("snippet", codeSnippetService.getSnippetById(id));
        return "snippets/form";
    }

    // Update snippet
    @PostMapping("/{id}/update")
    public String updateSnippet(
            @PathVariable Long id,
            @ModelAttribute CodeSnippet snippet) {

        codeSnippetService.updateSnippet(id, snippet);
        return "redirect:/snippets";
    }

    // Delete snippet
    @PostMapping("/{id}/delete")
    public String deleteSnippet(@PathVariable Long id) {
        codeSnippetService.deleteSnippet(id);
        return "redirect:/snippets";
    }
}