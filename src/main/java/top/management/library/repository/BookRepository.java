package top.management.library.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import top.management.library.entity.book.Book;
import top.management.library.repository.base.AbstractRepository;

import java.util.List;

@Repository
public interface BookRepository extends AbstractRepository<Book,Long> {

    Book findBookByBookCode(String bookCode);

    @Override
    @Query("select b from Book b")
    Page<Book> findAll(Pageable pageable);

    void deleteBookByBookCode(String bookCode);

    @Modifying
    @Query("update Book b set b.bookRemain =?2 where b.bookCode =?1")
    int updateBookRemain(String bookCode,Integer amount);
}
