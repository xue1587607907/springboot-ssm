package com.guiji;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.guiji.entity.Book;
import com.guiji.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootSsmApplicationTests {

    @Autowired
    BookService bookService;

    @Test
    void contextLoads() {
        System.out.println("dev.....);
    }

}
