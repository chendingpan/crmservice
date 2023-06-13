package cn.edu.cqut.crmservice.controller;

import cn.edu.cqut.crmservice.entity.SysUser;
import cn.edu.cqut.crmservice.service.ISysUserService;
import cn.edu.cqut.crmservice.util.Auth;
import cn.edu.cqut.crmservice.util.JWTUtill;
import cn.edu.cqut.crmservice.util.TableResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CQUT
 * @since 2023-06-09
 */
@RestController
@RequestMapping("/sysUser")
@CrossOrigin
public class SysUserController {
    @Autowired  //自动从spring容器中获取对象给变量赋值
    private ISysUserService userService;
    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private JWTUtill jwtUtill;

    //    @PostMapping  post方法接收
    @GetMapping("/getSysUserPage")
    public TableResult<SysUser> getSysUserList(Integer limit, Integer page, SysUser sysUser){
//        // 创建 QueryWrapper 对象，设置查询条件
//        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("cus_name", cusName);
        QueryWrapper<SysUser> wrapper;
        if (sysUser.getUserName() != null) {
            wrapper = new QueryWrapper<>();
            wrapper.like("user_name", sysUser.getUserName());
        }else {
            wrapper  = new QueryWrapper<>(sysUser);
        }


        Page<SysUser> sysUserPage = new Page<>(page, limit);
        Page<SysUser> page1 = userService.page(sysUserPage,wrapper);//调用service层的page方法，返回分页
        return TableResult.ok("查询成功", page1.getTotal(), page1.getRecords());
    }

    @PostMapping("/updateSysUser")
    public TableResult<SysUser> updateSysUser(SysUser sysUser){
        userService.updateById(sysUser);
        return TableResult.ok("修改用户信息成功");
    }

    @PostMapping("/addSysUser")
    public TableResult<SysUser> addSysUser(SysUser sysUser){
        userService.save(sysUser);
        return TableResult.ok("新增用户信息成功");
    }

    @PostMapping("/deleteSysUser")
    public TableResult<SysUser> deleteSysUser(Integer[] ids){//参数名要跟前端ajax方法data参数里面的属性名一致
        userService.removeByIds(Arrays.asList(ids)); //asList()把数组转list
        return TableResult.ok("删除用户信息成功");
    }

    @PostMapping("/checkName")
    public boolean checkName(SysUser sysUser) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>(sysUser);
        SysUser user = userService.getOne(wrapper);
        return user == null;
    }

    @PostMapping("/login")
    public TableResult<SysUser> login(SysUser sysUser) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>(sysUser);
        SysUser user = userService.getOne(wrapper);
        if (user != null) {
            if (user.getUserState() == 0) {
                String token = jwtUtill.createJwt(user);  //生成token
                return TableResult.ok(token, user);
            }
            return TableResult.error(1, "此用已被禁用");
        } else {
            return TableResult.error(1, "用户名或密码错误");
        }
    }

    @Auth(roles = "2")
    @PostMapping("/updateUserState")
    public TableResult<SysUser> updateUserState(SysUser sysUser){
        UpdateWrapper<SysUser> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.set("user_state", sysUser.getUserState());
        userUpdateWrapper.eq("user_id", sysUser.getUserId());
        userService.update(userUpdateWrapper);
        return TableResult.ok("修改用户状态成功");
    }

    @PostMapping("/getAllSysUser")
    public List<SysUser> getAllSysUser() {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("role_id", "1").select("user_id", "user_name");
        return sysUserService.list(wrapper);
    }
}
