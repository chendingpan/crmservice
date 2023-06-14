package cn.edu.cqut.crmservice.service.impl;

import cn.edu.cqut.crmservice.entity.Customer;
import cn.edu.cqut.crmservice.entity.Report;
import cn.edu.cqut.crmservice.mapper.CustomerMapper;
import cn.edu.cqut.crmservice.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CQUT
 * @since 2023-06-09
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

    @Override
    public List<Report> getCustomerContribution() {
        return baseMapper.getCustomerContribution();

    }

    @Override
    public List<Report> getCustomerCountByLevel() {
        return baseMapper.getCustomerCountByLevel();
    }

    @Override
    public List<Report> getCustomerServices() {
        return baseMapper.getCustomerServices();
    }

//    @Override
//    public Map<Integer, Integer> getContributionInfo(Timestamp lastTime) {
//        return null;
//    }
}
