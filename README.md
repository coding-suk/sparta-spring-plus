# SPRING PLUS

### 우선 fork를 받았을 때 resource파일이 없었기 때문에 직접 만들어 줬어야 합니다 
- application.properties 만들어
  - 내부에
    ---
    - jwt.secret.key=${JWT_SECRET_KEY}

spring.datasource.url=jdbc:mysql://localhost:3306/${DB_NAME}
spring.datasource.username=root
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update

spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.use_sql_comments=true
    ---
