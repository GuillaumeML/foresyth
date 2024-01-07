import * as pulumi from "@pulumi/pulumi";
import * as k8s from "@pulumi/kubernetes";

const config = new pulumi.Config();
const isMinikube = config.requireBoolean("isMinikube");

const appName = "foresyth-backend";
const appLabels = { app: appName };
const deployment = new k8s.apps.v1.Deployment(appName, {
    spec: {
        selector: { matchLabels: appLabels },
        replicas: 1,
        template: {
            metadata: { labels: appLabels },
            spec: { containers: [{
                name: appName,
                image: "localhost:5000/foresyth-backend",
                ports: [{ containerPort: 8080 }] // Make sure this matches your app's port
            }] }
        }
    }
});

const service = new k8s.core.v1.Service(appName, {
    metadata: { labels: deployment.spec.template.metadata.labels },
    spec: {
        type: isMinikube ? "ClusterIP" : "LoadBalancer",
        ports: [{ port: 80, targetPort: 8080, protocol: "TCP" }], // targetPort should match containerPort
        selector: appLabels
    }
});

export const ip = isMinikube
    ? service.spec.clusterIP
    : service.status.loadBalancer.apply(lb => lb.ingress[0].ip || lb.ingress[0].hostname);
