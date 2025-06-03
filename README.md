# 가게 주문번호(Store Order) 서버 모듈
## 개요
* 키오스크 또는 모바일 앱에서 주문하여 받은 번호를 이용자들이 화면에 주문번호의 상태(e.g 조리중, 진행중, 완료됨, 제공)등을 출력하기 위한 서버모듈
* 주문번호의 상태를 관리하고, 주문번호에 대한 정보를 제공하는 API를 제공
* 각 주문번호의 소요시간 관리, 리포트 제공

## 개발환경
* Java 21, Kotlin 2.1.x, Spring Boot 3.4.x

## 설치
* 지원환경
  * OS - Linux, MacOS
  * DBMS - DuckDB, PostgreSQL
* Release 패키지 다운후 압축 해제
  * `tar -xvf store-order-server-[version].tar.gz -C ./`
  * 실행환경에 맞게 실행 
    * Linux - `./bin/startup.sh -Dspring.profiles.active=[local,dev,qa,prod]`
    * Windows - 지원예정
* client 모듈 설치 및 실행 [링크|https://github.com/ALtKEy]