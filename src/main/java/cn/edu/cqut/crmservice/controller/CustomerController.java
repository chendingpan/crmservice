package cn.edu.cqut.crmservice.controller;

import cn.edu.cqut.crmservice.entity.Customer;
import cn.edu.cqut.crmservice.service.ICustomerService;
import cn.edu.cqut.crmservice.util.TableResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CQUT
 * @since 2023-06-06
 */
@RestController  //给前端返回json数据
@RequestMapping("/customer")
@CrossOrigin //允许跨域请求
public class CustomerController {
    @Autowired  //自动从spring容器中获取对象给变量赋值
    private ICustomerService customerService;

    @GetMapping("/getCustomerList")
    public TableResult<Customer> getCustomerList(Integer limit, Integer page, HttpServletRequest request){
        System.out.println(request.getAttribute("userId"));
        System.out.println(request.getAttribute("userName"));
        System.out.println(request.getAttribute("userRole"));
        Page<Customer> customerPage = new Page<>(page, limit);
        Page<Customer> page1 = customerService.page(customerPage);//调用service层的list方法，返回数据表的所有数据
        return TableResult.ok("查询成功", page1.getTotal(), page1.getRecords());
    }


    @PostMapping("/updateCustomer")
    public TableResult<Customer> updateCustomer(Customer customer){
        customerService.updateById(customer);
        return TableResult.ok("修改客户信息成功");
    }


    @PostMapping("/addCustomer")
    public TableResult<Customer> addCustomer(Customer customer){
     customerService.save(customer);
     return TableResult.ok("新增客户信息成功");
    }


    @PostMapping("/deleteCustomer")
    public TableResult<Customer> deleteCustomer(Integer[] ids){//参数名要跟前端ajax方法data参数里面的属性名一致
        customerService.removeByIds(Arrays.asList(ids)); //asList()把数组转list
        return TableResult.ok("删除客户信息成功");
    }



    @Scheduled(cron = "0 0 2 * * *")//秒 分 时 月份中的日期 月 年
    public void job(){
        System.out.println("===================" + System.currentTimeMillis());
    }

}
