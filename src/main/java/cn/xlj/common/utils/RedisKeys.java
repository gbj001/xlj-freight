package cn.xlj.common.utils;

/**
 * Redis所有Keys
 *
* @author gengbeijun
 * @email gengbeijun@xinliangjishipin.com
 * @date 2017-07-18 19:51
 */
public class RedisKeys {

    public static String getSysConfigKey(String key){
        return "sys:config:" + key;
    }

    public static String getShiroSessionKey(String key){
        return "sessionid:" + key;
    }
}
