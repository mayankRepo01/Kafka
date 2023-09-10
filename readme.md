Install Kafka Using below Steps

STEP 1: GET KAFKA
Download the latest Kafka release and extract it:

$ tar -xzf kafka_2.13-3.5.0.tgz
$ cd kafka_2.13-3.5.0
STEP 2: START THE KAFKA ENVIRONMENT
NOTE: Your local environment must have Java 8+ installed.

Apache Kafka can be started using ZooKeeper or KRaft. To get started with either configuration follow one the sections below but not both.

Kafka with ZooKeeper
Run the following commands in order to start all services in the correct order:

# Start the ZooKeeper service
$ bin/zookeeper-server-start.sh config/zookeeper.properties
Open another terminal session and run:

# Start the Kafka broker service
$ bin/kafka-server-start.sh config/server.properties


Use the below  curl for sending a sample json

curl --location 'http://localhost:8080/api/vi/kafka/publishjson' \
--header 'Content-Type: application/json' \
--data '{
    "id" :"123",
    "name": "mayank",
    "age" : "24"
}'

Now check the logs message will be there
