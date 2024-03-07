
# 미니프로젝트 1
## 사용 스택
`Java 17` `Spring Boot 3` `JPA` `MySQL`

## 프로젝트 소개
간단한 출퇴근 사내 시스템

## 주요 기능
### 팀 등록 기능
- 회사에 있는 팀을 등록할 수 있다.
- 팀의 필수 정보 :
  - `팀 이름`
### 직원 등록 기능
- 직원을 등록할 수 있다.
- 직원의 필수 정보 :
  - `직원 이름`
  - `팀의 매니저인지 매니저가 아닌지 여부`
  - `회사에 들어온 일자`
  - `생일`
### 팀 조회 기능
- 팀의 모든 정보를 한 번에 조회할 수 있다.
- 예시
    ```json
    [
        {
          "name":"팀 이름",
          "manager":"팀 매니저 이름" // 없을 경우 null
          "memberCount" : 팀 인원 수 [숫자]
      }, 
    ]
    ```
### 직원 조회 기능
- 모든 직원의 정보를 한 번에 조회할 수 있어야 한다.
- 예시
    ```json
    [
        {
            "name" : "직원 이름",
            "teamName" : "소속 팀 이름",
            "role" : "MANAGER" or "MEMBER",
            "birthday : "1989-01-01",
            "workStartDate" : "2024-01-01"
        }, ...
    ]
    ```
## API 명세서
### 직원 등록
`POST /member`    

__Request Body__ 
```json
{
  "name" : "sio1",
  "isManager" : false,
  "birthday" : "1900-01-01",
  "workStateDate" : "2024-03-07" 
}
```
__Response Body__

200 OK

### 직원 조회
`GET /member`

__Response Body__
```json
[
    {
        "name": "sio5",
        "teamName": "토트넘",
        "role": "MEMBER",
        "birthday": "1998-12-26",
        "workStartDate": "2024-01-01"
    },
    {
        "name": "sio6",
        "teamName": "토트넘",
        "role": "MEMBER",
        "birthday": "1998-12-26",
        "workStartDate": "2024-01-01"
    },...
]
```

### 팀 등록
`POST /team`

__Request Body__
```json
{
  "name" : "아스날"
}
```

__Response Body__

200 OK

### 팀 조회
`GET /team`

__Response Body__
```json
[
    {
        "name": "아스날",
        "manager": "sio4",
        "memberCount": 5
    },
    {
        "name": "토트넘",
        "manager": "sio7",
        "memberCount": 4
    }
]
```


## 프로젝트 진행 과정
[프로젝트 최소 설정, 테이블 설계 및 DB 연결 확인](https://github.com/chunghye98/inflearn_spring_study/blob/main/study/day09.md)    
구현 내용은 코드에서 확인 가능하다