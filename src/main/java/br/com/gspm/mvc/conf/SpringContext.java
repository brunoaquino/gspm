package br.com.gspm.mvc.conf;

import org.springframework.orm.hibernate4.HibernateTemplate;

public class SpringContext {

	private static HibernateTemplate template;

	public static HibernateTemplate getTemplate() {
		return template;
	}

	public static void setTemplate(HibernateTemplate template) {
		SpringContext.template = template;
	}

}
