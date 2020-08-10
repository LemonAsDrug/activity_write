package com.example.chong.activity_write.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.chong.activity_write.entity.SeekPet;
import com.example.chong.activity_write.mapper.SeekPetMapper;
import com.example.chong.activity_write.service.ISeekPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 寻宠表 服务实现类
 * </p>
 *
 * @author wucunyang
 * @since 2020-07-14
 */
@Service
public class SeekPetServiceImpl extends ServiceImpl<SeekPetMapper, SeekPet> implements ISeekPetService {

    @Autowired
    SeekPetMapper seekPetMapper;


    @Override
    public SeekPet getSeekPetById(Long id) {
        SeekPet seekPetById = seekPetMapper.getSeekPetById(id);
        return seekPetById;
    }

    @Override
    public SeekPet getSeekPetByIdAnnoByService(Long id) {
        SeekPet seekPetByIdAnno = seekPetMapper.getSeekPetByIdAnno(id);
        return seekPetByIdAnno;
    }

    @Override
    public void insertSeekPetByService(SeekPet seekPet) {
        seekPetMapper.insertSeekPet(seekPet);
    }

    @Override
    public void updateSeekPetByIdByService(SeekPet seekPet) {
        seekPetMapper.updateSeekPetById(seekPet);
    }

    @Override
    public void deleteSeekPetByIdByService(Long id) {
        seekPetMapper.deleteSeekPetById(id);
    }

    @Override
    public List<SeekPet> getSeekPets() {
        System.out.println("1");
        List<SeekPet> seekPetList = seekPetMapper.getSeekPetList();
        System.out.println(seekPetList);
        System.out.println("2");
        return seekPetList;
    }
}
