package io.h3llo.blixsales.service;

import io.h3llo.blixsales.dto.IProcedureDTO;
import io.h3llo.blixsales.dto.ProcedureDTO;
import io.h3llo.blixsales.model.Sale;

import java.util.List;

public interface ISaleService extends ICRUD<Sale, Integer>{

    List<ProcedureDTO> callProcedure1();

    List<IProcedureDTO> callProcedure2();

}
