iptables --flush

iptables -A INPUT -i lo -j ACCEPT
iptables -A INPUT -m state --state INVALID -j DROP
iptables -A INPUT -m state --state RELATED,ESTABLISHED -j ACCEPT
iptables -A INPUT -j DROP

iptables -A OUTPUT -o lo -j ACCEPT
iptables -A OUTPUT -m state --state INVALID -j DROP
iptables -A OUTPUT -m state --state RELATED,ESTABLISHED -j ACCEPT
iptables -A OUTPUT -p tcp -m tcp --dport 22 -j ACCEPT
iptables -A OUTPUT -p tcp -m tcp --dport 53 -j ACCEPT
iptables -A OUTPUT -p udp -m udp --dport 53 -j ACCEPT
iptables -A OUTPUT -p tcp -m tcp --dport 5353 -j ACCEPT
iptables -A OUTPUT -p udp -m udp --dport 5353 -j ACCEPT
iptables -A OUTPUT -p tcp -m tcp --dport 80 -j ACCEPT
iptables -A OUTPUT -p tcp -m tcp --dport 443 -j ACCEPT
iptables -A OUTPUT -j DROP
