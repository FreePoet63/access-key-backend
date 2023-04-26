package com.example.accesskeybackend.template.mapper;

import com.example.accesskeybackend.template.dto.IPv6SupportDTO;
import com.example.accesskeybackend.template.entity.IPv6Support;
import org.mapstruct.*;

import org.mapstruct.factory.Mappers;

@Mapper
public interface IPv6SupportMapper {
    IPv6SupportMapper INSTANCE = Mappers.getMapper(IPv6SupportMapper.class);

    @Mapping(source = "siteUrl", target = "siteUrl")
    @Mapping(source = "ipv6Supported", target = "ipv6Supported")
    IPv6SupportDTO toDTO(IPv6Support entity);

    @Mapping(source = "siteUrl", target = "siteUrl")
    @Mapping(source = "ipv6Supported", target = "ipv6Supported")
    IPv6Support toEntity(IPv6SupportDTO dto);
}
