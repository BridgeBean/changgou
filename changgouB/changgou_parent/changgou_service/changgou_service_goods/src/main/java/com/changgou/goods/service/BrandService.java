package com.changgou.goods.service;

import com.changgou.goods.pojo.Brand;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @InterfaceName BrandService
 * @Description TODO
 * @Author Bridge
 * @Date 2019/12/24 16:31
 * @Version 1.0
 **/

public interface BrandService {

    List<Brand> findAll();

    Brand findById(Integer id);

    void add(Brand brand);

    void deleteById(Integer integer);

    List<Brand> findByCondition(Brand brand);

    PageInfo<Brand> findPageByCondition(Brand brand, Integer page, Integer size);
}
