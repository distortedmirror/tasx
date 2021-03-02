export DISPLAY=:0
cd vxd
echo 'Load Tasks (y/n)?'
read load
if [ "$load" != "y" -a "$load" != "Y" ]; then
java -agentlib:jdwp=transport=dt_shmem,address=jdbconn,server=y,suspend=n -cp ../crimson-1.1.3.jar:/usr/lib/jvm/java-8-openjdk-amd64/lib/tools.jar:.. vxd.vxd $1
else
jdb -classpath ../crimson-1.1.3.jar:/usr/lib/jvm/java-8-openjdk-amd64/lib/tools.jar:.. vxd.vxd ./Work/Tasks/Tasks.xml
fi
