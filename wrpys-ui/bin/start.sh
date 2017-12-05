#!/bin/bash
cd `dirname $0`
cd ..
PWD=`pwd`
nohup java -jar $PWD/wrpys-ui-1.0.0-SNAPSHOT.jar &

