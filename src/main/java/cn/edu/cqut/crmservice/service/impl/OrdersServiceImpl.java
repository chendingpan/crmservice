package cn.edu.cqut.crmservice.service.impl;

import cn.edu.cqut.crmservice.entity.Orders;
import cn.edu.cqut.crmservice.mapper.OrdersMapper;
import cn.edu.cqut.crmservice.service.IOrdersService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CQUT
 * @since 2023-06-13
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {
    @Override
    public IPage<Orders> myPage(IPage<Orders> page, QueryWrapper<Orders> queryWrapper) {
        return baseMapper.myPage(page,queryWrapper);
    }
}
