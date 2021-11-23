package com.example.grab.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel
@Data
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    /**自增主键*/
    @ApiModelProperty(value = "自增主键")
    @TableId(type= IdType.AUTO)
    private Integer id;

    /**项目编号*/
    @ApiModelProperty(value = "项目编号")
    private String projectNo;

    /**项目名称*/
    @ApiModelProperty(value = "项目名称")
    private String projectName;

    /**项目包号*/
    @ApiModelProperty(value = "项目包号")
    private String projectPackage;

    /**项目所属级次*/
    @ApiModelProperty(value = "项目所属级次")
    private String projectBelong;

    /**代理机构*/
    @ApiModelProperty(value = "代理机构")
    private String agencyName;

    /**采购单位*/
    @ApiModelProperty(value = "采购单位")
    private String purchaseName;

    /**采购方式*/
    @ApiModelProperty(value = "采购方式")
    private String purchaseMethod;

    /**项目金额*/
    @ApiModelProperty(value = "项目金额")
    private BigDecimal totalPrice;

    /**评审开始时间*/
    @ApiModelProperty(value = "评审开始时间")
    private java.util.Date reviewTime;

    /**预计评审时长*/
    @ApiModelProperty(value = "预计评审时长")
    private Integer sustainTime;

    /**评审地域*/
    @ApiModelProperty(value = "评审地域")
    private String reviewRegion;

    /**需要专家人数*/
    @ApiModelProperty(value = "需要专家人数")
    private Integer specialists;

    /**仅抽取电子评审专家（1是，0否）*/
    @ApiModelProperty(value = "仅抽取电子评审专家（1是，0否）")
    private String flag;

    /**采购人督导*/
    @ApiModelProperty(value = "采购人督导")
    private String purchaseSupervisor;

    /**采购人督导手机*/
    @ApiModelProperty(value = "采购人督导手机")
    private String purchaseSupervisorPhone;

    /**采购人代表*/
    @ApiModelProperty(value = "采购人代表")
    private String purchaseRepresentative;

    /**采购人代表手机*/
    @ApiModelProperty(value = "采购人代表手机")
    private String purchaseRepresentPhone;

    /**代理机构联系人*/
    @ApiModelProperty(value = "代理机构联系人")
    private String agency;

    /**代理机构联系人手机*/
    @ApiModelProperty(value = "代理机构联系人手机")
    private String agencyPhone;

    /**评审地址*/
    @ApiModelProperty(value = "评审地址")
    private String reviewLocation;

    /**评审室*/
    @ApiModelProperty(value = "评审室")
    private String reviewHome;

    /**采购品目*/
    @ApiModelProperty(value = "采购品目")
    private String purchaseNames;

    /**评审能力关键字*/
    @ApiModelProperty(value = "评审能力关键字")
    private String keyword;

    /**备注信息*/
    @ApiModelProperty(value = "备注信息")
    private String remark;

    /**预留1*/
    @ApiModelProperty(value = "预留1")
    private String extend1;

    /**预留2*/
    @ApiModelProperty(value = "预留2")
    private String extend2;

    /**预留3*/
    @ApiModelProperty(value = "预留3")
    private String extend3;

    /**预留4*/
    @ApiModelProperty(value = "预留4")
    private String extend4;

    /**预留5*/
    @ApiModelProperty(value = "预留5")
    private String extend5;
}
