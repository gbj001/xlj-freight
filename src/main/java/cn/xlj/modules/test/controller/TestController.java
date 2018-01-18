package cn.xlj.modules.test.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.xlj.common.utils.PageUtils;
import cn.xlj.common.utils.Query;
import cn.xlj.common.utils.R;
import cn.xlj.modules.sys.entity.SysUserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.xlj.modules.test.entity.TestEntity;
import cn.xlj.modules.test.service.TestService;


/**
 * @author gengbeijun
 * @email gengbeijun@xinliangjishipin.com
 * @date 2018-01-12 13:27:38
 */
@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    private TestService testService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("test:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<TestEntity> testList = testService.queryList(query);
        int total = testService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(testList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("test:info")
    public R info(@PathVariable("id") Integer id) {
        TestEntity test = testService.queryObject(id);

        return R.ok().put("test", test);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("test:save")
    public R save(@RequestBody TestEntity test) {
        test.setCreatedTime(new Date());
        test.setCreatedUser("system");
        String username = ((SysUserEntity) SecurityUtils.getSubject().getPrincipal()).getUsername();
        test.setUpdatedUser(username);
        test.setUpdatedTime(new Date());
        testService.save(test);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("test:update")
    public R update(@RequestBody TestEntity test) {
        test.setUpdatedTime(new Date());
        testService.update(test);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("test:delete")
    public R delete(@RequestBody Integer[] ids) {
        testService.deleteBatch(ids);

        return R.ok();
    }

}
