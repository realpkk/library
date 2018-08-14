package top.management.library.entity.page;

import top.management.library.entity.order.Order;

public class OrderInquiry extends Order {

    private static final long serialVersionUID = 1L;

    private int searchType;//1 模糊搜索 2 精确搜索

    public int getSearchType() {
        return searchType;
    }

    public void setSearchType(int searchType) {
        this.searchType = searchType;
    }

    public OrderInquiry(int searchType, String bookName, String bookCode, String orderCode, String orderLoginName,Integer type, Integer orderPeriod, Integer paymentStatus) {
        this.searchType = searchType;
        super.setBookName(bookName);
        super.setBookCode(bookCode);
        super.setType(type);
        super.setOrderLoginName(orderLoginName);
        super.setOrderCode(orderCode);
        super.setPaymentStatus(paymentStatus);
        super.setOrderPeriod(orderPeriod);
    }
}
