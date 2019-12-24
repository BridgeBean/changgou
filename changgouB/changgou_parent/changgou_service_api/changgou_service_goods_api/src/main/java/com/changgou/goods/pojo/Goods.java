package com.changgou.goods.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 组合对象 组合1SPU和多个SKU
 *
 * @author ljh
 * @version 1.0
 * @package com.changgou.goods.pojo *
 * @Date 2019-11-25
 * @since 1.0
 */
public class Goods implements Serializable {
    private Spu spu;
    private List<Sku> skuList;

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
}
