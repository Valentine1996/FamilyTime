package com.familytime.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Persistence for test environment.
 */
@Profile("tests")
@SpringBootTest
@Configuration
@ComponentScan("com.familytime")
@EnableJpaRepositories("com.familytime.model.repository")
@EnableTransactionManagement
public class PersistenceTest {

    @Value("classpath:config/H2/insert-data.sql")
    private Resource h2DataScript;

    /**
     * Data source (H2) config.
     *
     * @return DataSource
     */
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource h2DataSource = new DriverManagerDataSource();
        h2DataSource.setDriverClassName("org.hsqldb.jdbcDriver");
        h2DataSource.setUrl("jdbc:hsqldb:mem:test/familytime;DB_CLOSE_DELAY=-1");

        h2DataSource.setUsername("sa");
        h2DataSource.setPassword("");

        return h2DataSource;
    }

    /**
     * Entity Manager Factory config.
     *
     * @return EntityManagerFactory
     */
    @Bean
    public EntityManagerFactory entityManagerFactory() {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory =
                new LocalContainerEntityManagerFactoryBean();

        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.familytime");
        factory.setDataSource(dataSource());
        factory.setJpaProperties(getHibernateProperties());
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    /**
     * Transaction Manager config.
     *
     * @return PlatformTransactionManager
     */
    @Bean
    public PlatformTransactionManager transactionManager() {

        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }

    /**
     * Data source initializer config.
     *
     * @return DataSourceInitializer
     */


    @Bean
    public DataSourceInitializer dataSourceInitializer() {
        final DataSourceInitializer initializer = new DataSourceInitializer();
        DataSource dataSource = dataSource();
        initializer.setDataSource(dataSource);

        initializer.setDatabasePopulator(databasePopulator());
        return initializer;
    }

    /**
     * Database populator config.
     *
     * @return DataSourceInitializer
     */
    private DatabasePopulator databasePopulator() {
        final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(h2DataScript);
        return populator;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.hbm2ddl.auto", "create-drop");

        return properties;
    }

    /**
     * Bean for getting bundle messages.
     *
     * @return MessageSource
     */
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource =
                new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:i18n/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
