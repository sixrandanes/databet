#!/bin/bash

./gradlew clean build;
java -jar databet-eureka/build/libs/databet-eureka-0.1.0.jar &
java -jar databet-ref/build/libs/databet-ref-0.1.0.jar &
java -jar databet-cotes/build/libs/databet-cotes-0.1.0.jar &


