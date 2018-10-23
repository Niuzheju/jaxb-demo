package com.niuzj.model;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期转换适配器
 */
public class DateAdapter extends XmlAdapter<String, Long> {

    private DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @Override
    public Long unmarshal(String v) throws Exception {
        return format.parse(v).getTime();
    }

    @Override
    public String marshal(Long v) throws Exception {
        return format.format(new Date(v));
    }
}
