package com.example.grab.entity.copy;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel
@Data
public class WareRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增主键")
    @TableId(type= IdType.AUTO)
    private Integer id;

    private Integer expertId;
    private Integer companyId;
    private String name;
    private String mobile;
    private String expertNo;
    private String projectNo;
    private String projectName;
}
