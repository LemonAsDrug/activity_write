package com.example.chong.activity_write.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.chong.activity_write.entity.PetCircle;
import com.example.chong.activity_write.enums.PetCircleStaticKey;
import com.example.chong.activity_write.mapper.PetCircleMapper;
import com.example.chong.activity_write.service.IPetCircleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * <p>
 * 宠圈帖子表 服务实现类
 * </p>
 *
 * @author wucunyang
 * @since 2020-06-28
 */
@Service
@SuppressWarnings("all")
public class PetCircleServiceImpl extends ServiceImpl<PetCircleMapper, PetCircle> implements IPetCircleService {

    @Autowired
    PetCircleMapper petCircleMapper;

    @Override
    public Integer setChosen(Long activityId, Long petCircleId) {
        QueryWrapper<PetCircle> petCircleQueryWrapper = new QueryWrapper<>();
        petCircleQueryWrapper.eq("id",petCircleId);
        petCircleQueryWrapper.eq("biz_id",activityId);
        PetCircle petCircle = petCircleMapper.selectOne(petCircleQueryWrapper);
        if (petCircle.getChosen().equals(PetCircleStaticKey.IS_CHOSEN)){
            petCircle.setChosen(PetCircleStaticKey.NOT_CHOSEN);
        }else if(petCircle.getChosen().equals(PetCircleStaticKey.NOT_CHOSEN)){
            petCircle.setChosen(PetCircleStaticKey.IS_CHOSEN);
        }else{
            System.out.println("记录值和常量值不相同！");
        }
        petCircleMapper.updateById(petCircle);
        return petCircle.getChosen();
    }

    @Override
    public Page<PetCircle> getPetCircleList(Integer pageNo,Integer pageSize,Long activityId) {
        QueryWrapper<PetCircle> petCircleQueryWrapper = new QueryWrapper<>();
        petCircleQueryWrapper.eq("biz_type",PetCircleStaticKey.BIZ_TYPE);
        petCircleQueryWrapper.eq("biz_id",activityId);
        Page<PetCircle> petCirclePage = petCircleMapper.selectPage(new Page<>(pageNo, pageSize), petCircleQueryWrapper);
        return petCirclePage;
    }

    @Override
    public Page<PetCircle> getPetCirclrList(Integer pageNo, Integer pageSize) {
        Page<PetCircle> petCirclePage = petCircleMapper.selectPage(new Page<>(pageNo, pageSize), null);
        return petCirclePage;
    }


}
