# Resource 서버 테스트 방법

## 1. Oauth2 서버에서 토큰을 얻는다
curl -X POST http://acme:test@localhost:8080/oauth/token?grant_type=client_credentials

결과값: 
{"access_token":"de50e26a-74f4-4b9a-9d53-da08c96ededa","token_type":"bearer","expires_in":3599,"scope":"read write"}

## 2. 얻은 토큰으로 다음 명령업 입력한다.
   curl --header "Authorization: Bearer de50e26a-74f4-4b9a-9d53-da08c96ededa" "http://localhost:8081/users"

결과값:

{
    "_embedded": {
        "users": [
            {
                "username": "ironman",
                "password": "$2a$10$Yi7rQ5lpVxNyWPxQXN75vOZeEwFU1pST0Wel3YghW/fsxupFeiKyy",
                "name": "토니스타크",
                "enabled": true,
                "authorities": [
                    {
                        "authority": "ROLE_USER"
                    }
                ],
                "credentialsNonExpired": true,
                "accountNonExpired": true,
                "accountNonLocked": true,
                "_links": {
                    "self": {
                        "href": "http://localhost:8081/users/1"
                    },
                    "user": {
                        "href": "http://localhost:8081/users/1"
                    }
                }
            },
            {
                "username": "hulk",
                "password": "$2a$10$Yi7rQ5lpVxNyWPxQXN75vOZeEwFU1pST0Wel3YghW/fsxupFeiKyy",
                "name": "브루스 배너",
                "enabled": true,
                "authorities": [
                    {
                        "authority": "ROLE_USER"
                    }
                ],
                "credentialsNonExpired": true,
                "accountNonExpired": true,
                "accountNonLocked": true,
                "_links": {
                    "self": {
                        "href": "http://localhost:8081/users/2"
                    },
                    "user": {
                        "href": "http://localhost:8081/users/2"
                    }
                }
            },
            {
                "username": "antman",
                "password": "$2a$10$Yi7rQ5lpVxNyWPxQXN75vOZeEwFU1pST0Wel3YghW/fsxupFeiKyy",
                "name": "스콧",
                "enabled": true,
                "authorities": [
                    {
                        "authority": "ROLE_USER"
                    }
                ],
                "credentialsNonExpired": true,
                "accountNonExpired": true,
                "accountNonLocked": true,
                "_links": {
                    "self": {
                        "href": "http://localhost:8081/users/3"
                    },
                    "user": {
                        "href": "http://localhost:8081/users/3"
                    }
                }
            },
            {
                "username": "tor",
                "password": "$2a$10$Yi7rQ5lpVxNyWPxQXN75vOZeEwFU1pST0Wel3YghW/fsxupFeiKyy",
                "name": "크리스 헴스워스",
                "enabled": true,
                "authorities": [
                    {
                        "authority": "ROLE_USER"
                    }
                ],
                "credentialsNonExpired": true,
                "accountNonExpired": true,
                "accountNonLocked": true,
                "_links": {
                    "self": {
                        "href": "http://localhost:8081/users/4"
                    },
                    "user": {
                        "href": "http://localhost:8081/users/4"
                    }
                }
            },
            {
                "username": "backwidow",
                "password": "$2a$10$Yi7rQ5lpVxNyWPxQXN75vOZeEwFU1pST0Wel3YghW/fsxupFeiKyy",
                "name": "스칼릿 조핸슨",
                "enabled": true,
                "authorities": [
                    {
                        "authority": "ROLE_USER"
                    }
                ],
                "credentialsNonExpired": true,
                "accountNonExpired": true,
                "accountNonLocked": true,
                "_links": {
                    "self": {
                        "href": "http://localhost:8081/users/5"
                    },
                    "user": {
                        "href": "http://localhost:8081/users/5"
                    }
                }
            },
            {
                "username": "hawkeye",
                "password": "$2a$10$Yi7rQ5lpVxNyWPxQXN75vOZeEwFU1pST0Wel3YghW/fsxupFeiKyy",
                "name": "클린트 바튼",
                "enabled": true,
                "authorities": [
                    {
                        "authority": "ROLE_USER"
                    }
                ],
                "credentialsNonExpired": true,
                "accountNonExpired": true,
                "accountNonLocked": true,
                "_links": {
                    "self": {
                        "href": "http://localhost:8081/users/6"
                    },
                    "user": {
                        "href": "http://localhost:8081/users/6"
                    }
                }
            }
        ]
    },
    "_links": {
        "self": {
            "href": "http://localhost:8081/users{?page,size,sort}",
            "templated": true
        },
        "profile": {
            "href": "http://localhost:8081/profile/users"
        },
        "search": {
            "href": "http://localhost:8081/users/search"
        }
    },
    "page": {
        "size": 20,
        "totalElements": 6,
        "totalPages": 1,
        "number": 0
    }
}