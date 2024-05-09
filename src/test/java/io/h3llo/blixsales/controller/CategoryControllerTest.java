package io.h3llo.blixsales.controller;

import io.h3llo.blixsales.dto.CategoryDTO;
import io.h3llo.blixsales.model.Category;
import io.h3llo.blixsales.service.ICategoryService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org. hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;

@WebMvcTest(CategoryController.class)
public class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ICategoryService service;

    @MockBean(name = "categoryMapper")
    private ModelMapper modelMapper;

    Category CATEGORY_1 = new Category (1, "TV", "Television",true);
    Category CATEGORY_2 = new Category (2, "PSP", "Play Station Portable",true);
    Category CATEGORY_3 = new Category (3, "BOKS", "Some books",true);

    CategoryDTO CATEGORYDTO_1 = new CategoryDTO (1, "TV", "Television",true);
    CategoryDTO CATEGORYDTO_2 = new CategoryDTO (2, "PSP", "Play Station Portable",true);
    CategoryDTO CATEGORYDTO_3 = new CategoryDTO (3, "BOKS", "Some books",true);


    @Test
    void readAllTest() throws Exception{
        List<Category> categories = List.of(CATEGORY_1, CATEGORY_2, CATEGORY_3);
        Mockito.when(service.readAll()).thenReturn(categories);
        Mockito.when(modelMapper.map(CATEGORY_1, CategoryDTO.class)).thenReturn(CATEGORYDTO_1);
        Mockito.when(modelMapper.map(CATEGORY_2, CategoryDTO.class)).thenReturn(CATEGORYDTO_2);
        Mockito.when(modelMapper.map(CATEGORY_3, CategoryDTO.class)).thenReturn(CATEGORYDTO_3);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/categories")
                .content(MediaType.APPLICATION_JSON_VALUE)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data", hasSize(3)))
                .andExpect(jsonPath("$.data[1].nameofCategory",is("PSP")));
    }



    @Test
    void readByIdTest() throws Exception{
        final int ID = 1;

        Mockito.when(service.readById(any())).thenReturn(CATEGORY_1);
        Mockito.when(modelMapper.map(CATEGORY_1, CategoryDTO.class)).thenReturn(CATEGORYDTO_1);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/categories/" + ID )
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data", hasSize(1)))
                .andExpect(jsonPath( "$.data[0].nameofCategory", is("TV")));

    }


    @Test
    void createTest() throws Exception {

    }



}





















