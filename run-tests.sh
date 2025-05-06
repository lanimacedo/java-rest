#!/bin/bash
mvn clean test
allure serve target/allure/custom-results
