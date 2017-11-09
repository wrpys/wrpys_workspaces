#!/bin/bash
cd `dirname $0`
cd ..
PWD=`pwd`
nohup java -jar $PWD/weixin-1.0.0-SNAPSHOT.jar &

