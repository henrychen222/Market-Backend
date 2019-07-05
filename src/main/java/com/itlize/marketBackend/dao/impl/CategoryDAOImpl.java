package com.itlize.marketBackend.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itlize.marketBackend.dao.CategoryDAO;
import com.itlize.marketBackend.domain.Category;
import com.itlize.marketBackend.domain.SubCategory;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public List<SubCategory> getSubCate(String Category) throws Throwable {
		// TODO Auto-generated method stub
		Category category = (Category) sessionFactory.getCurrentSession().createCriteria(Category.class, "c")
				.add(Restrictions.eq("c.categoryName", Category)).uniqueResult();
//		try catch here, when id is null
		int categoryId = 0;
		try {
			categoryId = category.getCategoryId();
		}
		catch (NullPointerException e) {
			throw new Exception("Category doesn't exist!!!");
		}
		return sessionFactory.getCurrentSession()
				.createQuery("From SubCategory where CategoryID = " + categoryId).list();
	}

	@Override
	public Category hasCategory(String cateName) {
		// TODO Auto-generated method stub
		return (Category) sessionFactory.getCurrentSession().createCriteria(Category.class, "c")
				.add(Restrictions.eq("c.categoryName", cateName)).uniqueResult();
	}

}
