package com.limon.controller;

import com.limon.entity.English;
import com.limon.service.EnglishService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/english")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EnglishController {

    private final EnglishService englishService;

    @GetMapping
    public ResponseEntity<?> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "100") int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "asc") String order){
        return ResponseEntity.ok(englishService.getAll(page,size,sort,order));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> get(@PathVariable Long id){
        return ResponseEntity.ok(englishService.getEnglish(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody English english){
        englishService.saveEnglish(english);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody English english){
        englishService.updateEnglish(english);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        englishService.deleteEnglish(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
