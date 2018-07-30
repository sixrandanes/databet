#!/bin/bash

kill $(ps -aux | grep "java -jar" | awk '{print $2}')
