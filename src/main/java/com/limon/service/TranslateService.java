package com.limon.service;

import com.limon.entity.Translate;
import com.limon.dto.TranslateDTO;
import com.limon.exception.TranslateNotFoundException;
import com.limon.repository.TranslateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This is a service layer which is between
 * category repository and category controller layer. In this
 * layer, you can manage the Translate service.
 * Simply you can do CRUD stuff in here.
 * @author firatkaya1
 * @version 1.0.0
 * @see com.limon.repository.TranslateRepository
 * @see com.limon.entity.Translate
 */

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TranslateService {

    private final TranslateRepository translateRepository;

    /**
     * This method used to find translate by ID.
     * If ID not exists in table then an exception
     * will thrown.
     * @param id Primary Key in the table.
     * @return Translate
     * @see com.limon.entity.Translate
     * @exception TranslateNotFoundException thrown
     */

    public Translate getWord(Long id){
        return translateRepository.findById(id).orElseThrow(()->new TranslateNotFoundException(id));
    }

    /**
     * This method used to get all translate matches.
     * Response will be list format.
     * This method is not recommended. If word has
     * matches with 1000 records can be long for your
     * response time.
     * @param word English word
     * @return TranslateDTO entities in a list.
     * @see  com.limon.entity.Translate
     * @see  com.limon.dto.TranslateDTO
     */
    public List<TranslateDTO> getWord(String word){
        return translateRepository.findByWord(word);
    }

    /**
     * This method used to get all translate matches.
     * Response will be pageable format even
     * maximum element one.
     * @param word get LIKE "word"
     * @param pageNumber page number
     * @param pageSize maximum element in a page
     * @param sortedBy sorted by name or id
     * @param orderBy order by ASC or DESC
     * @return TranslateDTO entities in pageable format
     * @see  com.limon.entity.Translate
     * @see  com.limon.dto.TranslateDTO
     */
    public Page<TranslateDTO> getAll(String word,int pageNumber, int pageSize, String sortedBy, String orderBy){
        Sort sort = orderBy.equals("asc") ? Sort.by(sortedBy).ascending() : Sort.by(sortedBy).descending() ;
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);
        return translateRepository.findAllPageable(word,pageable);
    }

    public void save(TranslateDTO translateDTO){

    }

}
