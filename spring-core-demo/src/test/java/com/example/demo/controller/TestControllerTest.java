package com.example.demo.controller;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;



import javax.annotation.Resource;

@SpringBootTest
class TestControllerTest {

	@Resource
	TestController testController;

	@Test
	void testOne () {
		String s = testController.testOne(123);
		System.out.println(s);
//		Assert.isTrue(12>0,"hello");
//		Assertions.assertArrayEquals(new int[2],new int[2]);
	}
	// @BeforeAll : 在测试类执行之前执行的方法 必须用static 相当与testng中的@BeforeClass
	@BeforeAll
	public static void beforeAll(){
		System.out.println("beforeAll");
	}

	// @BeforeEach : 在每个测试用例前执行的方法 相当于testng的@BeforeMethod
	@BeforeEach
	public void beforeEach(){
		System.out.println("beforeEach");
	}

	// @Disabled 相当但junit4的Ignore 跳过该测试用例
	@Test
	@Disabled
	void test01(){
		System.out.println("test01");
	}

	// @RepeatedTest 重复执行
	@RepeatedTest(4)
	@Tag("tagDemo")
	void test02(){    System.out.println("repeated");
	}

	// @DisplayName("name") 展示用例名
	@Test
	@Tag("tagDemo2")
	@DisplayName("测试用例3")
	void test03(){
		System.out.println("DisplayName");
	}

	// @AfterEach : 在测试类执行之后执行的方法
	@AfterEach
	public void afterEach(){
		System.out.println("afterEach");
	}

	// @AfterAll : 在每个测试用例后执行的方法 必须用static声明
	@AfterAll
	public static void afterAll(){
		System.out.println("afterAll");
	}

	// @Order定义执行顺序
	//  需要先在类上打上@TestMethodOrder(MethodOrderer.OrderAnnotation.class)注解

	@Test
	@Order(1)
	public void divideTest(){
		int x = 4/2;
		Assertions.assertEquals(2,2);
	}

}