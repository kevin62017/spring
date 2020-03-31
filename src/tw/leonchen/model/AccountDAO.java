package tw.leonchen.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {

	private SessionFactory sessionFacotry;

	@Autowired
	public AccountDAO(@Qualifier(value = "sessionFactory") SessionFactory sessionFacotry) {
		this.sessionFacotry = sessionFacotry;
	}

	public boolean checkLogin(Account account) {
		try {
			Session session = sessionFacotry.getCurrentSession();
			String hqlstr = "from Account where username=:user and userpwd=:pwd";
			Query<Account> query = session.createQuery(hqlstr, Account.class);
			query.setParameter("user", account.getUsername());
			query.setParameter("pwd", account.getUserpwd());

			Account myAcc = query.uniqueResult();

			if (myAcc != null) {
				return true;
			}
			
			return false;
		} catch (Exception e) {
			System.out.println("e:" + e);
			return false;
		}
	}

}
