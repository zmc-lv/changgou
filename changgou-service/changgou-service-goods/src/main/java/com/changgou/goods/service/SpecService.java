package com.changgou.goods.service;

import com.changgou.core.service.CoreService;
import com.changgou.goods.pojo.Spec;

import java.util.List;

/****
 * @Author:admin
 * @Description:Spec业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface SpecService extends CoreService<Spec> {

    /**
     * 根据 三级分类的id 获取规格的列表
     * @param id
     * @return
     */
    List<Spec> findByCategoryId(Integer id);
}
