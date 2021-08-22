package com.changgou.goods.dao;
import com.changgou.goods.pojo.Category;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/****
 * @Author:admin
 * @Description:CategoryDao
 * @Date 2019/6/14 0:12
 *****/
public interface CategoryMapper extends Mapper<Category> {
    /**
     * 根据分类id 获取该分类下的直接子分类列表 当ID为0的时候表示获取一级分类列表
     * @param pid
     * @return
     */
    @Select(value = "select * from tb_category where parent_id = #{pid}")
    List<Category> findByParentId(Integer pid);
}
