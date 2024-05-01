package io.h3llo.blixsales.dto;

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

    @NotNull
    private RoleDTO role;

    @NotNull
    @Size(min = 3, max = 60)
    private String username;

    @NotNull
    @Size(min = 3, max = 60)
    private String password;

    @NotNull
    private boolean enabled;
}
