package top.management.library.controller.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.management.library.common.utils.MapConvertUtil;
import top.management.library.entity.book.Book;
import top.management.library.service.book.BookService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping("/book")
public class BookController {

    private final Pageable DEFAULT_PAGEABLE = new PageRequest(0,10);


    @Autowired
    private BookService bookService;

    @RequestMapping("")
    public String toOrder(Model model){

        Page<Book> page = bookService.findBooks(DEFAULT_PAGEABLE);
        model.addAttribute("page",page);
        return "book";
    }

    @RequestMapping("/search")
    public String getBooks(HttpServletResponse response,HttpServletRequest request,Model model){

        Map<String,String> paramMap = MapConvertUtil.getParameterMap(request);
        model.addAttribute("page",bookService.getPage(paramMap,DEFAULT_PAGEABLE));
        return "book";
    }

    @RequestMapping("/page")
    public String toPage(HttpServletRequest request,HttpServletResponse response,Model model){

        Pageable pageable = new PageRequest
                (Integer.parseInt(request.getParameter("@pageNumber")),Integer.parseInt(request.getParameter("@pageSize")));
        model.addAttribute("page",bookService.getPage(MapConvertUtil.getParameterMap(request),pageable));
        return "book";
    }

    @RequestMapping("/add")
    public void  addSingleBook(@RequestBody Book book){

        bookService.addNewSingleBook(book);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String deleteBook(@RequestBody Book book){

        bookService.deleteBook(book.getBookCode());
        return "编码"+book.getBookCode()+"已删除";
    }

    @RequestMapping("/edit")
    @ResponseBody
    public String editBook(@RequestBody Book book){

        bookService.updateBook(book);
        return "编码"+book.getBookCode()+"已保存";
    }
}

