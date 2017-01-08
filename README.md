**1. Lazy Loading - Handling the LazyInitializationException**
+ Open Session in View:
    add `new OpenEntityManagerInViewFilter()` in `getServletFilters()`
+ hibernate.enable_lazy_load_no_trans:
    add `hibernate.enable_lazy_load_no_trans = true` in file `application.properties`  <br> and update in `hibernateProperties()`
    
[Referenced Link 1](https://vladmihalcea.com/2016/09/13/the-best-way-to-handle-the-lazyinitializationexception/)
[Referenced Link 2](https://zeroturnaround.com/rebellabs/three-jpa-2-1-features-that-will-boost-your-applications-performance/)
[Referenced Link 3](http://spiral-architect.pl/2016/01/21/jpa-2-1-named-entity-graphs-introduction/)
[Referenced Link 4](https://dzone.com/articles/jpa-lazy-loading)
[Referenced Link 5](http://www.thoughts-on-java.org/5-ways-to-initialize-lazy-relations-and-when-to-use-them/)

**2. Configuration for native Hibernate**
```
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.leon.webapp.model");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }
    
    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;
    }
```

**3. Importing data-script file**
```
    @Bean
    public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(dataSource);
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        databasePopulator.addScript(new ClassPathResource("db.sql"));
        dataSourceInitializer.setDatabasePopulator(databasePopulator);
        dataSourceInitializer.setEnabled(true);
        return dataSourceInitializer;
    }
```

**4. Workaround for issue that ignores everything after last '.' in @PathVariables argument**
```
   @Override
   public void configurePathMatch(PathMatchConfigurer configurer) {
       configurer.setUseRegisteredSuffixPatternMatch(true);
   }
```

**5. Configuration default view resolver (JSP)**
```
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }
```
**6. JSP Example**
```
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; UTF-8" language="java" %>
<%@ page session="false" %>
<html>
    <head>
        <title>Web App SpringMVC Template</title>
        <link rel="stylesheet"
              type="text/css"
              href="<c:url value="/resources/css/style.css" />"
              media="all">
    </head>
    <body>
        <h2>Hello ${name}!</h2>
    </body>
</html>
```
    
 
