package com.example.demo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo.entity.Address;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Utopia on 2017/8/22.
 * 继承com.baomidou.mybatisplus.mapper包下的BaseMapper使用mybatisplus
 */
@Mapper
public interface AddressDao extends BaseMapper<Address> {
}
