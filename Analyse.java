import java.io.*;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.util.*;
import java.util.regex.*;

public class Analyse {
  
 public static void main(String[] args){
 PDDocument pd;
 String att;
 try { 
         //  PDF fil der skal læses
         File input = new File("/home/fall/Desktop/proto2.pdf"); 

         // StringBuilder opbevarer den udtrukkede tekst
         StringBuilder sb = new StringBuilder();
         pd = PDDocument.load(input);
         PDFTextStripper stripper = new PDFTextStripper();

         // Tilføjer text til StringBuilder
         sb.append(stripper.getText(pd));

         // Udtrækker relevant data fra pdf vha. regex.
         // Regex syntax kan findes her:
         // http://www.vogella.com/tutorials/JavaRegularExpressions/article.html
         // Leder efter linjer omsluttet af "//...//"
         Pattern p = Pattern.compile("//\\S+//");

         // Matcher, der leder i texten
         Matcher m = p.matcher(sb);

         while (m.find()){
             // group() metoden sætter teksten ind i variablen att.
             att = m.group();
             System.out.println(att);
         }

         if (pd != null) {
             pd.close();
         }
 } catch (Exception e){
         e.printStackTrace();
        }
     }
} 

