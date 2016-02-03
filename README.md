# spring-data-elasticsearch-tutorial
Demonstrates how to feed up ElasticSearch using Spring Data

Prerequisite:

- java 1.8 (must be configured and exist in system path)
- gradle 2.4 (must be configured and exist in system path)
- elastic search 1.5+ (must be _up and running with default config_)

How to run example with Gradle:

1. check out project to you local dir, for example to 'spring-data-elasticsearch-tutorial'
2. go to directory 'spring-data-elasticsearch-tutorial'
3. open console / terminal and type: ```gradle clean build```
4. type: ```gradle run```

If everything went ok, you will see Spring logo in console output
and once per minute log message that another yet 100 documents successful indexed.

How to check it works:

1. go to directory 'spring-data-elasticsearch-tutorial/src/main/resources'
2. open console / terminal and type: ```sh ./count_indexed_documents.sh```
3. you will see how many documents already indexed in ElasticSearch (indexing must occurred at least once at this step)
