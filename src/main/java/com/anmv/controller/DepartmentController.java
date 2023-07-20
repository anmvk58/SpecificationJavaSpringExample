package com.anmv.controller;

import com.anmv.entity.AccountDTO;
import com.anmv.entity.Department;
import com.anmv.entity.DepartmentDTO;
import com.anmv.form.DepartmentFilterForm;
import com.anmv.service.IDepartmentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/departments")
public class DepartmentController {
    @Autowired
    private IDepartmentService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<DepartmentDTO> getAllDepartments(DepartmentFilterForm form){
        List<Department> departments = service.getAllDepartments(form);
        List<DepartmentDTO> departmentDTOS = modelMapper.map(departments, new TypeToken<List<DepartmentDTO>>(){
        }.getType());

        return departmentDTOS;
    }
}
