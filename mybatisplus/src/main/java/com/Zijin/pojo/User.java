package com.Zijin.pojo;

import com.Zijin.enums.SexEnum;
import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

@Data
//设置实体类所对应的表名
//@TableName("t_user")
public class User {
    @TableId(value="uid")
    //@TableId注解的value属性用于指定主键的字段
    //@TableId注解的type属性设置主键生成策略
    private Long id;
    @TableField("user_name")
    private String name;
    private Integer age;
    private String email;
    @TableLogic
    private Integer isDeleted;
    private SexEnum sex;

}
