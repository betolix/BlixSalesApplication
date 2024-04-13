package io.h3llo.blixsales.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class IngressDetail {


    @Id
    private Ingress ingress;

    @Id
    private Product product;


    static class IngressDetailPK{
        @ManyToOne
        @JoinColumn(name = "id_ingress", nullable = false)
        private Ingress ingress;

        @ManyToOne
        @JoinColumn (name = "id_product", nullable = false)
        private Product product;
    }


}
