package com.jiayang.tliaswebmanagement.service;

import com.jiayang.tliaswebmanagement.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 */
public interface DeptService {

    /**
     * query data of all departments
     * @return
     */
    List<Dept> list();

    void delete(Integer id);

    /**
     * 新增部门
     * @param dept
     */
    void add(Dept dept);
}
