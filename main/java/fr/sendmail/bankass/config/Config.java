package fr.sendmail.bankass.config;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import fr.sendmail.bankass.busObj.Email;
import fr.sendmail.bankass.daoImpl.EmailDaoImpl;

@Configuration
public class Config {

	public static void main(String[] args) {
		try {
			ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Email.class);
		
			EmailDaoImpl emailDaoImpl= (EmailDaoImpl) context.getBean("sendmail");
			emailDaoImpl.list();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
