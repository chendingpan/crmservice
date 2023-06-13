package cn.edu.cqut.crmservice.service;

import cn.edu.cqut.crmservice.entity.Customer;
import cn.edu.cqut.crmservice.entity.Report;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CQUT
 * @since 2023-06-09
 */
public interface ICustomerService extends IService<Customer> {
    public List<Report> getCustomerCountByRegion();
}
