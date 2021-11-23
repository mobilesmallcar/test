package com.example.grab.vo.Response;

import com.example.grab.entity.Expert;
import lombok.Data;

@Data
public class ExpertResponse extends Expert {
    private String projectName;
}
