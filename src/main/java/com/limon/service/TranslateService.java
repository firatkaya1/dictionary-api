package com.limon.service;

import com.limon.entity.Translate;
import com.limon.entity.TranslateDTO;
import com.limon.repository.TranslateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TranslateService {

    private final TranslateRepository translateRepository;

    public Optional<Translate> getWord(Long id){
        return translateRepository.findById(id);
    }

    public List<TranslateDTO> getWord(String value){
        return translateRepository.findByWord(value);
    }

    public Page<TranslateDTO> getAll(String word,int pageNumber, int pageSize, String sortedBy, String orderBy){
        Sort sort = orderBy.equals("asc") ? Sort.by(sortedBy).ascending() : Sort.by(sortedBy).descending() ;
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);
        return translateRepository.findAllPageable(word,pageable);
    }

    public void save(TranslateDTO translateDTO){

    }

}
