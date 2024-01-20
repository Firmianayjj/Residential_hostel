package com.example.residentialhostel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.residentialhostel.pojo.model.BookingInformation;
import com.example.residentialhostel.service.BookingInformationService;
import com.example.residentialhostel.mapper.BookingInformationMapper;
import org.springframework.stereotype.Service;

/**
* @author yejiajian
* @description 针对表【booking_information(预订信息表)】的数据库操作Service实现
* @createDate 2024-01-19 16:15:17
*/
@Service
public class BookingInformationServiceImpl extends ServiceImpl<BookingInformationMapper, BookingInformation>
    implements BookingInformationService{

}




