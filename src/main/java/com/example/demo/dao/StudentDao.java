package com.example.demo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Utopia on 2017/8/22.
 *  继承com.baomidou.mybatisplus.mapper包下的BaseMapper使用mybatisplus
 */
@Mapper
public interface StudentDao extends BaseMapper<Student> {
    List<Student> pageAll(Page page);
    List<Student> findAll();
    void saveAddressId(@Param("id") Long id,@Param("addressId") Long addressId);
}
