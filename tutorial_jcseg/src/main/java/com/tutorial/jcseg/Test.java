package com.tutorial.jcseg;

import org.lionsoul.jcseg.tokenizer.core.JcsegException;

import java.io.IOException;

/**
 * Created by jimmy on 2017/10/18.
 */
public class Test {

    public static void main(String[] args) throws JcsegException, IOException {
       /**
         * 1.JcsegTaskConfig配置实例,autoLoad=true会自动查找配置来初始化
         */
        /*JcsegTaskConfig config = new JcsegTaskConfig(true);
        config.setAppendCJKSyn(true);
        *//**
         * 2.创建ADictionary分词词库实例
         * ADictionary会依据JcsegTaskConfig里面的词库信息加载全部有效的词库
         * config.isAutoload()对应properties文件里面的lexicon.autoload,true创建同步词库,反之就是非同步词库
         *//*
        ADictionary dic = DictionaryFactory.createDefaultDictionary(config,config.isAutoload());

        *//**
         * 3.创建ISegment
         * JcsegTaskConfig.COMPLEX_MODE:复杂分词对象.
         * JcsegTaskConfig.SIMPLE_MODE:简易分词对象.
         * JcsegTaskConfig.DETECT_MODE:DetectSeg Isegmengt分词对象.
         * JcsegTaskConfig.SEARCH_MODE表示:SearchSeg Isegmengt分词对象.
         * JcsegTaskConfig.DELIMITER_MODE表:DelimiterSeg Isegmengt分词对象.
         * JcsegTaskConfig.NLP_MODE表:NLPSeg Isegmengt分词对象.
         *//*
        ASegment seg = (ASegment) SegmentFactory.createJcseg(JcsegTaskConfig.COMPLEX_MODE,new Object[]{config, dic});

        *//**
         * 4.设置要分词的内容
         *//*
        String str = "jcseg是使用Java开发的一款开源的中文分词器, 使用mmseg算法. 分词准确率高达98.4%.";
        seg.reset(new StringReader(str));

        *//**
         * 5. 获取分词结果
         *//*
        IWord word = null;
        while ( (word = seg.next()) != null ) {
            System.out.print(word.getValue() + "|");
        }*/


 /*   public static void main(String[] args) throws Exception {
        Analyzer analyzer = new JcsegAnalyzer5X(JcsegTaskConfig.COMPLEX_MODE);
        // 非必须(用于修改默认配置): 获取分词任务配置实例
        JcsegAnalyzer5X jcseg = (JcsegAnalyzer5X) analyzer;
        JcsegTaskConfig config = jcseg.getTaskConfig();
        // 追加同义词到分词结果中, 需要在 jcseg.properties 中配置 jcseg.loadsyn=1
        config.setAppendCJKSyn(true);
        // 追加拼音到分词结果中, 需要在 jcseg.properties 中配置 jcseg.loadpinyin=1
        config.setAppendCJKPinyin(true);*/
      /*  // 更多配置, 请查看 com.webssky.jcseg.core.JcsegTaskConfig 类
        // ====建立索引
        // 建立内存索引对象
        Directory directory = new RAMDirectory();
        IndexWriterConfig iwConfig = new IndexWriterConfig(analyzer);
        iwConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
        IndexWriter iwriter = new IndexWriter(directory, iwConfig);

        Connection conn = QueryDataFromDb.getConnection();
        Statement st = conn.createStatement();
        long count = 0;
        for(int i = 0 ; i < 10; i ++){
            String query = "select * from student limit "+ i * 100000+","+ 100000;
            ResultSet result = st.executeQuery(query);
            while (result.next()) {
                Document document = new Document();
                document.add(new StringField("id", result.getString("id"),
                        Field.Store.YES));
                document.add(new TextField("name", result
                        .getString("name"), Field.Store.YES));
                document.add(new StringField("math", result
                        .getString("math"), Field.Store.YES));
                iwriter.addDocument(document);
                count ++;
            }
        }
        System.out.println("Total record : "+count);

        iwriter.commit();
        iwriter.close();

        // ==搜索
        IndexReader ireader = DirectoryReader.open(directory);
        IndexSearcher isearcher = new IndexSearcher(ireader);
        String keyword = "你好";
        // 使用QueryParser查询分析器构造Query对象
        QueryParser qp = new QueryParser("name", analyzer);
        qp.setDefaultOperator(QueryParser.AND_OPERATOR);
        Query query = qp.parse(keyword);
        System.out.println("Query = " + query);
        long start = System.currentTimeMillis();
        //搜索相似度最高的2条记录
        System.out.println("搜索相似度最高的2条记录");
        TopDocs topDocs = isearcher.search(query, 2);
        System.out.println("命中：" + topDocs.totalHits);
        for (ScoreDoc sd : topDocs.scoreDocs) {
            Document doc = isearcher.doc(sd.doc);
            System.out.println("id:" + doc.get("id"));
            System.out.println("name:" + doc.get("name"));
            System.out.println("math:" + doc.get("math"));
        }
        System.out.println("Spend time:"+(System.currentTimeMillis() - start) + " ms");*/
    }

}
