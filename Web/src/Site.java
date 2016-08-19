import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Site {
	
	public static void main(String[] args)
	{
		
		PageBigParser a = new PageBigParser();
		a.Tags(DownloadSite("http://www.unicamp.br/unicamp/"));
	}
	private static String DownloadSite(String site)
	{
		String str="";
		try
		{
		URL url = new URL(site);
		URLConnection con = url.openConnection();
		Pattern p = Pattern.compile("text/html;\\s+charset=([^\\s]+)\\s*");
		Matcher m = p.matcher(con.getContentType());
		String charset = m.matches() ? m.group(1) : "ISO-8859-1";
		Reader r = new InputStreamReader(con.getInputStream(), charset);
		StringBuilder buf = new StringBuilder();
		while (true) {
		  int ch = r.read();
		  if (ch < 0)
		    break;
		  buf.append((char) ch);
		}
		str = buf.toString();
		
		}catch(Exception e){}
		return str;	
	}
}
