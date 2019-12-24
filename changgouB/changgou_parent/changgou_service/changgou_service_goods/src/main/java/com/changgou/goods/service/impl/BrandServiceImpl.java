package com.changgou.goods.service.impl;

import com.changgou.goods.dao.BrandMapper;
import com.changgou.goods.pojo.Brand;
import com.changgou.goods.service.BrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @ClassName BrandServiceImpl
 * @Description TODO
 * @Author Bridge
 * @Date 2019/12/24 16:31
 * @Version 1.0
 **/

@Service
@Transactional
public class BrandServiceImpl implements BrandService {

    @Autowired(required = false)
    private BrandMapper brandMapper;


    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(Brand brand) {
        brandMapper.insertSelective(brand);
        int i = 1 / 0;
    }

    @Override
    public void deleteById(Integer integer) {
        brandMapper.deleteByPrimaryKey(integer);
    }

    @Override
    public List<Brand> findByCondition(Brand brand) {
        Example example = createExample(brand);
        List<Brand> brandList = brandMapper.selectByExample(example);
        return brandList;
    }

    @Override
    public PageInfo<Brand> findPageByCondition(Brand brand, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<Brand> brandList = findByCondition(brand);
        PageInfo<Brand> pageInfo = new PageInfo<>(brandList);

        return pageInfo;
    }


    public Example createExample(Brand brand) {
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(brand.getId())) {
            criteria.andEqualTo("id", brand.getId());
        }

        if (!StringUtils.isEmpty(brand.getName())) {
            criteria.andLike("name", "%" + brand.getName() + "%");
        }

        // 品牌图片地址
        if (!StringUtils.isEmpty(brand.getImage())) {
            criteria.andLike("image", "%" + brand.getImage() + "%");
        }
        // 品牌的首字母
        if (!StringUtils.isEmpty(brand.getLetter())) {
            criteria.andLike("letter", "%" + brand.getLetter() + "%");
        }

        // 排序
        if (!StringUtils.isEmpty(brand.getSeq())) {
            criteria.andEqualTo("seq", brand.getSeq());
        }

        return example;

    }
}

    
    