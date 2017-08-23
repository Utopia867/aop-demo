package com.example.demo.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.demo.entity.Address;
import com.example.demo.entity.Student;

import java.util.List;

/**
 * Created by Utopia on 2017/8/22.
 */
public interface AddressService {
    /**
     * 新增
     * @param address
     */
    void add(Address address);

    /**
     * 删除
     * @param addressId
     */
    void delete(Long addressId);

    /**
     * 修改
     * @param address
     */
    void update(Address address);
    /**
     * 分页查询
     * @return
     */
    Page<Address> pageAll(Page page);

    /**
     * 查询所有
     * @return
     */
    List<Address> findAll();
}
