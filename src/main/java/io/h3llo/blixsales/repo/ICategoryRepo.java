package io.h3llo.blixsales.repo;

import io.h3llo.blixsales.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICategoryRepo extends IGenericRepo<Category, Integer> {

    //public Category save(Category category);

    //DerivedQueries
    //SELECT * FROM Category c WHERE c.name = '';
    //SELECT * FROM Category c WHERE c.name LIKE '%abc%';

    List<Category> findByName(String name);

    List<Category> findByNameLike(String name);
    //%XYZ% -> findByNameContains
    //%XYZ -> findByNameStarsWith
    //XYZ% -> findByNameEndsWith

    List<Category> findByNameAndEnabled(String name, boolean enabled);

    List<Category> findByNameOrEnabled(String name, boolean enabled);

    List<Category> findByEnabled (boolean enabled);

    List<Category> findByEnabledFalse();

    Category findOneByName(String name);

    List<Category> findTop3ByName(String name);

    List<Category> findByNameIs(String name);

    List<Category> findByNameIsNot(String name);

    List<Category> findByNameIsNull();

    List<Category> findByNameIsNotNull();

    List<Category> findByNameEqualsIgnoreCase (String name);

    List<Category> findByIdCategoryLessThan(Integer id);

    List<Category> findByIdCategoryLessThanEqual(Integer id);

    List<Category> findByIdCategoryGreaterThanEqual(Integer id);

    List<Category> findByIdCategoryBetween(Integer id1, Integer id2);

    List<Category> findByNameOrderByDescription (String name);

    List<Category> findByNameOrderByDescriptionAsc(String name);


    //JPQL: Java Persistence Query Language

    @Query("FROM Category c WHERE c.name = :name AND c.description LIKE %:desc%")
    List<Category> getNameAndDescription1(@Param("name") String name, @Param("desc") String description);

    @Query("SELECT new io.h3llo.blixsales.model.Category (c.name, c.enabled) FROM Category c WHERE c.name = :name AND c.description LIKE %:desc%")
    List<Category> getNameAndDescription2(@Param("name") String name, @Param("desc") String description);

}
