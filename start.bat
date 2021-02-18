cd vxd
copy Work\Tasks\Tasks.xml.encrypted Work\Tasks\Tasks.xml
java -cp C:\Users\mark\Downloads\openjdk-8u41-b04-windows-i586-14_jan_2020\java-se-8u41-ri\lib\tools.jar;.. vxd.vxd ./Work/Tasks/Tasks.xml
cd Work\Tasks\
copy Tasks.xml.encrypted Tasks.xml 
cd ..\..\..

