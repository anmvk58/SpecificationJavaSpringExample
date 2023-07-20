package com.anmv.service;

import com.anmv.entity.Account;
import com.anmv.entity.Department;
import com.anmv.form.DepartmentFilterForm;
import com.anmv.repository.IDepartmentRepository;
import com.anmv.specification.AccountSpecification;
import com.anmv.specification.DepartmentSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements  IDepartmentService{
    @Autowired
    private IDepartmentRepository repository;

    @Override
    public List<Department> getAllDepartments(DepartmentFilterForm form) {
        Specification<Department> specification = DepartmentSpecification.buildWhere(form);
        return repository.findAll(specification);
    }
}
