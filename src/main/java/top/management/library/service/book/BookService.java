package top.management.library.service.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.management.library.entity.book.Book;
import top.management.library.entity.page.BookInquiry;
import top.management.library.entity.page.PageInfo;
import top.management.library.repository.BookRepository;

import java.util.List;

@Service
public class BookService{

    @Autowired
    private BookRepository bookRepository;

    @Transactional(rollbackFor = Exception.class)
    public void addNewSingleBook(Book book){

        bookRepository.save(book);
    }

    public void updateBook(Book newBook){

        Book originBook = bookRepository.findBookByBookCode(newBook.getBookCode());
        newBook.setId(originBook.getId());
        newBook.setCreateTime(originBook.getCreateTime());
        bookRepository.save(newBook);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteBook(String bookCode) {

        bookRepository.deleteBookByBookCode(bookCode);
    }

    public String getBookNameByBookCode(String bookCode) {

        return bookRepository.findBookByBookCode(bookCode).getBookName();
    }

    public void bookRemainUpdateByBookCode(String bookCode,Integer orderAmount) {

        Book originBook = bookRepository.findBookByBookCode(bookCode);
        originBook.setBookRemain(originBook.getBookRemain()-orderAmount);
        bookRepository.save(originBook);
    }

    public Page<Book> getBooks(Specification<Book> specification,Pageable pageable) {

        return bookRepository.findAll(specification,pageable);
    }

    public Page<Book> findBooks(Pageable pageable) {

        return bookRepository.findAll(pageable);
    }
}
