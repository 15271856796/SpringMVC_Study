package cn.hdl.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*idea可以设置自动导包,但是当有多个同名的包的时候,需要我们手动导入,快捷键Alt Enter*/
public class StringToDate implements Converter<String, Date> {

    @Override
    public Date convert(String s) {
        if(s == null){
            throw new RuntimeException("请您传入数据");
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {          /*先选中需要加在try里面的代码 然后Ctrl Alt t  try - catch的快捷键是 Ctrl Alt t */
            return df.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException("类型转换失败");
        }
    }
}
