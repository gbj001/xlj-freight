package cn.xlj.modules.sys.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

/**
 * Shiro运费标签
 * 
* @author gengbeijun
 * @email gengbeijun@xinliangjishipin.com
 * @date 2016年12月3日 下午11:32:47
 */
@Component
public class ShiroTag {

	/**
	 * 是否拥有该运费
	 * @param permission  运费标识
	 * @return   true：是     false：否
	 */
	public boolean hasPermission(String permission) {
		Subject subject = SecurityUtils.getSubject();
		return subject != null && subject.isPermitted(permission);
	}

}
