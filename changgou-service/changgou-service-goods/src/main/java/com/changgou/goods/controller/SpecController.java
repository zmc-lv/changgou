package com.changgou.goods.controller;

import com.changgou.core.AbstractCoreController;
import com.changgou.goods.pojo.Spec;
import com.changgou.goods.service.SpecService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:admin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@RestController
@RequestMapping("/spec")
@CrossOrigin
public class SpecController extends AbstractCoreController<Spec>{

    private SpecService  specService;

    @Autowired
    public SpecController(SpecService  specService) {
        super(specService, Spec.class);
        this.specService = specService;
    }

    /**
     * 根据 三级分类的id 获取规格的列表
     * @param id
     * @return
     */
    @GetMapping("/category/{id}")
    public Result<List<Spec>> findByCategoryId(@PathVariable("id") Integer id){
        List<Spec> specList = specService.findByCategoryId(id);
        return Result.ok(specList);
    }
}
