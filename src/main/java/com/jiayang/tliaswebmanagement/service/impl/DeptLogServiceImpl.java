package com.jiayang.tliaswebmanagement.service.impl;

import com.jiayang.tliaswebmanagement.mapper.DeptLogMapper;
import com.jiayang.tliaswebmanagement.pojo.DeptLog;
import com.jiayang.tliaswebmanagement.service.DeptLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeptLogServiceImpl implements DeptLogService {

    @Autowired
    private DeptLogMapper deptLogMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insert(DeptLog deptLog) {
        deptLogMapper.insert(deptLog);
    }
}
