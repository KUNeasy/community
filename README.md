## 我的社区

## 资料
[Spring io](https://spring.io)  
[ElasticSearch中文社区](https://elasticsearch.cn)   
[Github授权App](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)  
[okhttp](https://square.github.io/okhttp/)  


## 工具
[Git工具](https://git-scm.com/downloads)  
[visual Paradigm](https://www.visual-paradigm.com/cn)
[flyway](https://flywaydb.org/documentation/migrations)

## 脚本
```sql
create table USER
(
	ID int auto_increment not null,
	ACCOUNT_ID VARCHAR(100),
	NAME VARCHAR(50),
	TOKEN CHAR(36),
	GMT_CREATE BIGINT,
	GMT_MODIFIED BIGINT,
	primary key (ID)
);
```
```bash
mvn flyway:migrate
```
