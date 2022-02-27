import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class IMDbWebScraper {

	public static void main(String[] args) throws IOException {
		
		Document doc = Jsoup.connect("https://www.imdb.com/chart/top").timeout(6000).get();
		
		Elements body = doc.select("tbody.lister-list");
		for(Element e : body.select("tr")) {
			String img = e.select("td.posterColumn img").attr("src");
			String czechTitle = e.select("td.posterColumn img").attr("alt");
			System.out.println(czechTitle);
		}
	}

}
