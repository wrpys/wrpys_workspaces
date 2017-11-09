#!/bin/bash
cd `dirname $0`
cd ..
PWD=`pwd`
ps -ef | grep -w $PWD/eureka-server | grep -v grep |awk '{print $2}'|xargs kill -9
