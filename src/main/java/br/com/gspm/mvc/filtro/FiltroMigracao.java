package br.com.gspm.mvc.filtro;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.FlywayException;
import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

@PropertySource("classpath:db.properties")
public class FiltroMigracao implements SpringJdbcMigration {

	@Autowired
	Environment env;

	@Override
	public void migrate(JdbcTemplate template) throws FlywayException {

		Flyway flyway = new Flyway();
		flyway.setDataSource(env.getProperty("databaseurl"), env.getProperty("username"), env.getProperty("password"));

		flyway.migrate();
	}

}
