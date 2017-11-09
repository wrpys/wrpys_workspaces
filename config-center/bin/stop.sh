#!/bin/bash
cd `dirname $0`
cd ..
PWD=`pwd`
ps -ef | grep -w $PWD/config-center | grep -v grep |awk '{print $2}'|xargs kill -9

