package com.example.chong.activity_write.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.chong.activity_write.entity.SeekPet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 寻宠表 Mapper 接口
 * </p>
 *
 * @author wucunyang
 * @since 2020-07-14
 */
@Mapper
public interface SeekPetMapper extends BaseMapper<SeekPet> {

    int insert(@Param("seekPet")SeekPet seekPet);

    /**
     * xml测试查询，传递参数
     * @param id
     * @return
     */
    SeekPet getSeekPetById(@Param("idxml")Long id);

    /**
     * 使用注解
     * @param id
     * @return
     */
    @Select("select * from seek_pet where id = #{idAnno}")
    SeekPet getSeekPetByIdAnno(@Param("idAnno")Long id);

    /**
     * xml测试插入 实体类作为参数
     * @param seekPet
     */
    void insertSeekPet (SeekPet seekPet);

    /**
     * 测试修改
     * @param seekPet
     */
    void updateSeekPetById(SeekPet seekPet);

    /**
     * 测试删除
     * @param id
     */
    void deleteSeekPetById(@Param("deleteId")Long id);

    /**
     * 测试 xml写sql语句，返回泛型数组
     * @return
     */
    List<SeekPet> getSeekPetList();
}
