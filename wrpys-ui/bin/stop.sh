#!/bin/bash
cd `dirname $0`
cd ..
PWD=`pwd`
ps -ef | grep -w $PWD/wrpys-ui | grep -v grep |awk '{print $2}'|xargs kill -9

