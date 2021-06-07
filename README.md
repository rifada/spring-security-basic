# spring-security-basic
springboot-security-basic

> ### Develope Env
> - Spring boot 2.5.0
> - openjdk 11

============

> ### Dependency
> - spring-boot-starter-web
> - spring-boot-starter-security
> - spring-boot-starter-data-jpa
> - h2
> - lombok

============

> ### Usage
> 1. Memebr Controller (permitAll - 모두가 접근 가능) 
>   - /new(POST) 신규 사용자 등록 (username, password)
>   - /list(GET) 사용자 전체 조회 
> 2. Api Controller (Authenticated - 인증된 사용자만 접근 가능)
>   - /sale, /order, /release (GET)  
