## Usefull commands

### Deploy stack

```shell
pulumi up
```

### Start minikube

On windows, you need to have hyper-v configured on your machine,
docker desktop installed.

Then run the commands with administrator privileges

https://minikube.sigs.k8s.io/docs/handbook/registry/

### Start minikube
```shell
minikube start
```
### Local Port 5000 Mapping to Kubernetes System Registry Service
```shell
minikube addons enable registry
```
### Local Port 5000 Mapping to Kubernetes System Registry Service
```shell
kubectl port-forward --namespace kube-system service/registry 5000:80
```
### Alpine Container Setup for Docker Image Push to Minikube
```shell
docker run --rm -it --network=host alpine ash -c "apk add socat && socat TCP-LISTEN:5000,reuseaddr,fork TCP:host.docker.internal:5000"
```

## Useful powershell maintenance scripts 

# Get scale down all replicas to 0
```ps
# Get the list of deployments
$deployments = kubectl get deployments -o jsonpath='{.items[*].metadata.name}'
# Iterate over the deployments and scale each to 0 replicas
$deployments -split ' ' | ForEach-Object {
kubectl scale deployment $_ --replicas=0
}
```

# Delete all deployments
```ps
# Get the list of deployments
$deployments = kubectl get deployments -o jsonpath='{.items[*].metadata.name}'

# Iterate over the deployments and delete each one
$deployments -split ' ' | ForEach-Object {
    kubectl delete deployment $_
}
```