package com.dxk.kite.utils;


import org.apache.commons.collections.CollectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hzdengxuekai
 */
public class BeanUtil {

    /**
     * 对象转换成map (转换结果不包含继承父类的属性)
     *
     * @param obj
     * @return
     * @throws Exception
     */
    public static Map<String, Object> beanToMap(Object obj) throws Exception {
        if (obj == null) {
            return null;
        }
        Field[] fields = obj.getClass().getDeclaredFields();
        Map<String, Object> map = new HashMap<>(fields.length);
        for (Field field : fields) {
            field.setAccessible(true);
            Object o = field.get(obj);
            if (o != null) {
                map.put(field.getName(), o);
            }
        }
        return map;
    }

    public static <T> List<Map<String, Object>> beanListToMapList(List<T> list) throws Exception {
        if (CollectionUtils.isEmpty(list)) {
            return new ArrayList<>();
        }
        List<Map<String, Object>> maps = new ArrayList<>(list.size());
        for (T tem : list) {
            maps.add(BeanUtil.beanToMap(tem));
        }
        return maps;
    }
}
