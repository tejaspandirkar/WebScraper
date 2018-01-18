/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urlscraper;

/**
 *
 * @author Tejas Pandirkar
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class UrlScraper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            Document doc = Jsoup.connect("https://www.google.co.in/?gfe_rd=cr&dcr=0&ei=z2dgWqakO6vv8wfay5LQBg").get();
            
            Document doc2 = Jsoup.parse("https://www.google.co.in/?gfe_rd=cr&dcr=0&ei=z2dgWqakO6vv8wfay5LQBg");
            FileWriter fw1 = new FileWriter("D:/Tejas/Scraper/getUrlData.txt");
           
            String title = doc.title();
            System.out.println("Title : "+title);
            StringBuilder sb = new StringBuilder("Data from Url");
            StringBuilder sb2 = new StringBuilder(doc.toString());
            //sb.append("Title : "+ title + "\n");
            Elements links = doc.select("a[href]");          
            
            for (Element link: links){
                System.out.println("\nLink: "+link.attr("href"));
                sb.append("\n Link: "+link.attr("href"));
                System.out.println("Link Text : "+link.text());
                sb.append("Link Text: "+link.text()+"\n");
            }
            fw1.write(sb2.toString());
                       
            fw1.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
        
    }
    
}
