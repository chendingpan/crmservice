package cn.edu.cqut.crmservice.service;

import cn.edu.cqut.crmservice.entity.Contact;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CQUT
 * @since 2023-06-09
 */
public interface IContactService extends IService<Contact> {
    public IPage<Contact> myPage(IPage<Contact> page, QueryWrapper<Contact> queryWrapper);
}
