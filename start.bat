cd vxd
copy Work\Tasks\Tasks.xml.encrypted Work\Tasks\Tasks.xml
java -cp "C:\Program Files\Java\jdk1.8.0_281\lib\dt.jar";"C:\Program Files\Java\jdk1.8.0_281\lib\tools.jar";..\..\crimson-1.1.3.jar;.. vxd.vxd ./Work/Tasks/Tasks.xml
cd Work\Tasks\
copy Tasks.xml.encrypted Tasks.xml 
cd ..\..\..

