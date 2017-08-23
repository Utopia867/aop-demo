package com.example.demo.web;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.demo.common.AjaxResp;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Utopia on 2017/8/22.
 */
@RestController
@Api(value = "Student相关",tags = "StudentController", description = "Student相关" )
public class StudentController {

    @Autowired
    private StudentService studentService;

    //接口文档，通过地址http://localhost:8034/aopdemo/swagger-ui.html#/访问
    @ApiOperation(value = "获取学生列表", httpMethod = "GET", response = AjaxResp.class, produces = "application/json")
    @ApiImplicitParams(value = {
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = AjaxResp.class)
    })

    @RequestMapping(value = "student",method = RequestMethod.GET)
    public AjaxResp list(@RequestParam(required = false,defaultValue = "1") Integer current,
                         @RequestParam(required = false,defaultValue = "0") Integer size){

        List<Student> studentList;
        if(size==0){//size==0时，查询所有;否则进行分页查询
            studentList = studentService.findAll();
        }else {
            Page<Student> page = new Page<Student>();
            page.setCurrent(current);
            page.setSize(size);
            Page<Student> studentPage = studentService.pageAll(page);
            studentList = studentPage.getRecords();
        }
        return new AjaxResp(AjaxResp.SUCCESS,studentList);
    }

    @ApiOperation(value = "添加学生", httpMethod = "POST", response = AjaxResp.class, produces = "application/json")
    @ApiImplicitParams(value = {
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = AjaxResp.class)
    })

    @RequestMapping(value = "student/add",method = RequestMethod.POST)
    public AjaxResp save(Student student){
        studentService.add(student);
        return new AjaxResp(AjaxResp.SUCCESS,"添加成功");
    }
    @ApiOperation(value = "修改学生信息", httpMethod = "POST", response = AjaxResp.class, produces = "application/json")
    @ApiImplicitParams(value = {
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = AjaxResp.class)
    })

    @RequestMapping(value = "student/update",method = RequestMethod.POST)
    public AjaxResp update(Student student){
        studentService.update(student);
        return new AjaxResp(AjaxResp.SUCCESS,"修改成功");
    }
    @ApiOperation(value = "删除学生", httpMethod = "DELETE", response = AjaxResp.class, produces = "application/json")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "studentId", value = "student ID", paramType = "path", dataType = "long"),
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = AjaxResp.class)
    })

    @RequestMapping(value = "address/{studentId}",method = RequestMethod.DELETE)
    public AjaxResp delete( @PathVariable Long studentId){
        studentService.delete(studentId);
        return new AjaxResp(AjaxResp.SUCCESS,"删除成功");
    }
}
