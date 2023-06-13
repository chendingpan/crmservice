package cn.edu.cqut.crmservice.mapper;

import cn.edu.cqut.crmservice.entity.Contact;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CQUT
 * @since 2023-06-09
 */
public interface ContactMapper extends BaseMapper<Contact> {
    @Select("select * from contact ${ew.customSqlSegment}")
    @Results({
//            cus_id用于关联查询后，原来的cusId属性不会有值，为了让它有值需要重新映射一遍
            @Result(column = "cus_id", property = "cusId"),
//            多对一关联查询
            @Result(column = "cus_id", property = "customer",
//                    多对一用One， 一对多用many.  select参数是根据关联字段查询关联对象的mapper方法
                    one = @One(select = "cn.edu.cqut.crmservice.mapper.CustomerMapper.selectById", fetchType = FetchType.EAGER))
    })
    public Page<Contact> myPage(IPage<Contact> page, @Param(Constants.WRAPPER) QueryWrapper<Contact> queryWrapper);
}
