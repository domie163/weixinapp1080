package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussrexiaonongchanpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussrexiaonongchanpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussrexiaonongchanpinView;


/**
 * 热销农产品评论表
 *
 * @author 
 * @email 
 * @date 2023-03-19 17:44:19
 */
public interface DiscussrexiaonongchanpinService extends IService<DiscussrexiaonongchanpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussrexiaonongchanpinVO> selectListVO(Wrapper<DiscussrexiaonongchanpinEntity> wrapper);
   	
   	DiscussrexiaonongchanpinVO selectVO(@Param("ew") Wrapper<DiscussrexiaonongchanpinEntity> wrapper);
   	
   	List<DiscussrexiaonongchanpinView> selectListView(Wrapper<DiscussrexiaonongchanpinEntity> wrapper);
   	
   	DiscussrexiaonongchanpinView selectView(@Param("ew") Wrapper<DiscussrexiaonongchanpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussrexiaonongchanpinEntity> wrapper);
   	

}

