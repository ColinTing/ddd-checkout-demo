package com.github.colinting.dddcheckoutdemo.infrastructure.order.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.colinting.dddcheckoutdemo.infrastructure.order.dao.po.LineItemPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 丁浩
 * @date 2022年09月03日 20:35
 */
@Mapper
public interface LineItemMapper extends BaseMapper<LineItemPO> {

}
