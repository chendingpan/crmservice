package cn.edu.cqut.crmservice.service;

import cn.edu.cqut.crmservice.entity.Customer;
import cn.edu.cqut.crmservice.entity.Report;
import com.baomidou.mybatisplus.extension.service.IService;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CQUT
 * @since 2023-06-09
 */
public interface ICustomerService extends IService<Customer> {

    public List<Report> getCustomerContribution();


    public List<Report> getCustomerCountByLevel();


    public List<Report> getCustomerServices();

//    Map<Integer, Integer> getContributionInfo(Timestamp lastTime);
}
