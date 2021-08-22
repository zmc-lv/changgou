package com.changgou.goods.service;

import com.changgou.core.service.CoreService;
import com.changgou.goods.pojo.Para;

import java.util.List;

/****
 * @Author:admin
 * @Description:Para业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface ParaService extends CoreService<Para> {

    /**
     * 根据 三级分类的id 获取参数的列表
     * @param id
     * @return
     */
    List<Para> findByCategoryId(Integer id);
}
