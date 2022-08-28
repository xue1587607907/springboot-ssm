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
        Book book = new Book();
        book.setDescription("java");
        book.setName("java");
        IPage<Book> pages = bookService.getBookByPage(1, 2, book);
        System.out.println("pages.getPages() = " + pages.getPages());
        System.out.println("pages.getCurrent() = " + pages.getCurrent());
        System.out.println("pages.getSize() = " + pages.getSize());
        System.out.println("pages.getTotal() = " + pages.getTotal());
        System.out.println("pages.getRecords() = " + pages.getRecords());
    }

}
