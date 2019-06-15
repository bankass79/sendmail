package fr.sendmail.bankass.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.sendmail.bankass.busObj.Email;
import fr.sendmail.bankass.dao.EmailDao;

@Repository(value="emailDao")
@Transactional
public class EmailDaoImpl implements EmailDao {

	private static Logger logger = org.slf4j.LoggerFactory.getLogger(EmailDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Long save(Email email) {
		
		Session session =sessionFactory.getCurrentSession();
		Long id= (Long) session.save(email);
		logger.info("Created email with id" + id);
		return id;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Email> list() {
	Session session=sessionFactory.getCurrentSession();

		return session.createQuery("From Email").list();
	}

	@Override
	public Email get(Long id) {
		Session session= sessionFactory.getCurrentSession();
		return session.get(Email.class, id);
	}

	@Override
	public void remove(Long id) {
	Session session= sessionFactory.getCurrentSession();
	
	Email email = session.get(Email.class, id);
	session.delete(email);

	}

}
