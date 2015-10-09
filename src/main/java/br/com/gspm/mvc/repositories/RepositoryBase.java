package br.com.gspm.mvc.repositories;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

public class RepositoryBase {

	protected Session getSession() {
		return hibernateTemplate.getSessionFactory().openSession();
	}

	@Autowired
	public HibernateTemplate hibernateTemplate;

}
