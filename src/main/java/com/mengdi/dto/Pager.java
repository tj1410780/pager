package com.mengdi.dto;

import java.io.Serializable;
import java.util.List;

public class Pager<T> implements Serializable {
	
	private static final long serialVersionUID = 232700608910685837L;

	private int currentPage;  //当前页数
	
	private int pageSize;   //每页显示记录数
	
	private int totalRecord;  //查询结果的总记录数
	
	private int totalPage;   //总页数
	
	List<T> dataList;   //数据集合(要显示的数据)

	public Pager() {}	

	public Pager(int currentPage, int pageSize, int totalRecord, List<T> dataList) {
		if (dataList == null) {
			return;
		}
		//获取总记录数
		this.totalRecord = totalRecord;
		//获取每页显示记录数
		this.pageSize = pageSize;
		//获取总页数
		this.totalPage = this.totalRecord / this.pageSize;		
		if (this.totalPage % this.pageSize != 0) {
			this.totalPage += 1;
		}
		//确定当前显示第几页数据
		if (currentPage > totalPage) {
			this.currentPage = totalPage;
		} else {
			this.currentPage = currentPage;
		}
		
		this.dataList = dataList;
	}



	public Pager(int currentPage, int pageSize, int totalRecord, int totalPage, List<T> dataList) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalRecord = totalRecord;
		this.totalPage = totalPage;
		this.dataList = dataList;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Page [currentPage=" + currentPage + ", pageSize=" + pageSize + ", totalRecord=" + totalRecord
				+ ", totalPage=" + totalPage + ", dataList=" + dataList + "]";
	}

	
}
