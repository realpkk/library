package top.management.library.entity.page;

import top.management.library.entity.book.Book;
import top.management.library.entity.page.PageInfo;

public class BookInquiry extends Book {

    private static final long serialVersionUID = 1L;

    private int searchType;//1 模糊搜索 2 精确搜索

    private Integer inventory;//库存状况 0 不足 1 充足

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public int getSearchType() {
        return searchType;
    }

    public void setSearchType(int searchType) {
        this.searchType = searchType;
    }

    public BookInquiry() {
        this.inventory = null;
        this.searchType = 1;
        super.setBookName("");
        super.setBookCode("");
        super.setOrderSupport(null);
    }

    public BookInquiry(Integer inventory, int searchType,String bookName,String bookCode,Integer orderSupport) {
        this.inventory = inventory;
        this.searchType = searchType;
        super.setBookCode(bookCode);
        super.setBookName(bookName);
        super.setOrderSupport(orderSupport);
    }
}
