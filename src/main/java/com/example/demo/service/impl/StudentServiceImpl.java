package com.example.demo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.demo.common.AopAspectAnnotation;
import com.example.demo.dao.AddressDao;
import com.example.demo.dao.StudentDao;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Utopia on 2017/8/22.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private AddressDao addressDao;

    /**
     * 新增
     *
     *复杂类型属性address，先保存address带回addressId,再保存student带回id，然后插入将addresId值插入student表中
     * @param student
     */
    @Transactional
    @Override
    public void add(Student student) {
        addressDao.insert(student.getAddress());
        studentDao.insert(student);
        studentDao.saveAddressId(student.getId(),student.getAddress().getId());
    }

    /**
     * 删除
     *
     *
     * @param studentId
     */
    @AopAspectAnnotation
    @Override
    public void delete(Long studentId) {
        studentDao.deleteById(studentId);
    }

    /**
     * 修改
     *
     * @param student
     */
    @Transactional
    @Override
    public void update(Student student) {
        addressDao.updateById(student.getAddress());
        studentDao.updateById(student);
    }

    /**
     * 分页查询
     *
     * @return
     */
    @AopAspectAnnotation
    @Override
    public Page<Student> pageAll(Page page) {
        List<Student> studentList = studentDao.pageAll(page);
        page.setRecords(studentList);
        return page;
    }

    /**
     * 查询所有
     *
     * @return
     */
    @AopAspectAnnotation
    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }
}
