package io.h3llo.blixsales.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    @EqualsAndHashCode. Include
    private Integer idProvider;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 30, nullable = false)
    private String address;

    @Column(length = 150, nullable = false)
    private boolean enabled;
}
