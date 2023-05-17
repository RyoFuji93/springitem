package com.udemy.springitem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.udemy.springitem.model.Item;
import com.udemy.springitem.repo.ItemRepository;

@SpringBootApplication
@EnableCaching
public class SpringitemApplication implements CommandLineRunner{

	@Autowired
	private ItemRepository itemrepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringitemApplication.class, args);
	}
	
	@Override
	public void run(String...args) throws Exception{
		itemrepository.save(new Item("ネックレス","ジュエリ"));
		itemrepository.save(new Item("パーカー","ファッション"));
		itemrepository.save(new Item("フェイスクリーム","ビューティ"));
		itemrepository.save(new Item("サプリメント","ヘルス"));
		itemrepository.save(new Item("ブルーベリー","フード"));
	}

}
