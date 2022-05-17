# Syncronized 와 for update문을 이용한 Deadlock 만들기

## 준비

### Docker로 로컬 접속 MySQL 띄우기

1. 도커 이미지 m1 맥북인 경우 플랫폼 명시

docker run --platform linux/amd64 -p 3306:3306 --name mysql -e MYSQL_ROOT_PASSWORD=a -e MYSQL_DATABASE=a -e MYSQL_PASSWORD=a -d mysql

2. 도커 실행 후 들어가서 외부 유저 설정하기

docker exec -it mysql bash

CREATE USER 'a'@'%' IDENTIFIED BY 'a';

GRANT ALL PRIVILEGES ON *.* TO 'a'@'%';

flush privileges;

quit

3. 에디터 설치하고 mysql설정 편집 후 재실행


apt-get update

apt-get install vim

create DATABASE <DB명> default character set utf8 COLLATE utf8_general_ci;

vi /etc/mysql/my.cnf

```
character-set-server = utf8
```


## 과정
* 5/18 순수 JAVA에서 라이브러리를 연결하여 mybatis, mysql을 jdbc로 연결
