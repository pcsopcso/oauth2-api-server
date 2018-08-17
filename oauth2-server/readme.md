#1. 토큰 키 생성 테스트 방법 

명령어 입력
curl -X POST http://acme:test@localhost:8080/oauth/token?grant_type=client_credentials

결과값: 
{"access_token":"de50e26a-74f4-4b9a-9d53-da08c96ededa","token_type":"bearer","expires_in":3599,"scope":"read write"}