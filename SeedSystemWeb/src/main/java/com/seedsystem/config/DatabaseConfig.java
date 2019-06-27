package com.seedsystem.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

/**
 * Database Configuration class.
 *
 * 
 * 
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = {"com.seedsystem.entity","com.seedsystem.repository"},
    entityManagerFactoryRef = "seedSystemEntityManagerFactory",
    transactionManagerRef = "seedsystemTransactionManager")

public class DatabaseConfig {

  /** The Constant LOG. */
  private static final Logger LOG = LoggerFactory.getLogger(DatabaseConfig.class);

  /** The seedsystem data source user name. */
  @Value("${seedsystem.datasource.username}")
  private String seedsystemDataSourceUserName;

  /** The seedsystem data source password. */
  @Value("${seedsystem.datasource.password}")
  private String seedsystemDataSourcePassword;

  /** The seedsystem data source url. */
  @Value("${seedsystem.datasource.url}")
  private String seedsystemDataSourceUrl;

  /** The seedsystem data source driver class name. */
  @Value("${seedsystem.datasource.driverClassName}")
  private String seedsystemDataSourceDriverClassName;

  /** The seedsystem data source connection timeout. */
  @Value("${seedsystem.datasource.connectionTimeout}")
  private int seedsystemDataSourceConnectionTimeout;

  /** The seedsystem data source max pool size. */
  @Value("${seedsystem.datasource.maxPoolSize}")
  private int seedsystemDataSourceMaxPoolSize;

  /** The seedsystem data source idle timeout. */
  @Value("${seedsystem.datasource.idleTimeout}")
  private int seedsystemDataSourceIdleTimeout;

  /** The seedsystem data source pool name. */
  @Value("${seedsystem.datasource.poolName}")
  private String seedsystemDataSourcePoolName;

  /** The seedsystem data source min idle. */
  @Value("${seedsystem.datasource.minIdle}")
  private int seedsystemDataSourceMinIdle;

  /**
   * seedsystem data source.
   *
   * @return the data source
   */
  @Bean
  @Primary
  @Qualifier("seedsystemDataSource")
  public DataSource seedsystemDataSource() {

    HikariDataSource ds = new HikariDataSource();

    ds.setUsername(seedsystemDataSourceUserName);
    ds.setPassword(seedsystemDataSourcePassword);
    ds.setJdbcUrl(seedsystemDataSourceUrl);
    ds.setDriverClassName(seedsystemDataSourceDriverClassName);
    ds.setPoolName(seedsystemDataSourcePoolName);

    // HikariCP settings
    // Maximum number of actual connection in the pool
    ds.setMaximumPoolSize(seedsystemDataSourceMaxPoolSize);

    // Minimum number of idle connections in the pool
    ds.setMinimumIdle(seedsystemDataSourceMinIdle);
    // Maximum waiting time for a connection from the pool
    ds.setConnectionTimeout(seedsystemDataSourceConnectionTimeout);

    // Maximum time that a connection is allowed to sit idle in the pool
    ds.setIdleTimeout(seedsystemDataSourceIdleTimeout);

    LOG.info("Setup of seedsystemDataSource succeeded.");
    return ds;
  }

  /**
   * Creates the entity manager factory bean which is required to access the JPA functionalities
   * provided by the JPA persistence provider, i.e. Hibernate in this case. <br/>
   * <br/>
   * Note the <b>{@literal @}Primary</b> annotation which tells Spring boot to create this entity
   * manager as the first thing when starting the application.
   *
   * @return the local container entity manager factory bean
   */
  @Primary
  @Bean(name="seedSystemEntityManagerFactory")
  @Qualifier("seedsystemEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean seedsystemEntityManagerFactory() {
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

    // Set the seedsystem data source
    em.setDataSource(seedsystemDataSource());

    // The seedsystem  entity and repository need to be scanned
    em.setPackagesToScan(new String[] {"com.seedsystem.entity","com.seedsystem.repository"});
    // Setting a name for the persistence unit as Spring sets it as
    // 'default' if not defined
    em.setPersistenceUnitName("seedsystemdb-persistence-unit");

    // Setting Hibernate as the JPA provider
    JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    em.setJpaVendorAdapter(vendorAdapter);

    // Set the hibernate properties
    em.setJpaProperties(hibernateProperties());
    LOG.info("Setup of seedsystemEntityManagerFactory succeeded.");
    return em;
  }

  /**
   * This transaction manager is appropriate for applications that use a single JPA
   * EntityManagerFactory for transactional data access. <br/>
   * <br/>
   * Note the <b>{@literal @}Qualifier</b> annotation to ensure that the
   * <tt>seedsystemEntityManagerFactory</tt> is used for setting up the transaction manager.
   *
   * @param emf
   *          the emf
   * @return the jpa transaction manager
   */
  @Qualifier("seedsystemTransactionManager")
  @Bean(name = "seedsystemTransactionManager")
  @Primary
  public JpaTransactionManager seedsystemTransactionManager(
      @Qualifier("seedsystemEntityManagerFactory") EntityManagerFactory emf) {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(emf);
    return transactionManager;
  }

  /**
   * Bean post-processor that automatically applies persistence exception translation to any bean
   * marked with Spring's @Repository annotation, adding a corresponding
   * PersistenceExceptionTranslationAdvisor to the exposed proxy (either an existing AOP proxy or a
   * newly generated proxy that implements all of the target's interfaces).
   *
   * @return the persistence exception translation post processor
   */
  @Bean
  public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
    return new PersistenceExceptionTranslationPostProcessor();
  }

  /**
   * The properties for configuring the JPA provider Hibernate.
   *
   * @return the properties
   */
  private Properties hibernateProperties() {
    
//    <property name="hibernate.connection.url">jdbc:postgresql://localhost:5432/hibernatedb</property>


    Properties properties = new Properties();
    properties.put(org.hibernate.cfg.Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
    properties.put("spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults", false);

    properties.put(org.hibernate.cfg.Environment.SHOW_SQL, true);
    properties.put(org.hibernate.cfg.Environment.FORMAT_SQL, true);
    return properties;
  }
}
