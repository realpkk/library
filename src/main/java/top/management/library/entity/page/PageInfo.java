package top.management.library.entity.page;


public class PageInfo {

    private Integer currentPage;

    private Integer totalPages;

    private Integer pageSize;

    private Integer targetPage;

    private String operation;

    private final int DEFAULT_PAGE_SIZE = 10;

    private final int DEFAULT_PAGE = 0;

    private final String FIRST = "first";
    private final String LAST = "last";
    private final String PREVIOUS = "previous";
    private final String NEXT = "next";
    private final String JUMP = "jump";
    private final String REFRESH = "refresh";

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public PageInfo(Integer currentPage, Integer totalPages, Integer pageSize, Integer targetPage, String operation) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        if (operation.equals(FIRST)){ this.currentPage = DEFAULT_PAGE;}
        if (operation.equals(PREVIOUS)||operation.equals(REFRESH)){ this.currentPage = currentPage-1;}
        if (operation.equals(NEXT)){ this.currentPage = currentPage+1;}
        if (operation.equals(LAST)){ this.currentPage = totalPages-1;}
        if (operation.equals(JUMP)){ this.currentPage = targetPage-1;}
    }

    public PageInfo(){
        this.currentPage = DEFAULT_PAGE;
        this.pageSize = DEFAULT_PAGE_SIZE;
    }

    @Override
    public String toString() {
        return "PageInfo{"+"currentPage="+currentPage+",totalPage="+totalPages+",pageSize="+pageSize+",operation="+operation+"}";
    }
}
