import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupTest {
    /*获取Element对象
     * getElementById​(String id)：根据id属性值获取唯一的element对象
     * getElementsByTag​(String tagName)：根据标签名称获取元素对象集合
     * getElementsByAttribute​(String key)：根据属性名称获取元素对象集合
     * getElementsByAttributeValue​(String key, String value)：根据对应的属性名和属性值获取元素对象集合*/
    public static void main(String[] args) throws IOException {
        String path = JsoupTest.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        //document测试
       /* Elements elements = document.getElementsByTag("age");
        System.out.println(elements);
        System.out.println("====================");
        Elements elements1 = document.getElementsByAttribute("number");
        System.out.println(elements1);
        System.out.println("====================");
        Element element1= document.getElementById("itcast");
        System.out.println(element1);
        System.out.println("====================");
        Elements element2= document.getElementsByAttributeValue("number","heima_0001");
        System.out.println(element2);
        System.out.println("====================");*/

       /*1. 获取子元素对象
					* getElementById​(String id)：根据id属性值获取唯一的element对象
					* getElementsByTag​(String tagName)：根据标签名称获取元素对象集合
					* getElementsByAttribute​(String key)：根据属性名称获取元素对象集合
					* getElementsByAttributeValue​(String key, String value)：根据对应的属性名和属性值获取元素对象集合

				2. 获取属性值
					* String attr(String key)：根据属性名称获取属性值
				3. 获取文本内容
					* String text():获取文本内容
					* String html():获取标签体的所有内容(包括子标签的字符串内容)*/
        Elements elements = document.getElementsByTag("student");
        Elements name = elements.get(0).getElementsByTag("name");
        System.out.println(name);
        System.out.println(elements.get(0).attr("number"));
        System.out.println("=======================");

        Elements student = document.select("student");
        System.out.println(student);
        System.out.println("=======================");
        Elements student1 = document.select(".iboy");
        System.out.println(student1);
        System.out.println("=======================");
        Elements student2 = document.select("#itcast");
        System.out.println(student2);
        System.out.println("=======================");
    }
}
