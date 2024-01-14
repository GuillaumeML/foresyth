### To register a chatter

```ps
Invoke-WebRequest -Uri "http://localhost:8080/register" -Method Post -ContentType "application/json" -Body '{"chatterName": "usser1", "password": "password"}'
```