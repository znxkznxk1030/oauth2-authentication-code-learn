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

\# \c dbcom arthur
```
