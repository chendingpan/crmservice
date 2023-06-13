package cn.edu.cqut.crmservice.controller;

import cn.edu.cqut.crmservice.entity.Services;
import cn.edu.cqut.crmservice.service.IServicesService;
import cn.edu.cqut.crmservice.util.TableResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author BigSea
 * @since 2023-06-08
 */
@CrossOrigin
@RestController
@RequestMapping("/services")
public class ServicesController {

    @Autowired
    private IServicesService servicesService;

    @GetMapping("/getServicesList")
    public TableResult<Services> getServicesList(Integer page,Integer limit){
        Page<Services> servicesPage = new Page<>(page,limit);
        Page<Services> page1 = servicesService.page(servicesPage);

        return TableResult.ok("查询成功",page1.getTotal(),page1.getRecords());
    }

    @PostMapping("/updateServices")
    public TableResult<Services> updateServices(Services services){
        servicesService.updateById(services);
        return TableResult.ok("修改服务信息成功");
    }
    @PostMapping("/addServices")
    public TableResult<Services> addServices(Services services){
        servicesService.save(services);
        return TableResult.ok("增加服务信息成功");
    }

    @PostMapping("/delServices")
    public TableResult<Services> delServices(Integer[] ids){
        servicesService.removeByIds(Arrays.asList(ids));

        return TableResult.ok("删除服务信息成功");

    }
}
