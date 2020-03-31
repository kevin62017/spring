package tw.leonchen.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class PictureDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public PictureDAO(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
       this.sessionFactory = sessionFactory;
	}
	
	public Picture insert(Picture pBean) {
		Session session = sessionFactory.getCurrentSession();
		
		if(pBean!=null) {
			session.save(pBean);
		}
		
		return pBean;
	}

}
