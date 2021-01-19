package com.limon.service;

import com.limon.entity.Type;
import com.limon.exception.CategoryNotFoundException;
import com.limon.exception.TypeAlreadyExistsException;
import com.limon.exception.TypeNotFoundException;
import com.limon.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * This is a service layer which is between
 * type repository and type controller layer. In this
 * layer, you can manage the Type service.
 * Simply you can do CRUD stuff in here.
 * @author firatkaya1
 * @version 1.0.0
 * @see com.limon.repository.TypeRepository
 * @see com.limon.entity.Type
 */


@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TypeService {

    private final TypeRepository typeRepository;

    /**
     * This method used to get categories.
     * Response will be pageable format even
     * maximum element one.
     * @param pageNumber page number
     * @param pageSize maximum element in a page
     * @param sortedBy sorted by name or id
     * @param orderBy order by ASC or DESC
     * @return Type entities in pageable format
     * @see  com.limon.entity.Type
     */
    public Page<Type> getAll(int pageNumber, int pageSize, String sortedBy, String orderBy){
        Sort sort = orderBy.equals("asc") ? Sort.by(sortedBy).ascending() : Sort.by(sortedBy).descending() ;
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);
        return typeRepository.findAll(pageable);
    }

    /**
     * This method used to find type by ID.
     * If ID not exists in table then an exception
     * will thrown.
     * @param id Primary Key in the table.
     * @return Type
     * @see  com.limon.entity.Type
     * @exception TypeNotFoundException thrown
     */

    public Type getType(Long id){
        return typeRepository.findById(id)
                .orElseThrow(()->new TypeNotFoundException(id));
    }

    /**
     * This method used to save type.
     * If type is already exists in database then
     * an exception will thrown.
     * @param type An entity that represent the Type
     * @see  com.limon.entity.Type
     * @exception TypeAlreadyExistsException thrown
     */

    public void saveType(Type type){
        Type cat = typeRepository.findByName(type.getName());
        if (cat==null)
            typeRepository.save(type);
        else throw new  TypeAlreadyExistsException(cat);
    }

    /**
     * This method used to update type.
     * If type is not found in database then
     * an exception will thrown.
     * @param type An entity that represent the Type
     * @see  com.limon.entity.Type
     * @exception CategoryNotFoundException thrown
     */

    public void updateType(Type type){
        if (typeRepository.existsById(type.getId()))
            typeRepository.save(type);
        else throw new  TypeNotFoundException(type.getId());
    }

    /**
     * This method used to delete type value by id.
     * If ID is not exists in database then
     * an exception will thrown.
     * @param id Primary Key in the table.
     * @see  com.limon.entity.Type
     * @exception TypeNotFoundException thrown
     */

    public void deleteType(Long id){
        if (typeRepository.existsById(id))
            typeRepository.deleteById(id);
        else throw new  TypeNotFoundException(id);
    }
}