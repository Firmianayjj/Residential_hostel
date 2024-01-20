package com.example.residentialhostel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.residentialhostel.pojo.model.HouseInformation;
import com.example.residentialhostel.service.HouseInformationService;
import com.example.residentialhostel.mapper.HouseInformationMapper;
import org.springframework.stereotype.Service;

/**
* @author yejiajian
* @description 针对表【house_information(房子信息表)】的数据库操作Service实现
* @createDate 2024-01-19 16:23:40
*/
@Service
public class HouseInformationServiceImpl extends ServiceImpl<HouseInformationMapper, HouseInformation>
    implements HouseInformationService{

}




