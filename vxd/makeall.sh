for i in `find . -name '*.java'`; do javac -g -cp ../crimson-1.1.3.jar:/c/Program\ Files/Java/jdk1.8.0_281/lib/tools.jar:.. $i; done
