package io.h3llo.blixsales.service.impl;

import io.h3llo.blixsales.dto.IProcedureDTO;
import io.h3llo.blixsales.dto.ProcedureDTO;
import io.h3llo.blixsales.model.Sale;
import io.h3llo.blixsales.repo.IGenericRepo;
import io.h3llo.blixsales.repo.ISaleRepo;
import io.h3llo.blixsales.service.ISaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
//@AllArgsConstructor
 @RequiredArgsConstructor
public class SaleServiceImpl extends CRUDImpl<Sale, Integer> implements ISaleService {


    private final ISaleRepo repo;

    @Override
    protected IGenericRepo<Sale, Integer> getRepo() {
        return repo;
    }


    @Override
    public List<ProcedureDTO> callProcedure1() {
        List<ProcedureDTO> procedureDTOList = new ArrayList<>();
        repo.callProcedure1().forEach(det -> {
            ProcedureDTO procedureDTO = new ProcedureDTO();
            procedureDTO.setQuantityfn((Integer) det[0]);
            procedureDTO.setDatetimefn((String) det[1]);

            procedureDTOList.add(procedureDTO);
        });
        return procedureDTOList;
    }

    @Override
    public List<IProcedureDTO> callProcedure2() {
        return repo.callProcedure2();
    }

    @Override
    public List<ProcedureDTO> callProcedure3() {
        return repo.callProcedure3();
    }


}
