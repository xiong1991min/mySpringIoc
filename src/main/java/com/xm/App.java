package com.xm;

import com.xm.config.Bean;
import com.xm.config.parse.ConfigManager;

import java.beans.IntrospectionException;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IntrospectionException {

        Map<String, Bean> config = ConfigManager.getConfig("/applicationContext.xml");

        System.out.println(config);

//        BeanInfo beanInfo = Introspector.getBeanInfo(People.class);
//        BeanDescriptor beanDescriptor = beanInfo.getBeanDescriptor();
//        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
//        for (PropertyDescriptor propertyDescriptor : propertyDescriptors){
//
//        }
//        MethodDescriptor[] methodDescriptors = beanInfo.getMethodDescriptors();
//        for(MethodDescriptor methodDescriptor : methodDescriptors){
//        }
//        System.out.println( "Hello World!" );
    }
}

class People{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
