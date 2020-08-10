package com.example.chong.activity_write.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.chong.activity_write.entity.PetCircleComment;
import com.example.chong.activity_write.mapper.PetCircleCommentMapper;
import com.example.chong.activity_write.service.IPetCircleCommentService;
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
public class PetCircleCommentServiceImpl extends ServiceImpl<PetCircleCommentMapper, PetCircleComment> implements IPetCircleCommentService {

    @Autowired
    PetCircleCommentMapper petCircleCommentMapper;

    @Override
    public Page<PetCircleComment> getPetCircleComService(Integer pageNo, Integer pageSize) {
        Page<PetCircleComment> petCircleCommentPage = petCircleCommentMapper.selectPage(new Page<>(pageNo, pageSize),null);
        return petCircleCommentPage;
    }
}
