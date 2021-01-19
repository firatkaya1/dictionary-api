package com.limon.service;

import com.limon.entity.Turkish;
import com.limon.exception.TurkishWordAlreadyExistsException;
import com.limon.exception.TurkishWordNotFoundException;
import com.limon.repository.TurkishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * This is a service layer which is between
 * turkish repository and turkish controller layer. In this
 * layer, you can manage the Turkish service.
 * Simply you can do CRUD stuff in here.
 * @author firatkaya1
 * @version 1.0.0
 * @see com.limon.repository.TurkishRepository
 * @see com.limon.entity.Turkish
 */

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TurkishService {

    private final TurkishRepository turkishRepository;

    /**
     * This method used to get turkish words.
     * Response will be pageable format even
     * maximum element one.
     * @param pageNumber page number
     * @param pageSize maximum element in a page
     * @param sortedBy sorted by name or id
     * @param orderBy order by ASC or DESC
     * @return Turkish entities in pageable format
     * @see  com.limon.entity.Turkish
     */
    public Page<Turkish> getAll(int pageNumber, int pageSize, String sortedBy, String orderBy){
        Sort sort = orderBy.equals("asc") ? Sort.by(sortedBy).ascending() : Sort.by(sortedBy).descending() ;
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);
        return turkishRepository.findAll(pageable);
    }

    /**
     * This method used to find category by ID.
     * If ID not exists in table then an exception
     * will thrown.
     * @param id Primary Key in the table.
     * @return An entity that represent the Turkish
     * @see  com.limon.entity.Turkish
     * @exception TurkishWordNotFoundException thrown
     */
    public Turkish getTurkish(Long id){
        return turkishRepository.findById(id)
                .orElseThrow(()->new TurkishWordNotFoundException(id));
    }

    /**
     * This method used to save turkish word.
     * If turkish word is already exists in database then
     * an exception will thrown.
     * @param turkish An entity that represent the Turkish
     * @see  com.limon.entity.Turkish
     * @exception TurkishWordAlreadyExistsException thrown
     */

    public void saveTurkish(Turkish turkish){
        Turkish tr = turkishRepository.findByWord(turkish.getWord());
        if (tr==null)
            turkishRepository.save(turkish);
        else throw new TurkishWordAlreadyExistsException(tr);
    }

    /**
     * This method used to update turkish word.
     * If category is not found in database then
     * an exception will thrown.
     * @param turkish An entity that represent the Turkish
     * @see  com.limon.entity.Turkish
     * @exception TurkishWordNotFoundException thrown
     */
    public void updateTurkish(Turkish turkish){
        if (turkishRepository.existsById(turkish.getId()))
            turkishRepository.save(turkish);
        else throw new  TurkishWordNotFoundException(turkish.getId());
    }

    /**
     * This method used to delete turkish word by id.
     * If ID is not exists in database then
     * an exception will thrown.
     * @param id Primary Key in the table.
     * @see  com.limon.entity.Turkish
     * @exception TurkishWordNotFoundException thrown
     */
    public void deleteTurkish(Long id){
        if (turkishRepository.existsById(id))
            turkishRepository.deleteById(id);
        else throw new TurkishWordNotFoundException(id);
    }
}
