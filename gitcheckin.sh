#for i in `find . -name '*.decrypted'`; do rm $i; done
#for i in `find . -name '*.unencrypted'`; do rm $i; done
#or i in `find . -name '*.encrypted'`; do echo cp $i `echo $i|perl -pe 's/.encrypted//g'`; done
git config --global user.email "mark.brito@gmail.com"; git config --global user.name "Mark Brito"; git add .; git commit; git push
