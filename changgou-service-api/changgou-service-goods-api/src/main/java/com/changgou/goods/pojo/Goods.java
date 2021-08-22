package com.changgou.goods.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * package name: com.changgou.goods.pojo
 *
 * @author zmc
 * Date: 2021/8/22
 */
public class Goods implements Serializable {
    private Spu spu;
    private List<Sku> skuList;

    @Override
    public String toString() {
        return "Goods{" +
                "spu=" + spu +
                ", skuList=" + skuList +
                '}';
    }

    public Spu getSpu() {
        return spu;
    }

    public void setSpu(Spu spu) {
        this.spu = spu;
    }

    public List<Sku> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<Sku> skuList) {
        this.skuList = skuList;
    }

    public Goods() {
    }

    public Goods(Spu spu, List<Sku> skuList) {
        this.spu = spu;
        this.skuList = skuList;
    }
}
