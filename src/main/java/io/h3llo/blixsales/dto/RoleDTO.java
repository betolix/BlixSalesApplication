package io.h3llo.blixsales.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {

    private Integer idRole;

    @NotNull
    private String nameRole;

    @NotNull
    private boolean enabledRole;
}
