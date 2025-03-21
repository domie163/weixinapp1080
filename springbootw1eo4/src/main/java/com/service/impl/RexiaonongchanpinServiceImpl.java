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


import com.dao.RexiaonongchanpinDao;
import com.entity.RexiaonongchanpinEntity;
import com.service.RexiaonongchanpinService;
import com.entity.vo.RexiaonongchanpinVO;
import com.entity.view.RexiaonongchanpinView;

@Service("rexiaonongchanpinService")
public class RexiaonongchanpinServiceImpl extends ServiceImpl<RexiaonongchanpinDao, RexiaonongchanpinEntity> implements RexiaonongchanpinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RexiaonongchanpinEntity> page = this.selectPage(
                new Query<RexiaonongchanpinEntity>(params).getPage(),
                new EntityWrapper<RexiaonongchanpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<RexiaonongchanpinEntity> wrapper) {
		  Page<RexiaonongchanpinView> page =new Query<RexiaonongchanpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<RexiaonongchanpinVO> selectListVO(Wrapper<RexiaonongchanpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public RexiaonongchanpinVO selectVO(Wrapper<RexiaonongchanpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<RexiaonongchanpinView> selectListView(Wrapper<RexiaonongchanpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public RexiaonongchanpinView selectView(Wrapper<RexiaonongchanpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
