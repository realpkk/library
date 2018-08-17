package top.management.library.service.workflow;

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
import top.management.library.entity.order.Order;
import top.management.library.entity.workflow.AfterSale;
import top.management.library.repository.AdminMessageRepository;
import top.management.library.repository.AfterSaleRepository;
import top.management.library.repository.BookRepository;
import top.management.library.repository.OrderRepository;

import java.util.List;
import java.util.Map;

@Service
public class AterSaleService {

    @Autowired
    private AfterSaleRepository afterSaleRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AdminMessageRepository adminMessageRepository;

    public void createApplicationRecord(AfterSale afterSale) {

        afterSaleRepository.save(afterSale);
    }

    public Page getAllApplications(Pageable pageable) {

        return afterSaleRepository.findAll(pageable);
    }

    public Page getApplicationsByLauncher(String launcher, Pageable pageable) {

        return afterSaleRepository.findAfterSalesByApplicationLauncher(launcher,pageable);
    }

    public Page getApplications(Specification<AfterSale> specification,Pageable pageable){

        return afterSaleRepository.findAll(specification,pageable);
    }

    public Page<AfterSale> getPage(Map<String,String> paramMap, Pageable pageable){

        List<SearchFilter> searchFilterList = SearchFilter.getSearchFilterList(paramMap);
        Specification<AfterSale> specification = SpecificationUtil.getSpecification(searchFilterList);
        Page<AfterSale> page = getApplications(specification,pageable);
        if (page.getTotalPages()<=page.getNumber()+1&&page.getTotalPages()!=0){
            Pageable newPageable = new PageRequest(page.getTotalPages()-1,pageable.getPageSize());
            page = getApplications(specification,newPageable);
        }
        return page;
    }


    public AfterSale getApplicationByAfterSaleCode(String applicationCode) {

        return afterSaleRepository.findAfterSalesByApplicationCode(applicationCode);
    }

    public void cancelApplication(String applicationCode) {

        afterSaleRepository.deleteAfterSaleByApplicationCode(applicationCode);
    }

    @Transactional(rollbackFor = Exception.class)
    public void passApplication(String applicationCode) {

        afterSaleRepository.passApplication(applicationCode);
        AfterSale afterSale = afterSaleRepository.findAfterSalesByApplicationCode(applicationCode);
        orderRepository.updatePaymentStatus(afterSale.getOrderCode(),3);
        Order order = orderRepository.findOrderByOrderCode(afterSale.getOrderCode());
        Book book = bookRepository.findBookByBookCode(order.getBookCode());
        book.setBookRemain(book.getBookRemain()+order.getOrderAmount());
        book.setInventoryStatus(1);
        bookRepository.save(book);
    }

    @Transactional(rollbackFor = Exception.class)
    public void rejectApplication(String applicationCode, String reply) {

        afterSaleRepository.rejectApplication(applicationCode,reply);
        AfterSale afterSale = afterSaleRepository.findAfterSalesByApplicationCode(applicationCode);
    }
}
