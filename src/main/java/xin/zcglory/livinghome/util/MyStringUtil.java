package xin.zcglory.livinghome.util;

import org.thymeleaf.util.StringUtils;

import java.util.logging.Logger;

/**
 * itw_zhichao
 * 字符串工具类
 */
public class MyStringUtil {

    /**
     * 校验多个字符串是否为空或""
     * @param parameters 字符串数组
     * @return 若有一个或多个为null则返回false，否则返回true
     */
    public static boolean checkStringIsNull(String... parameters) {
        int count = 0;
        //遍历字符串数组的参数，若发现某个参数为null或""，则跳出

        for (String parameter : parameters) {
            if (StringUtils.isEmpty(parameter)) {
                return false;
            }
            count++;
        }
        if (count == parameters.length) {
            return true;
        }
        return false;
    }

}
