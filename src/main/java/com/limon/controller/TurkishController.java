package com.limon.controller;

import com.limon.entity.Turkish;
import com.limon.service.TurkishService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/turkish")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TurkishController {

    private final TurkishService turkishService;

    @GetMapping
    public ResponseEntity<?> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "100") int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "asc") String order){
        return ResponseEntity.ok(turkishService.getAll(page,size,sort,order));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> get(@PathVariable Long id){
        return ResponseEntity.ok(turkishService.getTurkish(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Turkish turkish){
        turkishService.saveTurkish(turkish);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Turkish turkish){
        turkishService.updateTurkish(turkish);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        turkishService.deleteTurkish(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
