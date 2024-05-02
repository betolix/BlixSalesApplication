package io.h3llo.blixsales.controller;

import io.h3llo.blixsales.dto.GenericResponse;
import io.h3llo.blixsales.dto.GenericResponseRecord;
import io.h3llo.blixsales.dto.SaleDTO;
import io.h3llo.blixsales.model.Sale;
import io.h3llo.blixsales.service.ISaleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/sales")
//@AllArgsConstructor
@RequiredArgsConstructor
public class SaleController {

    private final ISaleService service;
    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<GenericResponseRecord<SaleDTO>> readAll() throws Exception{
        List<SaleDTO> list = service.readAll().stream().map(this::convertToDto).toList();

        return ResponseEntity.ok(new GenericResponseRecord<>(200, "success", new ArrayList<>(list)));

    }


    @PostMapping
    public ResponseEntity<SaleDTO> save(@Valid @RequestBody SaleDTO dto) throws Exception {
        Sale obj = service.save(convertToEntity(dto));

        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<SaleDTO>> readById(@PathVariable("id") Integer id) throws Exception{

        SaleDTO dto = convertToDto(service.readById(id));

        return ResponseEntity.ok(new GenericResponse<>(200, "success", Arrays.asList(dto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaleDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody SaleDTO dto) throws Exception {
        //category.setIdSale(id);
        Sale obj = service.update(convertToEntity(dto), id);

        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    /////////////////////////////////////////////////////////////////////////
    private SaleDTO convertToDto (Sale obj) {
        return modelMapper.map(obj, SaleDTO.class);
    }

    private Sale convertToEntity(SaleDTO dto) {
        return modelMapper.map(dto, Sale.class);
    }

}
