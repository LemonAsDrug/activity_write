package com.example.chong.activity_write.entity;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

@Data
public class PageDto{

    private Long current;

    private Long size;

    private Long total;

    //Page对象中没有pages属性
    //Page<PetCircle> petCirclePage = petCircleMapper.selectPage(new Page<>(pageNo, pageSize), petCircleQueryWrapper);
    //中，点进Page,  public class Page<T> implements IPage<T> {
    //泛型PetCircle实现了IPage接口，接口中写了getPages()方法。
    //所以BeanUtils.copyProperties(petCirclelist, pageDto);
    //pages属性可以复制成功。
   private Long pages;

}
