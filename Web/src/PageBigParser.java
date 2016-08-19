
public class PageBigParser {
	String[] metas;
	String Head;
	String Body;

	
	public String Tags(String CompleteWebPage)
	{
		try
		{
			Head = GetTag("head",CompleteWebPage);
			Body = GetTag("body",CompleteWebPage);
		}
		catch(Exception e)
		{
			return "-----NOT A VALID HTML DOCUMENT-----";
		}
		return "-----TAGS LOADED-----";
	}
	private void CleanMeta(String trash)
	{
		for(int i =0;i<metas.length;i++)
		{
			metas[i]=metas[i].replace(trash, "");
		}
	}
	private void GetMeta()
	{
		
	}
	private String GetTag(String tag,String webpage)
	{
		String[] aux;
		webpage=webpage.toLowerCase();
		aux=webpage.split("<"+tag);
		webpage = aux[1];
		aux=webpage.split("</"+tag);
		return aux[0];	
	}
	
	
	
}
