# learn-springboot

Modules covered
- Core Spring
- Spring boot
- Spring AOP
- Spring actuator
- Spring Security
- JPA/Hibernate (mysql)
- Exception handling
- Annotation
- Graphql
- Kafka integration
- Cassandra integration

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

Kafka Integration
------------------
- Install Kafka from https://kafka.apache.org/quickstart

- Download and unzip

Execute below command

cd Kafka/bin
zookeeper-server-start ../config/zookeeper.properties

kafka-server-start ../config/server.properties

kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test-topic

--execute below command if you want to read message on console (optional)
kafka-console-consumer --bootstrap-server localhost:9092 --topic test-topic --from-beginning

Cassandra Integration
------------------------
- Download cassandra 
- Execute below command

cd cassandra

Create below folders
- data
- logs
- tools
- pylib

go to bin folder
execute cassandra
execute in different tab cqlsh

Create keyspace:
CREATE KEYSPACE learnsb
WITH REPLICATION = {
'class' : 'SimpleStrategy',
'replication_factor' : 1
};

use learnsb;

Create table:
create table customer1 (
  id int primary key,
  cust_name varchar
);

