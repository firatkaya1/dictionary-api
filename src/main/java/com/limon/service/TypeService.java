package com.limon.service;

import com.limon.entity.Type;
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

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TypeService {

    private final TypeRepository typeRepository;

    public Page<Type> getAll(int pageNumber, int pageSize, String sortedBy, String orderBy){
        Sort sort = orderBy.equals(orderBy) ? Sort.by(sortedBy).ascending() : Sort.by(sortedBy).descending() ;
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);
        return typeRepository.findAll(pageable);
    }

    public Type getType(Long id){
        return typeRepository.findById(id)
                .orElseThrow(()->new TypeNotFoundException(id));
    }
    public void saveType(Type type){
        Type cat = typeRepository.findByName(type.getName());
        if (cat==null)
            typeRepository.save(type);
        else throw new  TypeAlreadyExistsException(cat);
    }

    public void updateType(Type type){
        if (typeRepository.existsById(type.getId()))
            typeRepository.save(type);
        else throw new  TypeNotFoundException(type.getId());
    }

    public void deleteType(Long id){
        if (typeRepository.existsById(id))
            typeRepository.deleteById(id);
        else throw new  TypeNotFoundException(id);
    }
}