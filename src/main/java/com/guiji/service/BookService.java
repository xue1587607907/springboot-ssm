package com.guiji.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guiji.entity.Book;

public interface BookService extends IService<Book> {

    Book getBookById(Integer bookId);

    boolean saveBook(Book book);

    boolean modifyBook(Book book);

    boolean removeBookById(Integer bookId);

    IPage<Book> getBookByPage(int currentPage, int pageSize);

    IPage<Book> getBookByPage(int currentPage, int pageSize, Book book);

}
