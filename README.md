# oauth2-authentication-code-learn

## Docker 환경에서 Postgresql 실행

```bash
> docker volume create pgdata # 데이터를 저장할 볼륨을 생성한다. 
> docker run -p 5432:5432 --name postgres -e POSTGRES_PASSWORD=1q2w3e4r -d -v pgdata:/var/lib/postgresql/data postgres
> docker exec -it postgres /bin/bash
```

```bash
\# psql -U postgres
\# CREATE USER arthur PASSWORD '1q2w3e4r' SUPERUSER;
\# CREATE DATABASE dbcom OWNER arthur;
\# GRANT ALL PRIVILEGES ON DATABASE dbcom TO arthur; # 특정 유저에게 데이터베이스에 접근가능한 권한 부여

\# \c dbcom arthur
```

### DB 정보

- localhost: 5432
- username: arthur
- password: 1q2w3e4r
- schema: dbcom

## USER 및 ROLE 테이블 생성 및 더미 데이터 삽입

```sql
CREATE TABLE USERS
(	USERNAME VARCHAR(50) NOT NULL,
     PASSWORD VARCHAR(68) NOT NULL,
     ENABLED SMALLINT NOT NULL,
     PRIMARY KEY(USERNAME)
);

INSERT INTO USERS (USERNAME, PASSWORD, ENABLED) VALUES('employee','$2a$10$cRqfrdolNVFW6sAju0eNEOE0VC29aIyXwfsEsY2Fz2axy3MnH8ZGa',1);
INSERT INTO USERS (USERNAME, PASSWORD, ENABLED) VALUES('manager','$2a$10$cRqfrdolNVFW6sAju0eNEOE0VC29aIyXwfsEsY2Fz2axy3MnH8ZGa',1);

CREATE TABLE AUTHORITIES
(		USERNAME VARCHAR(50) NOT NULL,
     AUTHORITY VARCHAR(68) NOT NULL,
     FOREIGN KEY (USERNAME) REFERENCES USERS(USERNAME)
);

INSERT INTO AUTHORITIES VALUES('employee','ROLE_EMPLOYEE');
INSERT INTO AUTHORITIES VALUES('employee','ROLE_USER');
INSERT INTO AUTHORITIES VALUES('manager','ROLE_MANAGER');
INSERT INTO AUTHORITIES VALUES('manager','ROLE_USER');
```

- '$2a$10$cRqfrdolNVFW6sAju0eNEOE0VC29aIyXwfsEsY2Fz2axy3MnH8ZGa' 는 'pass'를 bcrpyt로 암호 알고리즘으로 인코딩 한 값이다.


## References

- https://www.javainterviewpoint.com/spring-security-jdbcuserdetailsmanager-example/
- https://velog.io/@jwpark06/SpringBoot%EC%97%90-JDBC%EB%A1%9C-Postgresql-%EC%97%B0%EB%8F%99%ED%95%98%EA%B8%B0