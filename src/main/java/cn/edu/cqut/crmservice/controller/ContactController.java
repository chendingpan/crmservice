package cn.edu.cqut.crmservice.controller;

import cn.edu.cqut.crmservice.entity.Contact;
import cn.edu.cqut.crmservice.entity.Customer;
import cn.edu.cqut.crmservice.entity.Services;
import cn.edu.cqut.crmservice.service.IContactService;
import cn.edu.cqut.crmservice.util.TableResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import javafx.scene.control.Tab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.Arrays;

import static javafx.scene.input.KeyCode.Q;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CQUT
 * @since 2023-06-08
 */
@RestController
@RequestMapping("/contact")
@CrossOrigin
public class ContactController {
    @Autowired
    private IContactService contactService;

    @GetMapping("getContactPage")
    public TableResult<Contact> getContactPage(Integer page,Integer limit,Contact contact){
        QueryWrapper<Contact> wrapper;
        IPage<Contact> contactPage;
        wrapper = new QueryWrapper<>();
        if (contact.getCusId() != null) {
            //条件查询

            wrapper.eq("cus_id", contact.getCusId()); //第一个参数是字段名
            Page<Contact> page1 = new Page<>(page, limit);
            contactPage = contactService.myPage(page1, wrapper);
        }
        else {
            Page<Contact> page1 = new Page<>(page, limit);
            contactPage = contactService.myPage(page1, wrapper);
        }

        return TableResult.ok("查询客户联系人成功",contactPage.getTotal(),contactPage.getRecords());
    }

    @PostMapping("/updateContact")
    public TableResult<Contact> updateContact(Contact contact){
        contactService.updateById(contact);
        return TableResult.ok("修改联系人信息成功");
    }

    @PostMapping("/addContact")
    public TableResult<Contact> addContact(Contact contact){
        contactService.save(contact);
        return TableResult.ok("新增联系人信息成功");
    }

    @PostMapping("/deleteContact")
    public TableResult<Contact> deleteContact(Integer[] ids){//参数名要跟前端ajax方法data参数里面的属性名一致
        contactService.removeByIds(Arrays.asList(ids)); //asList()把数组转list
        return TableResult.ok("删除联系人信息成功");
    }
}
