package cn.edu.cqut.crmservice.mapper;

import cn.edu.cqut.crmservice.entity.Customer;
import cn.edu.cqut.crmservice.entity.Report;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CQUT
 * @since 2023-06-09
 */
public interface CustomerMapper extends BaseMapper<Customer> {
    @Select("select count(*) value, cus_region item from customer GROUP BY cus_region")
    public List<Report> getCustomerCountByRegion();
}
