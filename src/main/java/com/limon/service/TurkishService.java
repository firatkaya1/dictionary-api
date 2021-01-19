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

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TurkishService {

    private final TurkishRepository turkishRepository;

    public Page<Turkish> getAll(int pageNumber, int pageSize, String sortedBy, String orderBy){
        Sort sort = orderBy.equals("asc") ? Sort.by(sortedBy).ascending() : Sort.by(sortedBy).descending() ;
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);
        return turkishRepository.findAll(pageable);
    }

    public Turkish getTurkish(Long id){
        return turkishRepository.findById(id)
                .orElseThrow(()->new TurkishWordNotFoundException(id));
    }
    public void saveTurkish(Turkish turkish){
        Turkish tr = turkishRepository.findByWord(turkish.getWord());
        if (tr==null)
            turkishRepository.save(turkish);
        else throw new TurkishWordAlreadyExistsException(tr);
    }

    public void updateTurkish(Turkish turkish){
        if (turkishRepository.existsById(turkish.getId()))
            turkishRepository.save(turkish);
        else throw new  TurkishWordNotFoundException(turkish.getId());
    }

    public void deleteTurkish(Long id){
        if (turkishRepository.existsById(id))
            turkishRepository.deleteById(id);
        else throw new TurkishWordNotFoundException(id);
    }
}
