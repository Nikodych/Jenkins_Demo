#!/bin/bash
mysql --user=oms --password=1qaz2wsx --host=192.168.56.101 --port=3306 oms < ${0%/*}/OMS_DB_DUMP.sql
