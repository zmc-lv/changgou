package com.changgou.goods.service;

import com.changgou.core.service.CoreService;
import com.changgou.goods.pojo.Category;

import java.util.List;

/****
 * @Author:admin
 * @Description:Category业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface CategoryService extends CoreService<Category> {

    /**
     * 根据分类id 获取该分类下的直接子分类列表 当ID为0的时候表示获取一级分类列表
     * @param pid
     * @return
     */
    List<Category> findByParentId(Integer pid);
}
