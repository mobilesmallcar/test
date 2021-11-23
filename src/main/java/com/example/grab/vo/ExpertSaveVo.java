package com.example.grab.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@ApiModel
@Data
public class ExpertSaveVo implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private String expertNo;
    private String mobile;
    private String projectNo;

}
