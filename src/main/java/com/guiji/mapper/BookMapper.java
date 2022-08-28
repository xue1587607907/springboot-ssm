package com.guiji.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.guiji.entity.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper extends BaseMapper<Book> {
}
