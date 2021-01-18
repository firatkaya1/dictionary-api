package com.limon.controller;

import com.limon.entity.Type;
import com.limon.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/type")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TypeController {

    private final TypeService typeService;


    @GetMapping
    public ResponseEntity<?> getAll(
                                    @RequestParam(defaultValue = "1") int page,
                                    @RequestParam(defaultValue = "100") int size,
                                    @RequestParam(defaultValue = "id") String sort,
                                    @RequestParam(defaultValue = "asc") String order){
        return ResponseEntity.ok(typeService.getAll(page,size,sort,order));
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> get(@PathVariable Long id){
        return ResponseEntity.ok(typeService.getType(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Type type){
        typeService.saveType(type);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Type type){
        typeService.updateType(type);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        typeService.deleteType(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
