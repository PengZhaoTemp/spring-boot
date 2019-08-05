package com.example.zhaop.test.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TestMapper {

    void inserto();

    void insertt();

    List<Map> searchTestInfo(Map map);
}
