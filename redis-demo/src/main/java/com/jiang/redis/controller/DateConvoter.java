package com.jiang.redis.controller;

import org.springframework.core.convert.converter.Converter;

import java.util.Date;

/**
 * Description:
 *
 * @author jiujiang
 * @date 2019/5/10
 */
public class DateConvoter implements Converter<Date,String> {
    @Override
    public String convert(Date date) {
        return null;
    }
}
