package com.example.chong.activity_write.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.chong.activity_write.entity.SeekPet;

import java.util.List;

/**
 * <p>
 * 寻宠表 服务类
 * </p>
 *
 * @author wucunyang
 * @since 2020-07-14
 */
public interface ISeekPetService extends IService<SeekPet> {


    /**
     * xml测试根据id查询
     * @param id
     * @return
     */
    SeekPet getSeekPetById(Long id);

    /**
     * 注解测试查询
     * @param id
     * @return
     */
    SeekPet getSeekPetByIdAnnoByService(Long id);

    /**
     * xml测试插入 实体类作为参数
     */
    void insertSeekPetByService(SeekPet seekPet);

    /**
     * xml测试修改 实体类作为参数
     * @param seekPet
     */
    void updateSeekPetByIdByService(SeekPet seekPet);

    void deleteSeekPetByIdByService(Long id);

    List<SeekPet> getSeekPets();
}
