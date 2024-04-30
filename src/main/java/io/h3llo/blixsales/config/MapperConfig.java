package io.h3llo.blixsales.config;

import io.h3llo.blixsales.dto.CategoryDTO;
import io.h3llo.blixsales.model.Category;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean("categoryMapper")
    public ModelMapper categoryMapper(){
        ModelMapper mapper = new ModelMapper();

        //Handle Missmatches

        //Lectura
        mapper.createTypeMap(Category.class, CategoryDTO.class)
                .addMapping(Category::getName, (dest, v) -> dest.setNameofCategory((String) v));

        //Escritura
        mapper.createTypeMap(CategoryDTO.class, Category.class)
                .addMapping(CategoryDTO::getNameofCategory, (dest, v) -> dest.setName((String) v));

        return mapper;
    }
}