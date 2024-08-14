# APIAutomation
This repo contsins regression test suite for API.

This is a maven project using cucumber for writing the test scenarios.
Rest Assured is used as a client for sending the request and jackson-databind has been used for deserialization of the response.

Commands to run the project

mvn test
mvn test -x

before every run we need to run the command for goal

mvn clean install 

test-pipeline.yml is used for running the code in azure dev ops
