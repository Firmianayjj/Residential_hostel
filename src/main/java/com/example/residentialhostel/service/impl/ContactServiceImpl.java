package com.example.residentialhostel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.residentialhostel.pojo.model.Contact;
import com.example.residentialhostel.service.ContactService;
import com.example.residentialhostel.mapper.ContactMapper;
import org.springframework.stereotype.Service;

/**
* @author yejiajian
* @description 针对表【contact(租客与房主之间联系表)】的数据库操作Service实现
* @createDate 2024-01-19 16:22:47
*/
@Service
public class ContactServiceImpl extends ServiceImpl<ContactMapper, Contact>
    implements ContactService{

}




