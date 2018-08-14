package top.management.library.entity.book;

import org.springframework.stereotype.Component;
import top.management.library.entity.base.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "book")
public class Book extends AbstractEntity implements Comparable<Book> {

    private static final long serialVersionUID = 1L;

    @Column(name = "book_name",nullable = false)
    @NotNull
    private String bookName;//图书书名

    @Column(name = "book_code",nullable = false,unique = true)
    @NotNull
    private String bookCode;//图书编码

    @Column(name = "book_amount")
    private Integer bookAmount;//图书总量

    @Column(name = "book_remain")
    private Integer bookRemain;//图书库存

    @Column(name = "inventory_status")
    private Integer inventoryStatus;//库存状况 0 待补充 1 充足

    @Column(name = "order_support")
    private Integer orderSupport;//0 期刊订购 1 整书购买

    @PrePersist
    public void inventoryCreate(){
        this.inventoryStatus = 1;
    }

    @PreUpdate
    public void inventoryUpdate(){
        if (this.bookRemain==0){
            this.inventoryStatus = 0;
        }else {
            this.inventoryStatus = 1;
        }
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public Integer getBookAmount() {
        return bookAmount;
    }

    public void setBookAmount(Integer bookAmount) {
        this.bookAmount = bookAmount;
    }

    public Integer getBookRemain() {
        return bookRemain;
    }

    public void setBookRemain(Integer bookRemain) {
        this.bookRemain = bookRemain;
    }

    public Integer getInventoryStatus() {
        return inventoryStatus;
    }

    public void setInventoryStatus(Integer inventoryStatus) {
        this.inventoryStatus = inventoryStatus;
    }

    public Integer getOrderSupport() {
        return orderSupport;
    }

    public void setOrderSupport(Integer orderSupport) {
        this.orderSupport = orderSupport;
    }

    @Override
    public int compareTo(Book o) {
        return this.bookCode.compareTo(getBookCode());
    }

    @Override
    public String toString() {
        return "Book{"+"bookName: "+bookName+" ,bookCode: "+bookCode+" ,bookAmount: "+bookAmount+" ,bookRemain: "+bookRemain
                +" ,orderSupport: "+orderSupport+"}";
    }
}
