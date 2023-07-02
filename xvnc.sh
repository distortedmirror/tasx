export DISPLAY=:1
killall xfwm4 > /dev/null
killall firefox > /dev/null
vncserver --kill
/data/data/com.termux/files/usr/bin/Xvnc :1 -listen tcp -auth /data/data/com.termux/files/home/.Xauthority -desktop localhost:1 -fp /data/data/com.termux/files/usr/share/fonts/75dpi -geometry 1600x720 -rfbauth /data/data/com.termux/files/home/.vnc/passwd -rfbport 5901 -rfbwait 30000 &
xfwm4 &
sleep 2
firefox --no-remote &
xterm -rv &
cd tasx
./start.sh
