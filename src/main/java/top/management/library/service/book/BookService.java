package top.management.library.service.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.management.library.common.search.SearchFilter;
import top.management.library.common.search.SpecificationUtil;
import top.management.library.entity.book.Book;
import top.management.library.repository.BookRepository;

import java.util.List;
import java.util.Map;

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

    public Page<Book> getPage(Map<String,String> paramMap, Pageable pageable) {

        List<SearchFilter> searchFilterList = SearchFilter.getSearchFilterList(paramMap);
        Specification<Book> specification = SpecificationUtil.getSpecification(searchFilterList);
        Page<Book> page = getBooks(specification, pageable);
        if (page.getTotalPages() <= page.getNumber() + 1 && page.getTotalPages() != 0) {
            Pageable newPageable = new PageRequest(page.getTotalPages() - 1, pageable.getPageSize());
            page = getBooks(specification, newPageable);
        }
        return page;
    }
}
