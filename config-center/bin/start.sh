#!/bin/bash
cd `dirname $0`
cd ..
PWD=`pwd`
nohup java -jar $PWD/config-center-1.0.0-SNAPSHOT.jar &

