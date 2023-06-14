package cn.edu.cqut.crmservice.controller;

import cn.edu.cqut.crmservice.entity.SaleChance;
import cn.edu.cqut.crmservice.service.ISaleChanceService;
import cn.edu.cqut.crmservice.util.TableResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * <p>
 *  前端控制器
 * </p>
 * @author CQUT
 * @since 2023-06-11
 */
@RestController
@CrossOrigin
@RequestMapping("/saleChance")
public class SaleChanceController {
    @Autowired
    private ISaleChanceService saleChanceService;

    @GetMapping("/getSaleChanceList")
    public TableResult<SaleChance> getSaleChanceList(Integer limit, Integer page){
        Page<SaleChance> saleChancePage = new Page<>(page, limit);
        Page<SaleChance> page1 = saleChanceService.page(saleChancePage);
        return TableResult.ok("查询成功", page1.getTotal(), page1.getRecords());
    }

    @PostMapping("/updateSaleChance")
    public TableResult<SaleChance> updateSaleChance(SaleChance saleChance){
        saleChanceService.updateById(saleChance);
        return TableResult.ok("销售机会修改成功");
    }

    @PostMapping("/addSaleChance")
    public TableResult<SaleChance> addSaleChance(SaleChance saleChance,String scCreator){
//        saleChance.setScCreator(scCreator);
        saleChance.setScCreationTime(LocalDateTime.now()); //获取系统时间填入创建时间
        saleChance.setScStatus(1);
        saleChanceService.save(saleChance);
        return TableResult.ok("销售机会新增成功");
    }

    @PostMapping("/deleteSaleChance")
    public TableResult<SaleChance> deleteSaleChance(Integer[] ids) {
        saleChanceService.removeBatchByIds(Arrays.asList(ids));
        return TableResult.ok("删除成功");
    }

    @PostMapping("/assignSaleChance")
    public TableResult<SaleChance> assignSaleChance(SaleChance saleChance){
        saleChance.setScAssignTime(LocalDateTime.now()); //获取系统时间填入分配时间
        saleChance.setScStatus(2);
        saleChanceService.updateById(saleChance);
        return TableResult.ok("销售机会分配成功");
    }

}
