package com.example.chong.activity_write.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;

@Data
public abstract class BaseEntity implements Serializable {
    private static final long serialVersionUID = 9999999L;

    public BaseEntity(){
        this.initCreateData();
    }

    /*
     * 主键
     * */
    @TableId(value="id", type= IdType.AUTO)
    protected Long id;


    /**
     * 0禁用 1正常
     */
    @TableLogic
    protected Byte status;

    /**
     * 创建时间
     */
    protected Long createTime;

    /**
     * 不用再手动调用，BaseEntity无参构造方法默认调用了。
     * 所有继承了BaseEntity类的实体类，可以不用再调用这个方法。
     */
    public void initCreateData(){
        this.createTime = System.currentTimeMillis();
        this.status = new Byte("1");
    }

}
