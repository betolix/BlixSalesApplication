package io.h3llo.blixsales.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Integer idUser;

    @JsonIncludeProperties(value = {"idRole","nameRole"})
    @NotNull
    private RoleDTO role;

    @JsonProperty(value = "user_name")
    @NotNull
    @Size(min = 3, max = 60)
    private String username; //camelCase lowerCamelCase

    // @JsonIgnore
    // @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    @Size(min = 3, max = 60)
    private String password;

    @NotNull
    private boolean enabled;
}
