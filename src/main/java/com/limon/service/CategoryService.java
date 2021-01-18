package com.limon.service;

import com.limon.entity.Category;
import com.limon.entity.Type;
import com.limon.exception.CategoryAlreadyExistsException;
import com.limon.exception.CategoryNotFoundException;
import com.limon.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Page<Category> getAll(int pageNumber, int pageSize, String sortedBy, String orderBy){
        Sort sort = orderBy.equals(orderBy) ? Sort.by(sortedBy).ascending() : Sort.by(sortedBy).descending() ;
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);
        return categoryRepository.findAll(pageable);
    }

    public Category getCategory(Long id){
        return categoryRepository.findById(id)
                .orElseThrow(()->new CategoryNotFoundException(id));
    }
    public void saveCategory(Category category){
        Category cat = categoryRepository.findByName(category.getName());
        if (cat==null)
            categoryRepository.save(category);
        else throw new CategoryAlreadyExistsException(cat);
    }

    public void updateCategory(Category category){
        if (categoryRepository.existsById(category.getId()))
            categoryRepository.save(category);
        else throw new  CategoryNotFoundException(category.getId());
    }

    public void deleteCategory(Long id){
        if (categoryRepository.existsById(id))
            categoryRepository.deleteById(id);
        else throw new CategoryNotFoundException(id);
    }
}
