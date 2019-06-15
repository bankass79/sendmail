package fr.sendmail.bankass.daoImpTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.sendmail.bankass.busObj.Email;
import fr.sendmail.bankass.dao.EmailDao;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = HibernateSpringClobBlobApplication.class)
@Transactional
@Rollback(false)
public class BinaryHibernateSpringBlobTests {
	private Logger logger = LoggerFactory.getLogger(BinaryHibernateSpringBlobTests.class);
	@Autowired SessionFactory sessionFactory;
	@Autowired @Qualifier("emailDao") EmailDao emailDao;

	final static long idMail=62L;
	
	@Test public void testInsertEmailXLob(){
		Email email=new Email();
		
		Session session = sessionFactory.getCurrentSession();
		
		try (final InputStream istream = new FileInputStream(new File("/tmp/emailLOB.txt"))) 
		{
			session.beginTransaction();
			Blob blob = session.getLobHelper().createBlob(istream, istream.available()); 
			email.setCorps(blob);
			email.setIdRegion("48");
			email.setObjet("test hibernate & lob pour "+ email.getIdRegion());
			Long id = emailDao.save(email);
			session.getTransaction().commit();
			blob.free();
			Assert.assertNotNull(id);
		} catch (Exception e) {
			//a traiter e.printStackTrace();
		}
	}

	@Test public void testReadBlob() throws SQLException{
		
		try{	
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Email email=emailDao.get(idMail);
			if(email==null){
				logger.warn("\tAucun mail avec id="+idMail);
				return;
			}
			Assert.assertNotNull(email);
			session.setReadOnly(email, true);
			Blob blob= email.getCorps();
			
			try(OutputStream fos = new FileOutputStream("/tmp/readClobOut.txt")){ 
	          fos.write(blob.getBytes(1, (int)blob.length()));     
			}
			
			blob.free();
			session.getTransaction().commit();
			Assert.assertNotNull(email);
			
		}catch(Exception e){
			//a traiter e.printStackTrace();
		}
	}
	
	@Test 
	public void testRemove(){
		emailDao.remove(idMail);
	}
}