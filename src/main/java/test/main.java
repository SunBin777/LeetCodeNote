package test;

public class main {
    /*
        public static void test.main(String[] args) {
            String url = "http://news.sina.com.cn/hotnews/?q_kkhha";
            test.pachong.saveHtml(url);
            // 解析本地html文件
            test.pachong.getLocalHtml("src/temp");
        }*/

    /**
     * 简单的爬虫
     * @param args
     */
    public static void main(String[] args) {
        // 这里采用循环的方式去除列表https://www.zhihu.com/explore/recommendations
        String url = "https://www.zhihu.com/node/ExploreRecommendListV2";
        for (int i = 1; i < 1000; i++) {
            pachong.spiderZH2(url, 59 + i * 20);
        }
    }
}