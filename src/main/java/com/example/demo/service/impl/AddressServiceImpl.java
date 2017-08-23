package com.example.demo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.demo.common.AopAspectAnnotation;
import com.example.demo.dao.AddressDao;
import com.example.demo.entity.Address;
import com.example.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Utopia on 2017/8/22.
 */
@Service

public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao addressDao;

    /**
     * 新增
     *
     * @param address
     */
    @Override
    public void add(Address address) {
        addressDao.insert(address);
    }

    /**
     * 删除
     *
     * @param addressId
     */
    @Override
    public void delete(Long addressId) {
        addressDao.deleteById(addressId);
    }

    /**
     * 修改
     *
     * @param address
     */
    @Override
    public void update(Address address) {
        addressDao.updateById(address);
    }

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    @AopAspectAnnotation
    @Override
    public Page<Address> pageAll(Page page) {
        Wrapper entityWrapper = new EntityWrapper<Address>();
        List<Address> addressList = addressDao.selectPage(page,entityWrapper);
        page.setRecords(addressList);
        return page;
    }

    /**
     * 查询所有
     *
     * @return
     */
    @AopAspectAnnotation
    @Override
    public List<Address> findAll() {
        Wrapper entityWrapper = new EntityWrapper<Address>();
        return addressDao.selectList(entityWrapper);
    }
}
