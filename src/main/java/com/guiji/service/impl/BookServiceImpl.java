package com.guiji.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guiji.entity.Book;
import com.guiji.mapper.BookMapper;
import com.guiji.service.BookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    @Autowired
    BookMapper bookMapper;

    @Override
    public Book getBookById(Integer bookId) {
        return bookMapper.selectById(bookId);
    }

    @Override
    public boolean saveBook(Book book) {
        return bookMapper.insert(book) > 0;
    }

    @Override
    public boolean modifyBook(Book book) {
        return bookMapper.updateById(book) > 0;
    }

    @Override
    public boolean removeBookById(Integer bookId) {
        return bookMapper.deleteById(bookId) > 0;
    }

    @Override
    public IPage<Book> getBookByPage(int currentPage, int pageSize) {
        IPage<Book> page = new Page<>(currentPage, pageSize);
        bookMapper.selectPage(page, null);
        return page;
    }

    @Override
    public IPage<Book> getBookByPage(int currentPage, int pageSize, Book book) {
        IPage<Book> page = new Page<>(currentPage, pageSize);
        LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Strings.isNotEmpty(book.getType()), Book::getType, book.getType());
        lambdaQueryWrapper.like(Strings.isNotEmpty(book.getName()), Book::getName, book.getName());
        lambdaQueryWrapper.like(Strings.isNotEmpty(book.getDescription()), Book::getDescription, book.getDescription());
        bookMapper.selectPage(page,lambdaQueryWrapper);
        return page;
    }
}
