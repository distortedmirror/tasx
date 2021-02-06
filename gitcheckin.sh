
echo 'Delete decrypted XML (y/n)?'
read del
if [ "$del" != "y" -a "$del" != "Y" ]; then
	for i in `find . -name '*.decrypted'`; do rm $i; done
	for i in `find . -name '*.unencrypted'`; do rm $i; done
fi
echo 'Replace new encrypted XML to main XML(y/n)?'
read repl
if [ "$repl" != "y" -a "$repl" != "Y" ]; then
	for i in `find . -name '*.encrypted'`; do cp $i `echo $i|perl -pe 's/.encrypted//g'`; done
fi
git config --global user.email "mark.brito@gmail.com"; git config --global user.name "Mark Brito"; git add .; git commit; git push
