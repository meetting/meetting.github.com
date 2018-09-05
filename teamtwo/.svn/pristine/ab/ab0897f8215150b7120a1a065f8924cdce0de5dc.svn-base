package com.teamtwo.util;

import java.io.Serializable;
import java.util.List;

public class PageView<E> implements Serializable{
  private static final long serialVersionUID = 8493201024126710421L;
  private List<E> records;
  private PageIndex pageindex;
  private long pageCount;
  private int pageSize = 10;

  private int pageNow = 1;
  private long rowCount;
  private int startPage;
  private int pagecode = 5;

  public PageView(){}

  public int getFirstResult(){
    return (this.pageNow - 1) * this.pageSize;
  }

  public int getPagecode() {
    return this.pagecode;
  }

  public void setPagecode(int pagecode) {
    this.pagecode = pagecode;
  }

  public PageView(int pageSize, int pageNow){
    this.pageSize = pageSize;
    this.pageNow = pageNow;
  }

  public PageView(int pageNow){
    this.pageNow = pageNow;
    this.startPage = ((this.pageNow - 1) * this.pageSize);
  }

  public void setQueryResult(long rowCount, List<E> records){
    setRowCount(rowCount);
    setRecords(records);
  }

  public void setRowCount(long rowCount) {
    this.rowCount = rowCount;
    setPageCount(this.rowCount % this.pageSize == 0L ? this.rowCount / this.pageSize : this.rowCount / this.pageSize + 1L);
  }

  public List<E> getRecords(){
    return this.records;
  }

  public void setRecords(List<E> records) {
    this.records = records;
  }

  public PageIndex getPageindex() {
    return this.pageindex;
  }

  public void setPageindex(PageIndex pageindex) {
    this.pageindex = pageindex;
  }

  public void setPageCount(long pageCount){
    this.pageCount = pageCount;
    this.pageindex = getPageIndex(this.pagecode, this.pageNow, pageCount);
  }

  public int getPageNow() {
    return this.pageNow;
  }

  public void setPageNow(int pageNow) {
    this.pageNow = pageNow;
  }

  public long getPageCount() {
    return this.pageCount;
  }

  public int getPageSize() {
    return this.pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public long getRowCount() {
    return this.rowCount;
  }

  public int getStartPage() {
    return this.startPage;
  }

  public void setStartPage(int startPage) {
    this.startPage = startPage;
  }

  private static PageIndex getPageIndex(long pagecode, int pageNow, long pageCount) {
    long startpage = pageNow - (pagecode % 2L == 0L ? pagecode / 2L - 1L : pagecode / 2L);
    long endpage = pageNow + pagecode / 2L;
    if (startpage < 1L) {
      startpage = 1L;
      if (pageCount >= pagecode)
        endpage = pagecode;
      else
        endpage = pageCount;
    }
    if (endpage > pageCount) {
      endpage = pageCount;
      if (endpage - pagecode > 0L)
        startpage = endpage - pagecode + 1L;
      else
        startpage = 1L;
    }
    return new PageIndex(startpage, endpage);
  }
}