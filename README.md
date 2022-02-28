## 폴더구조
- bo
    - 백엔드 소스
    - spring boot
- postgres
    - 도커용 db
    - docker compose 실행전 'data폴더 생성' 필요
    - postgres14 + postgis extenstion 추가

## spring boot jar파일 생성
- mven package
## 도커실행
- 다운로드 받은 git 폴더 루트로 이동
- docker compose up

## db 정보
- host
    - localhost
- 포트
    - 5432
- 계정
    - postgres / 12345
- database
    - gis
    - CREATE DATABASE gis
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'en_US.utf8'
    LC_CTYPE = 'en_US.utf8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
- table 생성
    - CREATE TABLE IF NOT EXISTS public.aoi
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    name text COLLATE pg_catalog."default" NOT NULL,
    area geometry(Polygon,4326) NOT NULL,
    CONSTRAINT aoi_pkey PRIMARY KEY (id)
)

    - CREATE TABLE IF NOT EXISTS public.region
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    name text COLLATE pg_catalog."default" NOT NULL,
    area geometry(Polygon,4326) NOT NULL,
    CONSTRAINT region_pkey PRIMARY KEY (id)
)



## API 구성
- 관심지역 저장
    - http://localhost:8080/aoi 
    - post
    - request body
        - {
    "name": "서울시",
    "area": [
        {
            "x": 126.835,
            "y": 37.688
        },
        {
            "x": 127.155,
            "y": 37.702
        },
        {
            "x": 127.184,
            "y": 37.474
        },
        {
            "x": 126.821,
            "y": 37.454
        },
        {
            "x": 126.835,
            "y": 37.688
        }
    ]
}
- 행정지역 저장
    - http://localhost:8080/region
    - post
    - request body
     - {
    "name": "서울시",
    "area": [
        {
            "x": 126.835,
            "y": 37.688
        },
        {
            "x": 127.155,
            "y": 37.702
        },
        {
            "x": 127.184,
            "y": 37.474
        },
        {
            "x": 126.821,
            "y": 37.454
        },
        {
            "x": 126.835,
            "y": 37.688
        }
    ]
}
- 행정지역에 지리적으로 포함되는 관심지역을 조회
    - 과제 미완료


## 기술스택
- docker-compose
- spring boot 
- postgis
- jpa, Hibernate Spatial
