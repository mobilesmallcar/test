package com.example.grab.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class RelationSaveVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer expertId;
    private Integer companyId;


}
