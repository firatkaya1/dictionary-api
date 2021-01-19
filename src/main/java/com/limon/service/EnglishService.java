package com.limon.service;

import com.limon.entity.English;
import com.limon.exception.EnglishWordAlreadyExistsException;
import com.limon.exception.EnglishWordNotFoundException;
import com.limon.repository.EnglishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * This is a service layer which is between
 * repository and controller layers. In this
 * layer, you can manage the English service.
 * Simply you can do CRUD stuff in here.
 * @author firatkaya1
 * @version 1.0.0
 * @see com.limon.repository.EnglishRepository
 * @see com.limon.entity.English
 */

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EnglishService {

    private final EnglishRepository englishRepository;

    /**
     * This method used to get english words.
     * If a english word has many matches with category,type
     * and turkish meaning then values will be pageable format
     * even maximum element one.
     * @param pageNumber page number
     * @param pageSize maximum element in a page
     * @param sortedBy sorted by name or id
     * @param orderBy order by ASC or DESC
     * @return English entities in pageable format
     */

    public Page<English> getAll(int pageNumber, int pageSize, String sortedBy, String orderBy){
        Sort sort = orderBy.equals("asc") ? Sort.by(sortedBy).ascending() : Sort.by(sortedBy).descending() ;
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);
        return englishRepository.findAll(pageable);
    }

    /**
     * This method used to find word by ID. If value
     * not exists then an exception will thrown.
     * @param id Primary Key in the table.
     * @exception EnglishWordNotFoundException thrown
     * @return English entity
     */

    public English getEnglish(Long id){
        return englishRepository.findById(id)
                .orElseThrow(()->new EnglishWordNotFoundException(id));
    }

    /**
     * This method used to save new english value.
     * If value is already exists in database then
     * an exception will thrown.
     * @param english An Entity @see {@link English}
     * @exception EnglishWordAlreadyExistsException thrown
     */

    public void saveEnglish(English english){
        English eng = englishRepository.findByWord(english.getWord());
        if (eng==null)
            englishRepository.save(english);
        else throw new EnglishWordAlreadyExistsException(eng);
    }

    /**
     * This method used to update english value.
     * If value is not found in database then
     * an exception will thrown.
     * @param english An entity that represent the Turkish
     * @exception EnglishWordNotFoundException thrown
     */
    public void updateEnglish(English english){
        if (englishRepository.existsById(english.getId()))
            englishRepository.save(english);
        else throw new  EnglishWordNotFoundException(english.getId());
    }

    /**
     * This method used to delete english value by id.
     * If ID is not exists in database then
     * an exception will thrown.
     * @param id Primary key in table
     * @exception EnglishWordNotFoundException thrown
     */
    public void deleteEnglish(Long id){
        if (englishRepository.existsById(id))
            englishRepository.deleteById(id);
        else throw new EnglishWordNotFoundException(id);
    }
}
