for i in `find . -name '*.java'`; do javac -cp /usr/lib/jvm/java-8-openjdk-amd64/lib/tools.jar:.. $i; done
