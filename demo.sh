#! /bin/bash
# Copyright 2019 Alfonso Marin Lopez.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at  
# 	  http://www.apache.org/licenses/LICENSE-2.0
#    
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

# description: Demo startup script

FILE_NAME=demo-0.0.1-SNAPSHOT.jar

case "$1" in
  start)
        proc_find=`ps -ef | grep ${FILE_NAME}| grep -v grep`
        if [ "${proc_find}" = '' ]
        then
            cd target
#            nohup java -jar ${FILE_NAME} > /dev/null 2>&1 &
            java -jar ${FILE_NAME} &
            echo Demo started
        else
            echo Demo already started:
            echo ${proc_find}
            exit 1
        fi
        ;;
  stop)
        process=`ps -ef | grep ${FILE_NAME} | grep -v grep | awk '{print $2}'`
        if [ "${process}" != '' ]
        then
            kill -9 ${process}
            echo Demo stopped
        else
            echo Demo not running
            exit 1
        fi
        ;;
  status)
        proc_find=`ps -ef | grep ${FILE_NAME}| grep -v grep`
        if [ "${proc_find}" = '' ]
        then
              echo Demo stopped
        else
              echo Demo started:
              echo ${proc_find}
        fi
        ;;
  restart)
        $0 stop
        sleep 2
        $0 start
        ;;
  *)
        echo $"Usage: $0 {start|stop|restart|status}"
        exit 1
esac

exit 0