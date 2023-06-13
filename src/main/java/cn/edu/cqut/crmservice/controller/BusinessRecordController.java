package cn.edu.cqut.crmservice.controller;

import cn.edu.cqut.crmservice.entity.BusinessRecord;
import cn.edu.cqut.crmservice.service.IBusinessRecordService;
import cn.edu.cqut.crmservice.util.TableResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CQUT
 * @since 2023-06-09
 */
@RestController
@RequestMapping("/businessRecord")
@CrossOrigin
public class BusinessRecordController {
    @Autowired
    private IBusinessRecordService businessRecordService;

    @GetMapping("getBusinessRecordList")
    public TableResult<BusinessRecord> getBusinessRecordList(Integer page, Integer limit,BusinessRecord businessRecord){
        QueryWrapper<BusinessRecord> wrapper;
        Page<BusinessRecord> businessRecordPage;

        if (businessRecord.getConRecordId() != null) {
            //条件查询
            wrapper = new QueryWrapper<>();
            wrapper.eq("con_record_id", businessRecord.getConRecordId()); //第一个参数是字段名
            Page<BusinessRecord> page1 = new Page<>(page, limit);
            businessRecordPage = businessRecordService.page(page1, wrapper);
        }
        else {
            Page<BusinessRecord> page1 = new Page<>(page, limit);
            businessRecordPage = businessRecordService.page(page1);
        }

        return TableResult.ok("查询客户交往记录成功",businessRecordPage.getTotal(),businessRecordPage.getRecords());
    }

    @PostMapping("/updateBusinessRecord")
    public TableResult<BusinessRecord> updateBusinessRecord(BusinessRecord businessRecord){
        businessRecordService.updateById(businessRecord);
        return TableResult.ok("修改客户交往记录信息成功");
    }

    @PostMapping("/addBusinessRecord")
    public TableResult<BusinessRecord> addBusinessRecord(BusinessRecord businessRecord){
        businessRecordService.save(businessRecord);
        return TableResult.ok("新增客户交往记录信息成功");
    }

    @PostMapping("/deleteBusinessRecord")
    public TableResult<BusinessRecord> deleteBusinessRecord(Integer[] ids){//参数名要跟前端ajax方法data参数里面的属性名一致
        businessRecordService.removeByIds(Arrays.asList(ids)); //asList()把数组转list
        return TableResult.ok("删除客户交往记录信息成功");
    }
}
