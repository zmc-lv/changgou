package com.changgou.goods.service.impl;

import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.goods.dao.CategoryMapper;
import com.changgou.goods.pojo.Category;
import com.changgou.goods.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.locks.Condition;

/****
 * @Author:admin
 * @Description:Category业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class CategoryServiceImpl extends CoreServiceImpl<Category> implements CategoryService {

    private CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryMapper categoryMapper) {
        super(categoryMapper, Category.class);
        this.categoryMapper = categoryMapper;
    }

    /**
     * 根据分类id 获取该分类下的直接子分类列表 当ID为0的时候表示获取一级分类列表
     * @param pid
     * @return
     */
    @Override
    public List<Category> findByParentId(Integer pid) {
/*        //根据条件来查询 select * from tb_category where parent id=0
        Category condition = new Category();
        //where parent_id = ?
        condition.setParentId(pid);

        List<Category> categoryList = categoryMapper.select(condition);
        return categoryList;*/

        return categoryMapper.findByParentId(pid);
    }
}
