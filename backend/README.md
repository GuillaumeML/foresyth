# foresyth

## useful commands

### start the docker database mounted on a volume

```bash
docker run --name forsyth-postgres -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=foresyth -p 5432:5432 -d postgres
```

### Access the Docker Container's Shell
```bash
docker exec -it forsyth-postgres bash

```

### Connect to PostgreSQL
```bash
psql -U postgres -d forsyth
```

# Todo
 - Add liquibase migrations
 - Add volume to database for local dev
 - Create test cases
 - Create infra project
 - Install gitlab on local dev