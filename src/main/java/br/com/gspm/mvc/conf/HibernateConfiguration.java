package br.com.gspm.mvc.conf;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
public class HibernateConfiguration {

	@Autowired
	Environment env;

	@Bean()
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		ds.setUrl(env.getProperty("jdbc.databaseurl"));
		ds.setUsername(env.getProperty("jdbc.username"));
		ds.setPassword(env.getProperty("jdbc.password"));
		return ds;
	}

	@Autowired
	@Bean
	public HibernateTemplate getHibernateTemplate(SessionFactory sessionFactory) {
		HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
		SpringContext.setTemplate(hibernateTemplate);
		return hibernateTemplate;
	}

	@Bean
	public SessionFactory getSessionFactory() throws Exception {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", env.getProperty("jdbc.dialect"));
		properties.put("hibernate.show_sql",env.getProperty("hibernate.show_sql"));
		properties.put("current_session_context_class", "thread");
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setPackagesToScan(new String[] { "br.com.cs.mvc.model" });
		factory.setDataSource(getDataSource());
		factory.setHibernateProperties(properties);
		factory.afterPropertiesSet();
		return factory.getObject();
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() throws Exception {
		return new HibernateTransactionManager(getSessionFactory());
	}

}
