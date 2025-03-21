package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscussrexiaonongchanpinEntity;
import com.entity.view.DiscussrexiaonongchanpinView;

import com.service.DiscussrexiaonongchanpinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 热销农产品评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2023-03-19 17:44:19
 */
@RestController
@RequestMapping("/discussrexiaonongchanpin")
public class DiscussrexiaonongchanpinController {
    @Autowired
    private DiscussrexiaonongchanpinService discussrexiaonongchanpinService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussrexiaonongchanpinEntity discussrexiaonongchanpin,
		HttpServletRequest request){
        EntityWrapper<DiscussrexiaonongchanpinEntity> ew = new EntityWrapper<DiscussrexiaonongchanpinEntity>();

		PageUtils page = discussrexiaonongchanpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussrexiaonongchanpin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussrexiaonongchanpinEntity discussrexiaonongchanpin, 
		HttpServletRequest request){
        EntityWrapper<DiscussrexiaonongchanpinEntity> ew = new EntityWrapper<DiscussrexiaonongchanpinEntity>();

		PageUtils page = discussrexiaonongchanpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussrexiaonongchanpin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussrexiaonongchanpinEntity discussrexiaonongchanpin){
       	EntityWrapper<DiscussrexiaonongchanpinEntity> ew = new EntityWrapper<DiscussrexiaonongchanpinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussrexiaonongchanpin, "discussrexiaonongchanpin")); 
        return R.ok().put("data", discussrexiaonongchanpinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussrexiaonongchanpinEntity discussrexiaonongchanpin){
        EntityWrapper< DiscussrexiaonongchanpinEntity> ew = new EntityWrapper< DiscussrexiaonongchanpinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussrexiaonongchanpin, "discussrexiaonongchanpin")); 
		DiscussrexiaonongchanpinView discussrexiaonongchanpinView =  discussrexiaonongchanpinService.selectView(ew);
		return R.ok("查询热销农产品评论表成功").put("data", discussrexiaonongchanpinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussrexiaonongchanpinEntity discussrexiaonongchanpin = discussrexiaonongchanpinService.selectById(id);
        return R.ok().put("data", discussrexiaonongchanpin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussrexiaonongchanpinEntity discussrexiaonongchanpin = discussrexiaonongchanpinService.selectById(id);
        return R.ok().put("data", discussrexiaonongchanpin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussrexiaonongchanpinEntity discussrexiaonongchanpin, HttpServletRequest request){
    	discussrexiaonongchanpin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussrexiaonongchanpin);
        discussrexiaonongchanpinService.insert(discussrexiaonongchanpin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussrexiaonongchanpinEntity discussrexiaonongchanpin, HttpServletRequest request){
    	discussrexiaonongchanpin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussrexiaonongchanpin);
        discussrexiaonongchanpinService.insert(discussrexiaonongchanpin);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscussrexiaonongchanpinEntity discussrexiaonongchanpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussrexiaonongchanpin);
        discussrexiaonongchanpinService.updateById(discussrexiaonongchanpin);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussrexiaonongchanpinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<DiscussrexiaonongchanpinEntity> wrapper = new EntityWrapper<DiscussrexiaonongchanpinEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discussrexiaonongchanpinService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
