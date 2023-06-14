package cn.edu.cqut.crmservice.controller;

import cn.edu.cqut.crmservice.entity.Orders;
import cn.edu.cqut.crmservice.entity.Report;
import cn.edu.cqut.crmservice.service.ICustomerService;
import cn.edu.cqut.crmservice.util.ReportResult;
import cn.edu.cqut.crmservice.util.TableResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController  //给前端返回json数据
@RequestMapping("/report")
@CrossOrigin //允许跨域请求
public class ReportController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/getCustomerContribution")
    public ReportResult getCustomerContribution(){
        List<Report> reports = customerService.getCustomerContribution();
        return getReportResult(reports);
    }

//    @GetMapping("/getContributionInfo")
//    public TableResult<Map<Integer, Integer>> getContributionInfo(Timestamp lastTime) {
//        Map<Integer, Integer> reports = customerService.getContributionInfo(lastTime);
//        QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
//        queryWrapper.lt("odr_time", reports ); // 查找 ord_time 小于指定时间的数据
//        queryWrapper.select("odr_id", "odr_amount");//查找id信息和金额数据
//        return getReportResult(reports);
//    }


    @GetMapping("/getCustomerCountByLevel")
    public ReportResult getCustomerCountByLevel(){
        List<Report> reports = customerService.getCustomerCountByLevel();
        return getReportResult(reports);
    }

    @GetMapping("/getCustomerServices")
    public ReportResult getCustomerServices(){
        List<Report> reports = customerService.getCustomerServices();
        return getReportResult(reports);
    }

    private ReportResult getReportResult(List<Report> reports) {
        List<String> items = new ArrayList<>();
        List<Long> values = new ArrayList<>();
        for (Report report : reports) {
            items.add(report.getItem());
            values.add(report.getValue());
        }
        return ReportResult.ok(items, values);
    }

}
