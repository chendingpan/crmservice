package cn.edu.cqut.crmservice.controller;

import cn.edu.cqut.crmservice.entity.Orders;
import cn.edu.cqut.crmservice.service.IOrdersService;
import cn.edu.cqut.crmservice.util.TableResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CQUT
 * @since 2023-06-13
 */
@RestController
@RequestMapping("/orders")
@CrossOrigin
public class OrdersController {

    @Autowired
    private IOrdersService ordersService;

    @GetMapping("/getOrdersList")
    public TableResult<Orders> getOrdersList(Integer limit, Integer page){
        Page<Orders> ordersPage = new Page<>(page, limit);
        Page<Orders> page1 = ordersService.page(ordersPage);
        return TableResult.ok("查询成功", page1.getTotal(), page1.getRecords());
    }

    @GetMapping("getIdOrdersPage")
    public TableResult<Orders> getIdContactPage(Integer page, Integer limit, Orders orders){
        QueryWrapper<Orders> wrapper;
        IPage<Orders> ordersIPage;
        wrapper = new QueryWrapper<>();
        if (orders.getCusId() != null) {
            //条件查询
            wrapper.eq("odr_id", orders.getOdrId()); //第一个参数是字段名
            Page<Orders> page1 = new Page<>(page, limit);
            ordersIPage = ordersService.myPage(page1, wrapper);
        }
        else {
            Page<Orders> page1 = new Page<>(page, limit);
            ordersIPage = ordersService.myPage(page1, wrapper);
        }

        return TableResult.ok("查询成功",ordersIPage.getTotal(),ordersIPage.getRecords());
    }
}
