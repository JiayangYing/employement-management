package com.jiayang.tliaswebmanagement.controller;

import com.jiayang.tliaswebmanagement.anno.Log;
import com.jiayang.tliaswebmanagement.pojo.Emp;
import com.jiayang.tliaswebmanagement.pojo.PageBean;
import com.jiayang.tliaswebmanagement.pojo.Result;
import com.jiayang.tliaswebmanagement.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理Controller
 */
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;
    @GetMapping()

    public Result page(@RequestParam(defaultValue = "1") Integer page,

                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
    log.info("query parameters: {} {} {} {} {}", page, pageSize, name,gender, begin, end);


    PageBean pageBean = empService.page(page,pageSize,name,gender, begin, end);

       return Result.success(pageBean);
    }

    @Log
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("delete , ids{}", ids);
        empService.delete(ids);
        return Result.success();
    }

    @Log
    @PostMapping()
    public Result save(@RequestBody Emp emp){
        log.info("add emp: {}", emp);
        empService.save(emp);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("query by id: {}", id);
        Emp emp =  empService.getById(id);
        return Result.success(emp);

    }

    @Log
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("update emp infomation: {}", emp);
        empService.update(emp);
        return Result.success();
    }


}
