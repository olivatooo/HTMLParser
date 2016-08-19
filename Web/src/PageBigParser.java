
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
	private void CleanMetas(String trash)
	{
		try
		{
		for(int i =0;i<metas.length;i++)
		{
			metas[i]=metas[i].replace(trash, "");
		}
		}
		catch(Exception e){e.printStackTrace();}
	}
	private void GetMeta(String head)
	{
	  String[] aux;
	  head=head.toLowerCase();
	  aux=head.split("<meta");
	  metas = aux;
	  aux=aux[aux.length].split(">");
	  metas[metas.length]=aux[0];
	  CleanMetas("content");
	  CleanMetas(">");
	  CleanMetas("");
	  
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
