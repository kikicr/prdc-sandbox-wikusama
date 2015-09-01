package com.anabatic.sandbox.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;

import com.anabatic.sandbox.dao.UserDao;
import com.anabatic.sandbox.helper.PagenationModel;
import com.anabatic.sandbox.helper.PagenationModel.PageHolder;
import com.anabatic.sandbox.model.User;

@Repository
public class UserDaoHibernate extends GenericDaoHibernate<User, String>
		implements UserDao {
	private PagenationModel<User> pagenationModel;
	
	public UserDaoHibernate() {
		super(User.class);
		// TODO Auto-generated constructor stub
	}

	public User findUserByUserName(String name) {
		User user = new User();
		try {
			user = (User) getEntityManager()
					.createQuery("from User u join fetch u.role where u.id=:id")
					.setParameter("id", name).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}


	public PagenationModel<User> getUserListByLimit(String condition) {
		try {
			final Query query= getEntityManager()
					.createQuery(
							"from User u join fetch u.role "
									+ ((condition.length() > 0) ? "where u.id like :id"
											: ""));
			if(condition.length()>0){
				query.setParameter("id","%"+condition+"%");
				
			}
			pagenationModel=new PagenationModel<User>(new PageHolder<User>() {
				
				public List<User> getPage(int page, int limit) {
					return query.setFirstResult(page).setMaxResults(limit).getResultList();
				}
				},getEntityManager(),User.class);

			
					return pagenationModel;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;


		
	}

	public List<User> getUserByRole(int roleId) {
		try {
			Query query= getEntityManager()
					.createQuery(
							"from User u join fetch u.role where u.role.name=:role"
									);
			query.setParameter(":role", roleId);
			return query.getResultList();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<User>();

	}

}
