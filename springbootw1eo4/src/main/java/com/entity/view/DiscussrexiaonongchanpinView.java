package com.entity.view;

import com.entity.DiscussrexiaonongchanpinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 热销农产品评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-03-19 17:44:19
 */
@TableName("discussrexiaonongchanpin")
public class DiscussrexiaonongchanpinView  extends DiscussrexiaonongchanpinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussrexiaonongchanpinView(){
	}
 
 	public DiscussrexiaonongchanpinView(DiscussrexiaonongchanpinEntity discussrexiaonongchanpinEntity){
 	try {
			BeanUtils.copyProperties(this, discussrexiaonongchanpinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
