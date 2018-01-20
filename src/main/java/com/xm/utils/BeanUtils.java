package com.xm.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * Created by xm on 2018/1/20.
 * 根据对象和属性名获取set方法（内省）
 * 使用内省实现（基于java反射专门用于操作bean的属性的api）
 */
public class BeanUtils {
	public static Method getWriteMethod(Object beanObj,String name){
		if(name==null||name==""){
			throw new NullPointerException("属性名为空。");
		}
		if(beanObj==null){
			throw new NullPointerException("对象为空。");
		}
		Method method = null;
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(beanObj.getClass());
			//根据BeanInfo获取所有属性的描述器
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			if(propertyDescriptors != null){
				for(PropertyDescriptor propertyDescriptor : propertyDescriptors){
					if(name.equals(propertyDescriptor.getName())){
						method = propertyDescriptor.getWriteMethod();
					}
				}
			}
		}catch (IntrospectionException e) {
			e.printStackTrace();
		}
		//如果没有找到--》抛出异常，提示用户检查是否创建属性对应的set方法
		if(method==null){
			throw new RuntimeException("请检查"+name+"属性的set方法是否创建");
		}
		return method;
	}
}
