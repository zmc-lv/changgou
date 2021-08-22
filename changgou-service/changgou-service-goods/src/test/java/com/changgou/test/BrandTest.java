package com.changgou.test;


import com.changgou.goods.dao.BrandMapper;
import com.changgou.goods.pojo.Brand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * package name: com.changgou.test
 *
 * @author zmc
 * Date: 2021/8/18
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BrandTest {
    @Autowired
    private BrandMapper brandMapper;

    @Test
    public void findAll(){
        List<Brand> brands = brandMapper.selectAll();
        for (Brand brand : brands) {
            System.out.println(brand.getName());
        }
    }

}
