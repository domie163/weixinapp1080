package com.dao;

import com.entity.RexiaonongchanpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.RexiaonongchanpinVO;
import com.entity.view.RexiaonongchanpinView;


/**
 * 热销农产品
 * 
 * @author 
 * @email 
 * @date 2023-03-19 17:44:19
 */
public interface RexiaonongchanpinDao extends BaseMapper<RexiaonongchanpinEntity> {
	
	List<RexiaonongchanpinVO> selectListVO(@Param("ew") Wrapper<RexiaonongchanpinEntity> wrapper);
	
	RexiaonongchanpinVO selectVO(@Param("ew") Wrapper<RexiaonongchanpinEntity> wrapper);
	
	List<RexiaonongchanpinView> selectListView(@Param("ew") Wrapper<RexiaonongchanpinEntity> wrapper);

	List<RexiaonongchanpinView> selectListView(Pagination page,@Param("ew") Wrapper<RexiaonongchanpinEntity> wrapper);
	
	RexiaonongchanpinView selectView(@Param("ew") Wrapper<RexiaonongchanpinEntity> wrapper);
	

}
