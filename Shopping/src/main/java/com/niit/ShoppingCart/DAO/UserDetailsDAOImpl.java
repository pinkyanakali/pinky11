package  com.niit.ShoppingCart.DAO;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


import com.niit.ShoppingCart.model.UserDetails;

public class UserDetailsDAOImpl implements UserDetailsDAO {
@Autowired
	
	private SessionFactory sessionFactory;
	public UserDetailsDAOImpl(SessionFactory sessionFactory ){
		this.sessionFactory=sessionFactory;
	}

	public boolean save(UserDetails userdetails)
	{
		try {
			sessionFactory.getCurrentSession().save(userdetails);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean update(UserDetails userdetails){
		try {
			sessionFactory.getCurrentSession().update(userdetails);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean delete(UserDetails userdetails){
		try {
			sessionFactory.getCurrentSession().delete(userdetails);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		}
		
public UserDetails get(String id){
			
			String hql="from UserDetails where id ="+","+id+",";
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			List<UserDetails> list=query.list();
			
			if(list==null){
				return null;
			}
			else{
				return list.get(0);
			}
		}
		
		public List<UserDetails>list(){
		
			
			String hql="from UserDetails";
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			return query.list();
		
		
		
	}
	}