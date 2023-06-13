package cn.edu.cqut.crmservice.service;

import cn.edu.cqut.crmservice.entity.Orders;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CQUT
 * @since 2023-06-13
 */
public interface IOrdersService extends IService<Orders> {

    IPage<Orders> myPage(IPage<Orders> page, QueryWrapper<Orders> queryWrapper);
}
