# foresyth

## useful commands

### start the docker database mounted on a volume for dev

```bash
docker run --name forsyth-postgres -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=foresyth -p 5432:5432 -v /home/user/postgres-data-dev:/var/lib/postgresql/data -d postgres

```

### Access the Docker Container's Shell
```bash
docker exec -it forsyth-postgres bash

```

### Connect to PostgreSQL
```bash
psql -U postgres
```

### Common database commands
#### list databases
```
\l
```

### Common docker commands
```bash
sudo docker stop forsyth-postgres
```

### Lint the code
```bash
mvn com.github.gantsign.maven:ktlint-maven-plugin:3.0.0:format
```
# Todo
 - Add volume to database for local dev
 - Create test cases
 - Create infra project
 - Install gitlab on local dev