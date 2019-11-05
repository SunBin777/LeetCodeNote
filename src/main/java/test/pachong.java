package test;

import com.google.gson.Gson;
import org.jsoup.Jsoup;

import javax.enterprise.inject.New;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class pachong {
    /**
     *
     * @Title: saveHtml
     * @Description: 将抓取过来的数据保存到本地或者json文件
     * @return void 返回类型
     * @author liangchu
     * @date 2017-12-28 下午12:23:05
     * @throws
     */
    public static void saveHtml(String url) {
        try {
            // 这是将首页的信息存入到一个html文件中 为了后面分析html文件里面的信息做铺垫
            File dest = new File("src/temp/reptile.html");
            // 接收字节输入流
            InputStream is;
            // 字节输出流
            FileOutputStream fos = new FileOutputStream(dest);
            URL temp = new URL(url);
            // 这个地方需要加入头部 避免大部分网站拒绝访问
            // 这个地方是容易忽略的地方所以要注意
            URLConnection uc = temp.openConnection();
            // 因为现在很大一部分网站都加入了反爬虫机制 这里加入这个头信息
            uc.addRequestProperty(
                    "User-Agent",
                    "Mozilla/5.0 "
                            + "(iPad; U; CPU OS 4_3_3 like Mac OS X; en-us) "
                            + "AppleWebKit/533.17.9"
                            + " (KHTML, like Gecko) Version/5.0.2 Mobile/8J2 Safari/6533.18.5");
            is = temp.openStream();
            // 为字节输入流加入缓冲
            BufferedInputStream bis = new BufferedInputStream(is);
            // 为字节输出流加入缓冲
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            int length;
            byte[] bytes = new byte[1024 * 20];
            while ((length = bis.read(bytes, 0, bytes.length)) != -1) {
                fos.write(bytes, 0, length);
            }
            bos.close();
            fos.close();
            bis.close();
            is.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /*
     * 解析本地的html文件获取对应的数据
     */
    public static void getLocalHtml(String path) {
        // 读取本地的html文件
        File file = new File(path);
        // 获取这个路径下的所有html文件
        File[] files = file.listFiles();
        List<New> news = new ArrayList<New>();
        HttpServletResponse response = null;
        HttpServletRequest request = null;
        int tmp=1;
        // 循环解析所有的html文件
        try {
            for (int i = 0; i < files.length; i++) {

                // 首先先判断是不是文件
                if (files[i].isFile()) {
                    // 获取文件名
                    String filename = files[i].getName();
                    // 开始解析文件

                    Document doc = Jsoup.parse(files[i], "UTF-8");
                    // 获取所有内容 获取新闻内容
                    Elements contents = doc.getElementsByClass("ConsTi");
                    for (Element element : contents) {
                        Elements e1 = element.getElementsByTag("a");
                        for (Element element2 : e1) {
                            //System.out.print(element2.attr("href"));
                            // 根据href获取新闻的详t情信息
                            String newText = desGetUrl(element2.attr("href"));
                            // 获取新闻的标题
                            String newTitle = element2.text();
                            exportFile(newTitle, newText);
                            System.out.println("抓取成功。。。"+(tmp));
                            tmp++;

                        }
                    }
                }

            }

            //excelExport(news, response, request);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     *
     * @Title: desGetUrl
     * @Description: 根据url获取连接地址的详情信息
     * @param @param url 参数
     * @return void 返回类型
     * @author liangchu
     * @date 2017-12-28 下午1:57:45
     * @throws
     */
    public static String desGetUrl(String url) {
        String newText="";
        try {
            Document doc = Jsoup
                    .connect(url)
                    .userAgent(
                            "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0; MALC)")
                    .get();
            // System.out.println(doc);
            // 得到html下的所有东西
            //Element content = doc.getElementById("article");
            Elements contents = doc.getElementsByClass("article");
            if(contents != null && contents.size() >0){
                Element content = contents.get(0);
                newText = content.text();
            }
            //System.out.println(content);
            //return newText;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return newText;
    }
    /*
     * 将新闻标题和内容写入文件
     */
    public static void exportFile(String title,String content){

        try {
            File file = new File("C:/Users/云仓配-ITDev/Desktop/xinwen.txt");

            if (!file.getParentFile().exists()) {//判断路径是否存在，如果不存在，则创建上一级目录文件夹
                file.getParentFile().mkdirs();
            }
            FileWriter fileWriter=new FileWriter(file, true);
            fileWriter.write(title+"----------");
            fileWriter.write(content+"\r\n");
            fileWriter.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }









    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     *
     * @Title: spiderZH2
     * @Description: 这里是采用httpclient包发送请求 获取需要加载的列表
     * @param @param url    参数url地址 offset 根据offset显示问题信息列表
     * @return void 返回类型
     * @author  liangchu
     * @date 2017-12-31 下午2:11:23
     * @throws
     */
    public static void spiderZH2(String url,int offset){
        try {
            //String curl ="https://www.zhihu.com/node/ExploreRecommendListV2";
            Map<String,Object> createMap = new HashMap<String,Object>();
            String charset = "utf-8";
            // method 提交的参数
            createMap.put("method", "next");
            Map<String,Object> map = new HashMap<String, Object>();
            // 分页显示的数据
            map.put("limit", 20);
            map.put("offset", offset);
            createMap.put("method", "next");
            Gson gson = new Gson();
            String mapStr = gson.toJson(map);
            // 请求的参数
            createMap.put("params", mapStr);
            // 根据httpclient模仿post请求
            String httpOrgCreateTestRtn = HttpClientUtil.doPost(url,createMap,charset);
            Map maps = gson.fromJson(httpOrgCreateTestRtn, Map.class);
            String html = maps.get("msg").toString();
            Document doc = Jsoup.parse(html);
            Elements elements =
                    doc.select("div[class=zm-item]").select("h2").
                            select("a[class=question_link]");
            File file = new File("F:/replite/zhifuwenda.txt");
            // 遍历每个问题节点
            for (Element question : elements) {
                // 获取连接地址
                String qUrl = question.attr("href");
                // 这里需要判断urlhttp格式
                if(!qUrl.contains("https://")){
                    qUrl = "https://www.zhihu.com"+qUrl;
                }
                Document document2=Jsoup.connect(qUrl)
                        .userAgent("Mozilla/5.0 "
                                + "(iPad; U; CPU OS 4_3_3 like Mac OS X; en-us) "
                                + "AppleWebKit/533.17.9"
                                + " (KHTML, like Gecko) Version/5.0.2 Mobile/8J2 Safari/6533.18.5")
                        .get();
                // 问题标题
                Elements title = document2.select("#root").select("div").select("main").
                        select("div").select("div:nth-child(10)").select("div.QuestionHeader").
                        select("div.QuestionHeader-content").select("div.QuestionHeader-main").
                        select("h1");
                // 回答问题的内容
                Elements content = document2.select("#root").select("div").select("main").
                        select("div").select("div.Question-main").select("div.Question-mainColumn").
                        select("div.Card.AnswerCard").select("div").select("div").
                        select("div.RichContent.RichContent--unescapable").
                        select("div.RichContent-inner");
                if (!file.getParentFile().exists()) {//判断路径是否存在，如果不存在，则创建上一级目录文件夹
                    file.getParentFile().mkdirs();
                }
                FileWriter fileWriter=new FileWriter(file, true);
                fileWriter.write("=============链接:"+qUrl+"\r\n");
                fileWriter.write("=============标题:"+title.get(0).text()+"\r\n");
                fileWriter.write("=============回答:"+content.get(0).text()+"\r\n");
                fileWriter.close();
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
