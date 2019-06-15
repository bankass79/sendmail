package fr.sendmail.bankass.dao;

import java.util.List;

import fr.sendmail.bankass.busObj.Email;

public interface EmailDao {
	Long save(Email email);
	List<Email> list();
	Email get(Long id);
	void remove(Long id);

}
