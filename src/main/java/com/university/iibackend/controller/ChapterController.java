package com.university.iibackend.controller;

import com.university.iibackend.model.Chapter;
import com.university.iibackend.model.dto.ChapterListingItem;
import com.university.iibackend.service.ChapterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chapter")
@RequiredArgsConstructor
@CrossOrigin
public class ChapterController {
    private final ChapterService service;

    @GetMapping
    public ResponseEntity<List<ChapterListingItem>> getChapters() {
        return ResponseEntity.ok(service.findListingChapters());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chapter> getEmployeesById(@PathVariable Integer id) {
        Optional<Chapter> chapter = service.findChapterById(id);
        return chapter
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
