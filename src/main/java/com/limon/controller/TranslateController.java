package com.limon.controller;

import com.limon.service.TranslateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/translate")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TranslateController {

    private final TranslateService translateService;

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<?> get(@PathVariable Long id){
        return ResponseEntity.ok(translateService.getWord(id));
    }

    @GetMapping(value = "")
    public ResponseEntity<?> getByWord(@RequestParam String value){
        return ResponseEntity.ok(translateService.getWord(value));
    }

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam String word,
                                    @RequestParam(defaultValue = "1") int page,
                                    @RequestParam(defaultValue = "10") int size,
                                    @RequestParam(defaultValue = "translate_id") String sort,
                                    @RequestParam(defaultValue = "asc") String order){
        return ResponseEntity.ok(translateService.getAll(word,page,size,sort,order));
    }

}
