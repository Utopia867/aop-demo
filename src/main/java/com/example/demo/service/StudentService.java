package com.example.demo.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.demo.entity.Student;

import java.util.List;

/**
 * Created by Utopia on 2017/8/22.
 */
public interface StudentService {
    /**
     * 新增
     * @param student
     */
    void add(Student student);

    /**
     * 删除
     * @param studentId
     */
    void delete(Long studentId);

    /**
     * 修改
     * @param student
     */
    void update(Student student);
    /**
     * 分页查询
     * @return
     */
    Page<Student> pageAll(Page page);

    /**
     * 查询所有
     * @return
     */
    List<Student> findAll();

}
