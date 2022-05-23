# learn-springboot

This example code will explain CI/CD integration

- Code build using github action
- create docker image and push to docker hub
- Deploy docker image to kubernates

Kubernates command:-

Create pod:-

kubectl run javachello --image=<IMAGE_NAME>

Create service:-
apiVersion: v1
kind: Service
metadata:
  name: javahello
  labels:
    name: javahello
    app: javahello
spec:
  type: NodePort
  ports:
    - port: 8081
      targetPort: 8081
      nodePort: 30002
  selector:
    run: javachello


--Access page using below url
http://<IP>:30002/
