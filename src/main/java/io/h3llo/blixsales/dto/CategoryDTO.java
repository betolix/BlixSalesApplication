package io.h3llo.blixsales.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDTO {

    private Integer idCategory;

    @Size(min = 3)
    private String nameofCategory;

    @Size (min = 3)
    private String descriptionCategory;

    @NotNull
    private boolean enabledCategory;

//    @NotNull   -> El campo no deben olvidarselo
//    @NotEmpty  -> El campo no debe estar vacio ""
//    @NotBlank  -> El campo no debe tener caracteres en blanco
//    @Max
//    @Min
//    @Email
//    @Pattern (regexp = "[0-9]+")
}
