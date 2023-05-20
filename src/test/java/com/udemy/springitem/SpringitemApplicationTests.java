package com.udemy.springitem;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.udemy.springitem.controller.ItemController;
import com.udemy.springitem.repo.ItemRepository;
import com.udemy.springitem.service.ItemService;

@SpringBootTest
class SpringitemApplicationTests {

	@Autowired
	private ItemController itemController;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ItemRepository itemRepository;
	
	// アプリケーションがSpringコンテキストを正常にロードできたかどうかを検証する。
	@Test
	void contextLoads() {
		//AssrtJを利用した検証を実装する
		//assertThatの引数に検証の値を入れる
		//続けてメソッドにて期待値を指定。この場合はNullでないこと
		
		//itemControllerが@Autowiredによって、自動でインスタンス化されてNullでないことを確認する。
		assertThat(itemController).isNotNull();
		assertThat(itemService).isNotNull();
		assertThat(itemRepository).isNotNull();
	}

}
