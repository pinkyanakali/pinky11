package com.niit.ShoppingCart.DAO;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingCart.model.Login;


@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO {
	public List<Login> list1() {
		return null;
	}

	@Autowired
	private SessionFactory sessionFactory;

	public LoginDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void save(Login user) {
		sessionFactory.getCurrentSession().save(user);

	}

	@Transactional
	public void update(Login user) {
		sessionFactory.getCurrentSession().update(user);

	}

	@Transactional
	public void delete(int id) {
		Login LoginToDelete = new Login();
		LoginToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(LoginToDelete);
	}

	@Transactional
	public List getAllLogins() {
		Session session=sessionFactory.openSession();
		List listuser=session.createQuery("from Login").list();
		session.close();
		return listuser;
		}


	@Transactional
	public Login get(int id) {
		// sessionFactory.getCurrentSession().get(Login.class,id);
		String hql = "from Login where Id=" + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Login> listLogin = query.list();
		if (listLogin != null && !listLogin.isEmpty()) {
			return listLogin.get(0);
		}
		return null;
	}
	@Transactional
	public Login getSingleLogin(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Login user=(Login)session.load(Login.class, id);
		return user;
		}
	@Transactional
	public List<Login> list() {
		@SuppressWarnings("unchecked")
		List<Login> list = (List<Login>) sessionFactory.getCurrentSession()
				.createCriteria(Login.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;
	}

	public Login getSingleUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}
}
