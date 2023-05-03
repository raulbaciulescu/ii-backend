package com.university.iibackend.controller;

import com.university.iibackend.model.Chapter;
import com.university.iibackend.model.dto.ChapterListingItem;
import com.university.iibackend.repository.ChapterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chapter")
@RequiredArgsConstructor
@CrossOrigin
public class ChapterController {
    private final ChapterRepository chapterRepo;

    @GetMapping
    public ResponseEntity<List<ChapterListingItem>> getChapters() {
        List<Chapter> chaptersList = chapterRepo.findAll();
        return ResponseEntity.ok(
                chaptersList.stream()
                        .map(chapter -> new ChapterListingItem(chapter.getId(), chapter.getTitle()))
                        .toList()
        );
    }

    @PostMapping("/mock")
    public void addMockData() {
        chapterRepo.save(
                Chapter.builder()
                        .title("1. Capitolul 1")
                        .text("Text lung 1")
                        .premiumArticle("Articol lung 1")
                        .videoUrl("https://www.youtube.com/watch?v=KxqlJblhzfI&ab_channel=Amigoscode")
                        .build()
        );
        chapterRepo.save(
                Chapter.builder()
                        .title("2. Capitolul 2")
                        .text("Text lung 2")
                        .premiumArticle("Articol lung 2")
                        .videoUrl("https://www.youtube.com/watch?v=KxqlJblhzfI&ab_channel=Amigoscode")
                        .build()
        );
        chapterRepo.save(
                Chapter.builder()
                        .title("3. Capitolul 3")
                        .text("Text lung 3")
                        .premiumArticle("Articol lung 3")
                        .videoUrl("https://www.youtube.com/watch?v=KxqlJblhzfI&ab_channel=Amigoscode")
                        .build()
        );
    }

    @DeleteMapping("/mock")
    public void deleteAllChapters() {
        chapterRepo.deleteAll();
    }
}
