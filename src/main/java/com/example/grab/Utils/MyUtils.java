package com.example.grab.Utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.grab.vo.Response.ResultDTO;

import java.util.List;

public class MyUtils {
    public static <E> ResultDTO<List<E>> getResultDTO(IPage<E> page) {
        ResultDTO<List<E>> res = new ResultDTO<>();
        res.setCode(0);
        res.setCount(page.getTotal());
        res.setData(page.getRecords());
        return res;
    }

    public static Boolean getBoolean(Integer i) {
        return i == 1 ? true : false;
    }

    public static ResultDTO getResponse(Integer i, String trueMsg, String falseMsg) {
        return getBoolean(i) ? buildTrue(trueMsg) : buildFalse(falseMsg);
    }

    public static ResultDTO buildFalse(String msg) {
        ResultDTO res = new ResultDTO();
        res.setMsg(msg);
        res.setCode(-1);
        res.setSuccess(false);
        return res;
    }

    public static ResultDTO buildTrue(String msg) {
        ResultDTO res = new ResultDTO();
        res.setMsg(msg);
        res.setCode(0);
        res.setSuccess(true);
        return res;
    }
}
