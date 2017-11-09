#!/bin/bash
cd `dirname $0`
cd ..
PWD=`pwd`
nohup java -jar $PWD/eureka-server-1.0.0-SNAPSHOT.jar &
