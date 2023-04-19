package com.jiayang.tliaswebmanagement.service.impl;

import com.jiayang.tliaswebmanagement.mapper.DeptMapper;
import com.jiayang.tliaswebmanagement.mapper.EmpMapper;
import com.jiayang.tliaswebmanagement.pojo.Dept;
import com.jiayang.tliaswebmanagement.pojo.DeptLog;
import com.jiayang.tliaswebmanagement.service.DeptLogService;
import com.jiayang.tliaswebmanagement.service.DeptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private DeptLogService deptLogService;

    @Override
    public List<Dept> list() {

        return deptMapper.list();

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) {
        try {
            deptMapper.deleteById(id); //根据ID删除部门数据

            //if(true){throw new Exception("出错啦...");}

            empMapper.deleteByDeptId(id); //根据部门ID删除该部门下的员工
        } finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行了解散部门的操作,此次解散的是"+id+"号部门");
            deptLogService.insert(deptLog);
        }
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.insert(dept);
    }
}
