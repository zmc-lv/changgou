package com.changgou.goods.controller;

import com.changgou.core.AbstractCoreController;
import com.changgou.goods.pojo.Para;
import com.changgou.goods.pojo.Spec;
import com.changgou.goods.service.ParaService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:admin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@RestController
@RequestMapping("/para")
@CrossOrigin
public class ParaController extends AbstractCoreController<Para>{

    private ParaService  paraService;

    @Autowired
    public ParaController(ParaService  paraService) {
        super(paraService, Para.class);
        this.paraService = paraService;
    }

    /**
     * 根据 三级分类的id 获取参数的列表
     * @param id
     * @return
     */
    @GetMapping("/category/{id}")
    public Result<List<Para>> findByCategoryId(@PathVariable("id") Integer id){
        List<Para> paraList = paraService.findByCategoryId(id);
        return Result.ok(paraList);
    }
}
