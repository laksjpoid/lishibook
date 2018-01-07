function FindProxyForURL(url, host)
{
    if (isInNet(host, "192.168.1.0", "255.255.255.0"))
        return "DIRECT";
 
    return "SOCKS 139.162.25.123:8388";
}
