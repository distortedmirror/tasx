if [ ! -f /usr/bin/browser ]; then
  ln /usr/bin/firefox-esr /usr/bin/browser
fi
cd vxd
echo 'Load Tasks (y/n)?'
read load
if [ "$load" != "y" ]; then
java -cp /usr/lib/jvm/java-8-openjdk-amd64/lib/tools.jar:.. vxd.vxd 
else
java -cp /usr/lib/jvm/java-8-openjdk-amd64/lib/tools.jar:.. vxd.vxd ./Work/Tasks/Tasks.xml
fi
