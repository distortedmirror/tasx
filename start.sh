export CHROMIUM_FLAGS="--incognito".
if [ ! -f /usr/bin/browser ]; then
  ln /usr/bin/chromium /usr/bin/browser
fi
cd vxd
echo 'Load Tasks (y/n)?'
read load
if [ "$load" != "y" -a "$load" != "Y" ]; then
java -cp 
../crimson-1.1.3.jar:/usr/lib/jvm/java-8-openjdk-amd64/lib/tools.jar:.. vxd.vxd 
else
java -cp ../crimson-1.1.3.jar:/usr/lib/jvm/java-8-openjdk-amd64/lib/tools.jar:.. vxd.vxd ./Work/Tasks/Tasks.xml
fi
