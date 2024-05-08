package io.h3llo.blixsales.service.impl;

import io.h3llo.blixsales.dto.IProcedureDTO;
import io.h3llo.blixsales.dto.ProcedureDTO;
import io.h3llo.blixsales.model.Sale;
import io.h3llo.blixsales.repo.IGenericRepo;
import io.h3llo.blixsales.repo.ISaleRepo;
import io.h3llo.blixsales.service.ISaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;


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

    @Override
    public void callProcedure4() {
        repo.callProcedure4();
    }

    @Override
    public Sale getSaleMostExpensive() {
        return repo.findAll()
                .stream()
                .max(Comparator.comparing(Sale::getTotal))
                .orElse(new Sale());
    }

    @Override
    public String getBestSellerPerson() {
        Map<String, Double> byUser = repo.findAll()
                .stream()
                .collect(groupingBy(s -> s.getUser().getUsername(), summingDouble(Sale::getTotal)));

        return Collections.max(byUser.entrySet(), Comparator.comparing(Map.Entry::getValue)).getKey();
    }

    @Override
    public Map<String, Long> getSalesCountBySeller() {
        Map<String, Long> byUser = repo.findAll()
                .stream()
                .collect(groupingBy(s -> s.getUser().getUsername(), counting()));

        return byUser;

    }


}





