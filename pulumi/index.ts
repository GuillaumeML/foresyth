import * as pulumi from "@pulumi/pulumi";
import * as k8s from "@pulumi/kubernetes";

const config = new pulumi.Config();
const isMinikube = config.requireBoolean("isMinikube");

const appName = "foresyth-backend";
const appLabels = { app: appName };
const deployment = new k8s.apps.v1.Deployment("foresyth-backend-deployment", {
    spec: {
        selector: { matchLabels: appLabels },
        replicas: 1,
        template: {
            metadata: { labels: appLabels },
            spec: { containers: [{
                name: appName,
                image: "localhost:5000/foresyth-backend",
                ports: [{ containerPort: 8080 }],
                env: [
                { name: "SPRING_PROFILES_ACTIVE", value: "nonprod" }
                ]
            }] }
        }
    }
});

const service = new k8s.core.v1.Service("foresyth-backend-service", {
    metadata: {
        labels: deployment.spec.template.metadata.labels,
        name: "foresyth-backend-service"
    },
    spec: {
                type: "NodePort", // Change to NodePort
                ports: [{ port: 80, targetPort: 8080, protocol: "TCP" }], // targetPort should match containerPort
                selector: appLabels
            }
});



const postgresDeployment = new k8s.apps.v1.Deployment("postgres-deployment", {
    spec: {
        selector: { matchLabels: { app: "postgres" } },
        replicas: 1,
        template: {
            metadata: { labels: { app: "postgres" } },
            spec: {
                containers: [{
                    name: "postgres",
                    image: "postgres:latest",
                    env: [
                        { name: "POSTGRES_DB", value: "postgres" },
                        { name: "POSTGRES_USER", value: "postgres" },
                        { name: "POSTGRES_PASSWORD", value: "postgres" }
                    ],
                    ports: [{ containerPort: 5432 }]
                }],
            },
        },
    },
});

 const postgresService = new k8s.core.v1.Service("postgres-service", {
     metadata: {
         name: "postgres-service", // Explicitly set the service name
     },
     spec: {
         type: "ClusterIP",
         ports: [{ port: 5432, targetPort: 5432 }],
         selector: { app: "postgres" },
     },
 });


export const ip = isMinikube
    ? service.spec.clusterIP
    : service.status.loadBalancer.apply(lb => lb.ingress[0].ip || lb.ingress[0].hostname);
