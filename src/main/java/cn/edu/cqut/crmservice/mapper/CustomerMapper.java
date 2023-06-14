package cn.edu.cqut.crmservice.mapper;

import cn.edu.cqut.crmservice.entity.Customer;
import cn.edu.cqut.crmservice.entity.Report;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.sf.jsqlparser.statement.create.procedure.CreateProcedure;
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

    @Select("SELECT customer.cus_id, customer.cus_name item, SUM(orders.odr_amount) AS value " +
            "FROM customer " +
            "INNER JOIN orders ON customer.cus_id = orders.cus_id " +
            "GROUP BY customer.cus_id")
    public List<Report> getCustomerContribution();

//    @Select("SELECT customer.cus_id, customer.cus_name name, SUM(orders.odr_amount) AS total_amount FROM customer INNER JOIN orders ON customer.cus_id = orders.cus_id GROUP BY customer.cus_id;")
//    public List<Report> getCustomerContribution();


    @Select("select count(*) value, cus_level item from customer GROUP BY cus_level")
    public List<Report> getCustomerCountByLevel();

    @Select("SELECT count(*) value, serv_type item from services GROUP BY serv_type;")
    public List<Report> getCustomerServices();

}
