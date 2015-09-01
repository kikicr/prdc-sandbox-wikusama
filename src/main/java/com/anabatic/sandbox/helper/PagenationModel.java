package com.anabatic.sandbox.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.anabatic.sandbox.model.User;

public class PagenationModel<E> {
private PageHolder pageHolder;
private int pageLimit;
private EntityManager entityManager;
private Class<E> presistanceClass;
	public int getPageLimit() {
	return pageLimit;
}
public void setPageLimit(int pageLimit) {
	this.pageLimit = pageLimit;
}
	public PagenationModel(PageHolder<E> pageHolder,EntityManager entityManager,Class<E> presistanceClass) {
		super();
		this.pageHolder = pageHolder;
		this.entityManager=entityManager;
		this.presistanceClass=presistanceClass;
	}
	public PageHolder<E> getPageHolder() {
		return pageHolder;
	}
	public void setPageHolder(PageHolder<E> pageHolder) {
		this.pageHolder = pageHolder;
	}
	
	public static interface  PageHolder<T>{
		List<T> getPage(int page,int limit);
		
		
	}
	public int getTotalPage() {
		CriteriaBuilder cr=entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> cq=cr.createQuery(Long.class);
		cq.select(cr.count(cq.from(this.presistanceClass)));
		double result=entityManager.createQuery(cq).getSingleResult().doubleValue();
		if(result<=pageLimit){
		result=(result/pageLimit)+(pageLimit-result/pageLimit);
		}else if(result%pageLimit>0&&result%pageLimit<pageLimit){
			result+=(result%pageLimit)+(pageLimit-result%pageLimit);
		}
		return (int)result/pageLimit;
	}
	
	public E getPage(int page){
		return (E) pageHolder.getPage((page-1)*pageLimit,pageLimit);
	}
}
