package com.dao;

import com.entity.DiscussrexiaonongchanpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussrexiaonongchanpinVO;
import com.entity.view.DiscussrexiaonongchanpinView;


/**
 * 热销农产品评论表
 * 
 * @author 
 * @email 
 * @date 2023-03-19 17:44:19
 */
public interface DiscussrexiaonongchanpinDao extends BaseMapper<DiscussrexiaonongchanpinEntity> {
	
	List<DiscussrexiaonongchanpinVO> selectListVO(@Param("ew") Wrapper<DiscussrexiaonongchanpinEntity> wrapper);
	
	DiscussrexiaonongchanpinVO selectVO(@Param("ew") Wrapper<DiscussrexiaonongchanpinEntity> wrapper);
	
	List<DiscussrexiaonongchanpinView> selectListView(@Param("ew") Wrapper<DiscussrexiaonongchanpinEntity> wrapper);

	List<DiscussrexiaonongchanpinView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussrexiaonongchanpinEntity> wrapper);
	
	DiscussrexiaonongchanpinView selectView(@Param("ew") Wrapper<DiscussrexiaonongchanpinEntity> wrapper);
	

}
