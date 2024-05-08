package io.h3llo.blixsales.service;

import io.h3llo.blixsales.dto.IProcedureDTO;
import io.h3llo.blixsales.dto.ProcedureDTO;
import io.h3llo.blixsales.model.Sale;

import java.util.List;
import java.util.Map;

public interface ISaleService extends ICRUD<Sale, Integer>{

    List<ProcedureDTO> callProcedure1();
    List<IProcedureDTO> callProcedure2();
    List<ProcedureDTO> callProcedure3();
    void callProcedure4();

    Sale getSaleMostExpensive(); // OBTENER LA VENTA MAYOR

    String getBestSellerPerson(); // OBTENER EL NOMBRE DEL MEJOR VENDEDOR

    Map<String, Long> getSalesCountBySeller();


}
