package com.limon.service;

import com.limon.entity.Category;
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

/**
 * This is a service layer which is between
 * category repository and category controller layer. In this
 * layer, you can manage the Category service.
 * Simply you can do CRUD stuff in here.
 * @author firatkaya1
 * @version 1.0.0
 * @see com.limon.repository.CategoryRepository
 * @see com.limon.entity.Category
 */

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CategoryService {

    private final CategoryRepository categoryRepository;

    /**
     * This method used to get categories.
     * Response will be pageable format even
     * maximum element one.
     * @param pageNumber page number
     * @param pageSize maximum element in a page
     * @param sortedBy sorted by name or id
     * @param orderBy order by ASC or DESC
     * @return Category entities in pageable format
     * @see  com.limon.entity.Category
     */
    public Page<Category> getAll(int pageNumber, int pageSize, String sortedBy, String orderBy){
        Sort sort = orderBy.equals("asc") ? Sort.by(sortedBy).ascending() : Sort.by(sortedBy).descending() ;
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);
        return categoryRepository.findAll(pageable);
    }

    /**
     * This method used to find category by ID.
     * If ID not exists in table then an exception
     * will thrown.
     * @param id Primary Key in the table.
     * @return Category
     * @see  com.limon.entity.Category
     * @exception CategoryNotFoundException thrown
     */

    public Category getCategory(Long id){
        return categoryRepository.findById(id)
                .orElseThrow(()->new CategoryNotFoundException(id));
    }

    /**
     * This method used to save category.
     * If category is already exists in database then
     * an exception will thrown.
     * @param category An entity that represent the Category
     * @see  com.limon.entity.Category
     * @exception CategoryAlreadyExistsException thrown
     */

    public void saveCategory(Category category){
        Category cat = categoryRepository.findByName(category.getName());
        if (cat==null)
            categoryRepository.save(category);
        else throw new CategoryAlreadyExistsException(cat);
    }

    /**
     * This method used to update category.
     * If category is not found in database then
     * an exception will thrown.
     * @param category An entity that represent the Category
     * @see  com.limon.entity.Category
     * @exception CategoryNotFoundException thrown
     *
     */

    public void updateCategory(Category category){
        if (categoryRepository.existsById(category.getId()))
            categoryRepository.save(category);
        else throw new  CategoryNotFoundException(category.getId());
    }

    /**
     * This method used to delete category value by id.
     * If ID is not exists in database then
     * an exception will thrown.
     * @param id Primary Key in the table.
     * @see  com.limon.entity.Category
     * @exception CategoryNotFoundException thrown
     */
    public void deleteCategory(Long id){
        if (categoryRepository.existsById(id))
            categoryRepository.deleteById(id);
        else throw new CategoryNotFoundException(id);
    }
}
