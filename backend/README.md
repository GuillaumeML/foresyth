# foresyth

## useful commands

### start the docker database mounted on a volume

```bash
docker run --name forsyth-postgres -e POSTGRES_USER=root -e POSTGRES_PASSWORD=10a2045c829726c141208a385f116a9f -e POSTGRES_DB=forsyth -p 5432:5432 -v postgres_data:/var/lib/postgresql/data -d postgres
```

### Access the Docker Container's Shell
```bash
docker exec -it forsyth-postgres bash

```

### Connect to PostgreSQL
```bash
psql -U root -d forsyth
```