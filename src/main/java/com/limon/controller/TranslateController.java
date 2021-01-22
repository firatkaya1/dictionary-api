package com.limon.controller;

import com.limon.dto.TranslateDTO;
import com.limon.service.TranslateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/translate")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TranslateController {
    
    private final TranslateService translateService;

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(translateService.getWord(id));
    }


    @GetMapping(value = "/{word}")
    public ResponseEntity<?> getByWord(@PathVariable String word){
        return ResponseEntity.ok(translateService.getWord(word));
    }

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam String word,
                                    @RequestParam(defaultValue = "1") int page,
                                    @RequestParam(defaultValue = "10") int size,
                                    @RequestParam(defaultValue = "id") String sort,
                                    @RequestParam(defaultValue = "asc") String order){
        return ResponseEntity.ok(translateService.getAll(word,page,size,sort,order));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody TranslateDTO translateDTO){
        translateService.save(translateDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
