package com.anmv.service;

import com.anmv.entity.Department;
import com.anmv.form.DepartmentFilterForm;

import java.util.List;

public interface IDepartmentService {
    List<Department> getAllDepartments(DepartmentFilterForm form);
}
