package com.example.demo.web;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.demo.common.AjaxResp;
import com.example.demo.entity.Address;
import com.example.demo.entity.Student;
import com.example.demo.service.AddressService;
import com.example.demo.service.StudentService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Utopia on 2017/8/22.
 */
@RestController
@Api(value = "Address相关",tags = "AddressController", description = "Address相关" )
public class AddressController {

    @Autowired
    private AddressService addressService;

    //接口文档，通过地址http://localhost:8034/aopdemo/swagger-ui.html#/访问
    @ApiOperation(value = "获取地址列表", httpMethod = "GET", response = AjaxResp.class, produces = "application/json")
    @ApiImplicitParams(value = {
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = AjaxResp.class)
    })

    @RequestMapping(value = "address",method = RequestMethod.GET)
    public AjaxResp list(@RequestParam(required = false,defaultValue = "1") Integer current,
                         @RequestParam(required = false,defaultValue = "0") Integer size){

        List<Address> addressList;
        if(size==0){//size==0时，查询所有;否则进行分页查询
            addressList = addressService.findAll();
        }else {
            Page<Student> page = new Page<Student>();
            page.setCurrent(current);
            page.setSize(size);
            Page<Address> addressPage = addressService.pageAll(page);
            addressList = addressPage.getRecords();
        }
        return new AjaxResp(AjaxResp.SUCCESS,addressList);
    }

    @ApiOperation(value = "添加地址", httpMethod = "POST", response = AjaxResp.class, produces = "application/json")
    @ApiImplicitParams(value = {
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = AjaxResp.class)
    })

    @RequestMapping(value = "address/add",method = RequestMethod.POST)
    public AjaxResp save(Address address){
        addressService.add(address);
        return new AjaxResp(AjaxResp.SUCCESS,"添加成功");
    }
    @ApiOperation(value = "修改地址信息", httpMethod = "POST", response = AjaxResp.class, produces = "application/json")
    @ApiImplicitParams(value = {
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = AjaxResp.class)
    })

    @RequestMapping(value = "address/update",method = RequestMethod.POST)
    public AjaxResp update(Address address){
        addressService.update(address);
        return new AjaxResp(AjaxResp.SUCCESS,"修改成功");
    }
    @ApiOperation(value = "删除地址", httpMethod = "DELETE", response = AjaxResp.class, produces = "application/json")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "addressId", value = "address ID", paramType = "path", dataType = "long"),
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = AjaxResp.class)
    })

    @RequestMapping(value = "address/{addressId}",method = RequestMethod.DELETE)
    public AjaxResp delete( @PathVariable Long addressId){
        addressService.delete(addressId);
        return new AjaxResp(AjaxResp.SUCCESS,"删除成功");
    }
}
