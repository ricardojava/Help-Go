package teste;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class UrlIp {

	public static void main(String[] args) throws MalformedURLException, UnknownHostException {
		// TODO Auto-generated method stub
        
		URL url = new URL("http://www.ntkonline.com.br");
		System.out.println(url.getHost());
		InetAddress address = InetAddress.getByName(url.getHost());
		System.out.println(address.toString());
		
		
	}

}
