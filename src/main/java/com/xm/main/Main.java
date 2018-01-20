package com.xm.main;

import com.xm.bean.A;
import com.xm.bean.B;

/**
 * Created by xm on 2018/1/20.
 */
public class Main {
	public static void main(String[] args) {
		MyBeanFactory bf=new MyClassPathXmlApplicationContext("/applicationContext.xml");
		A a = (A) bf.getBean("A");
		System.out.println(a.getName());


		B b=(B) bf.getBean("B");
		System.out.println(b.getA().getName());
	}
}
