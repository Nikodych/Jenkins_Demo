#!/bin/bash
mysql --user=oms --password=1qaz2wsx oms < ${0%/*}/OMS_DB_DUMP.sql
