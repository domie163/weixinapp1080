package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscussrexiaonongchanpinDao;
import com.entity.DiscussrexiaonongchanpinEntity;
import com.service.DiscussrexiaonongchanpinService;
import com.entity.vo.DiscussrexiaonongchanpinVO;
import com.entity.view.DiscussrexiaonongchanpinView;

@Service("discussrexiaonongchanpinService")
public class DiscussrexiaonongchanpinServiceImpl extends ServiceImpl<DiscussrexiaonongchanpinDao, DiscussrexiaonongchanpinEntity> implements DiscussrexiaonongchanpinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussrexiaonongchanpinEntity> page = this.selectPage(
                new Query<DiscussrexiaonongchanpinEntity>(params).getPage(),
                new EntityWrapper<DiscussrexiaonongchanpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussrexiaonongchanpinEntity> wrapper) {
		  Page<DiscussrexiaonongchanpinView> page =new Query<DiscussrexiaonongchanpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussrexiaonongchanpinVO> selectListVO(Wrapper<DiscussrexiaonongchanpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussrexiaonongchanpinVO selectVO(Wrapper<DiscussrexiaonongchanpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussrexiaonongchanpinView> selectListView(Wrapper<DiscussrexiaonongchanpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussrexiaonongchanpinView selectView(Wrapper<DiscussrexiaonongchanpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
