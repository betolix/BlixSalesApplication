package io.h3llo.blixsales.controller;

import io.h3llo.blixsales.dto.RoleDTO;
import io.h3llo.blixsales.dto.GenericResponse;
import io.h3llo.blixsales.dto.GenericResponseRecord;
import io.h3llo.blixsales.model.Role;
import io.h3llo.blixsales.service.IRoleService;
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
@RequestMapping("/roles")
//@AllArgsConstructor
@RequiredArgsConstructor
public class RoleController {

    private final IRoleService service;
    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<GenericResponseRecord<RoleDTO>> readAll() throws Exception{
        List<RoleDTO> list = service.readAll().stream().map(this::convertToDto).toList();

        return ResponseEntity.ok(new GenericResponseRecord<>(200, "success", new ArrayList<>(list)));

    }



    @PostMapping
    public ResponseEntity<RoleDTO> save(@Valid @RequestBody RoleDTO dto) throws Exception {
        Role obj = service.save(convertToEntity(dto));

        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<RoleDTO>> readById(@PathVariable("id") Integer id) throws Exception{

        RoleDTO dto = convertToDto(service.readById(id));

        return ResponseEntity.ok(new GenericResponse<>(200, "success", Arrays.asList(dto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody RoleDTO dto) throws Exception {
        //category.setIdRole(id);
        Role obj = service.update(convertToEntity(dto), id);

        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    /////////////////////////////////////////////////////////////////////////
    private RoleDTO convertToDto (Role obj) {
        return modelMapper.map(obj, RoleDTO.class);
    }

    private Role convertToEntity(RoleDTO dto) {
        return modelMapper.map(dto, Role.class);
    }

}
