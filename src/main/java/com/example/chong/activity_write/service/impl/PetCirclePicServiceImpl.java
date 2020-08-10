package com.example.chong.activity_write.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.chong.activity_write.entity.PetCirclePic;
import com.example.chong.activity_write.mapper.PetCirclePicMapper;
import com.example.chong.activity_write.service.IPetCirclePicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wucunyang
 * @since 2020-06-28
 */
@Service
public class PetCirclePicServiceImpl extends ServiceImpl<PetCirclePicMapper, PetCirclePic> implements IPetCirclePicService {

    @Autowired
    PetCirclePicMapper petCirclePicMapper;

    @Override
    public Page<PetCirclePic> getPetCirclePicList(Integer pageNo, Integer pageSize) {
        Page<PetCirclePic> petCirclePage = petCirclePicMapper.selectPage(new Page<>(pageNo, pageSize), null);
        return petCirclePage;
    }

}
