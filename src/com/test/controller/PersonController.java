package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.test.Service.PersonService;
import com.test.beans.Book;
import com.test.beans.Car;

@Controller("pController")
@Scope(value="protoype")  //设置对象的作用域是否单例等等
public class PersonController {
	
	/*autowired 原理：
	 * ：先按照类型在容器中找组件，如果找到0个，直接报错，如果找到多个，就会按照变量名作为id继续查找，如果没有匹配上就报错
	 */
	@Autowired()
	@Qualifier("personService")  //指定一个名作为id，让spring不要使用变量名作为id,如果找不到就会报错
	private PersonService personService;
	
	@Autowired //标注在方法上，那么这个 方法所需要的参数都会被自动装配上
	public void test(Book book,@Qualifier("car")Car car)
	{
		
	}

}
