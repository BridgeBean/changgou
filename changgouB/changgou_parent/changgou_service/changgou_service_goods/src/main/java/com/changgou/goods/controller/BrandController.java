package com.changgou.goods.controller;

import com.changgou.goods.pojo.Brand;
import com.changgou.goods.service.BrandService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName BrandController
 * @Description TODO
 * @Author Bridge
 * @Date 2019/12/24 16:32
 * @Version 1.0
 **/
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    /***
     * @Description TODO  查询全部
     * @param
     * @return
     */
    @GetMapping
    public Result<List<Brand>> findAll() {
        List<Brand> brandList = brandService.findAll();
        return new Result<>(true, StatusCode.OK, "查询全部列表成功", brandList);
    }

    /**
     * @param id
     * @return
     * @Description TODO 根据id查询
     */
    @GetMapping("/{id}")
    public Result<Brand> findById(@PathVariable Integer id) {
        Brand brand = brandService.findById(id);
        return new Result<>(true, StatusCode.OK, "根据id查询成功", brand);
    }


    /**
     * @param brand
     * @return
     * @Description TODO 添加品牌
     */
    @PostMapping
    public Result add(@RequestBody Brand brand) {
        brandService.add(brand);
        return new Result(true, StatusCode.OK, "添加成功");
    }


    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable(name = "id") Integer integer) {
        brandService.deleteById(integer);
        return new Result(true, StatusCode.OK, "删除成功");
    }


    @PostMapping("/search")
    public Result<List<Brand>> findByCondition(@RequestBody Brand brand) {
        List<Brand> brandList = brandService.findByCondition(brand);
        return new Result<>(true, StatusCode.OK, "根据Brand查询成功", brandList);
    }


    @PostMapping("/search/{page}/{size}")
    public Result<PageInfo<Brand>> findPageByCondition(@RequestBody(required = false) Brand brand,
                                                       @PathVariable(name = "page") Integer page,
                                                       @PathVariable(name = "size") Integer size) {
        PageInfo<Brand> pageInfo = brandService.findPageByCondition(brand, page, size);
        return new Result<>(true, StatusCode.OK, "条件分页查询成功", pageInfo);
    }

}

    
    