package com.guiji.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.guiji.common.CommonResult;
import com.guiji.entity.Book;
import com.guiji.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("{id}")
    public CommonResult getBookById(@PathVariable(value = "id") Integer bookId) {
        Book book = bookService.getBookById(bookId);
        return CommonResult.success(book);
    }

    @GetMapping("{currentPage}/{pageSize}")
    public CommonResult getPage(@PathVariable int currentPage, @PathVariable int pageSize, Book book) {
        IPage<Book> bookPage = bookService.getBookByPage(currentPage, pageSize, book);
        if (currentPage > bookPage.getPages()){
            bookPage = bookService.getBookByPage((int) bookPage.getPages(), pageSize, book);
        }
        return CommonResult.success(bookPage);
    }

    @PostMapping
    public CommonResult addBook(@RequestBody Book book){
        boolean b = bookService.saveBook(book);
        return b ? CommonResult.success().msg("添加成功!"):CommonResult.fail().msg("添加失败");
    }

    @PutMapping
    public CommonResult updateBook(@RequestBody Book book){
        boolean b = bookService.modifyBook(book);
        return b? CommonResult.success().msg("修改成功"):CommonResult.fail().msg("修改失败");
    }

    @DeleteMapping("{id}")
    public CommonResult deleteBook(@PathVariable Integer id){
        boolean b = bookService.removeBookById(id);
        return b? CommonResult.success().msg("删除成功"):CommonResult.fail().msg("删除失败");
    }


}
