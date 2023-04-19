package com.jiayang.tliaswebmanagement.service;

import com.jiayang.tliaswebmanagement.pojo.Emp;
import com.jiayang.tliaswebmanagement.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
public interface EmpService {
    PageBean page(Integer page, Integer pageSize, String name, short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    void save(Emp emp);

    Emp getById(Integer id);

    void update(Emp emp);

    Emp login(Emp emp);
}



