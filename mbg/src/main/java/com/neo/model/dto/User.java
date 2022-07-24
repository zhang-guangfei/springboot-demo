package com.neo.model.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangguangfei
 * @since 2022-07-24
 */
@Getter
@Setter
@TableName("user")
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户名")
    @TableField("username")
    private String username;

    @ApiModelProperty("密码")
    @TableField("password")
    private String password;

    @ApiModelProperty("姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty("年龄")
    @TableField("age")
    private Integer age;

    @ApiModelProperty("性别")
    @TableField("sex")
    private Integer sex;

    @ApiModelProperty("地址")
    @TableField("address")
    private String address;

    @ApiModelProperty("生日")
    @TableField("birthday")
    private String birthday;

    @ApiModelProperty("删除")
    @TableField("delete_flag")
    @TableLogic
    private String deleteFlag;

    @ApiModelProperty("乐观锁")
    @TableField("version")
    @Version
    private String version;

    @ApiModelProperty("创建日期")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新日期")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty("创建人")
    @TableField("creator")
    private String creator;

    @ApiModelProperty("更新人")
    @TableField("updater")
    private String updater;


}
