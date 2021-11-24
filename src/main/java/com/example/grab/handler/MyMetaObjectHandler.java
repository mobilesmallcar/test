package com.example.grab.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author:xsy
 * @Date:2021-11-24
 * dev上的修改，我故意再main分支修改
 */
@Slf4j
@Component      //一定不要忘记把处理器加到IOC容器中
public class MyMetaObjectHandler implements MetaObjectHandler {
    //插入时的填充策略
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill....");
        this.setFieldValByName("deleted",1,metaObject);
//        this.setFieldValByName("updateTime",new Date(),metaObject);

    }
    //更新时的填充策略
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill....");
//        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
