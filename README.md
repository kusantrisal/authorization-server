get token
POST localhost:8081/auth/oauth/token Basic auth client id and password and body x-form-urlencoded grant_type password, username and password

check token
GET localhost:8081/auth/oauth/check_token?token=4b592902-8720-4841-9f07-aa0c15a76733

refresh_token
POST localhost:8081/auth/oauth/token noauth body grant_type: refresh_token, refresh_token:<refresh_token>, client_id, client_secreth/token noauth body grant_type: refresh_token, refresh_token:<refresh_token>, client_id, client_secret