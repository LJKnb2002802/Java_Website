package com.tfswufe.resume.converter;

import com.tfswufe.resume.bean.base.BaseConverter;
import com.tfswufe.resume.domain.entity.Advertise;
import com.tfswufe.resume.domain.vo.AdvertiseVO;
import com.tfswufe.resume.domain.vo.portal.PortalAdvertiseVO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdvertiseConverter extends BaseConverter<Advertise, AdvertiseVO> {

    List<PortalAdvertiseVO> advertiseList2portalAdvertiseVOList(List<Advertise> advertiseList);
}