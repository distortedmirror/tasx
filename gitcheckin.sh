
echo 'Delete decrypted XML (y/n)?'
read del
if [ "$del" != "y" -a "$del" != "Y" ]; then
	for i in `find . -name '*.decrypted'`; do rm $i; done
fi
git config --global user.email "mark.brito@gmail.com"; git config --global user.name "Mark Brito"; git add .; git commit; git push
