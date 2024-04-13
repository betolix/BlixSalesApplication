package io.h3llo.blixsales.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class IngressDetailPK {

    @ManyToOne
    @JoinColumn(name = "id_ingress", nullable = false)
    private Ingress ingress;

    @ManyToOne
    @JoinColumn (name = "id_product", nullable = false)
    private Product product;


}
