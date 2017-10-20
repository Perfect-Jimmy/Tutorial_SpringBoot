package com.tutorial.jcseg;

import org.lionsoul.jcseg.tokenizer.core.*;

import java.io.IOException;

/**
 * Created by jimmy on 2017/10/20.
 * 自动摘要/关键句子摘取
 */
public class TextRankSummaryExtractorTest {
    public static void main(String[] args) throws JcsegException, IOException {
        JcsegTaskConfig config = new JcsegTaskConfig(true);
        config.setClearStopwords(true);     //设置过滤停止词
        config.setAppendCJKSyn(false);      //设置关闭同义词追加
        config.setKeepUnregWords(false);    //设置去除不识别的词条

        ADictionary dic = DictionaryFactory.createSingletonDictionary(config, config.isAutoload());

        ISegment seg = SegmentFactory.createJcseg(JcsegTaskConfig.COMPLEX_MODE,new Object[]{config, dic});

        /**
         * 构建TextRankKeywordsExtractor关键字提取器
         */
       // SummaryExtractor extractor = new TextRankSummaryExtractor(seg, new SentenceSeg());

      //  String str = "Jcseg是基于mmseg算法的一个轻量级开源中文分词器，同时集成了关键字提取，关键短语提取，关键句子提取和文章自动摘要等功能，并且提供了最新版本的lucene,%20solr,%20elasticsearch的分词接口。Jcseg自带了一个%20jcseg.properties文件用于快速配置而得到适合不同场合的分词应用。例如：最大匹配词长，是否开启中文人名识别，是否追加拼音，是否追加同义词等！";
        /**
         * 1.获取length长度的句子
         */
       // String summary = extractor.getSummary(new StringReader(str), 64);
       // System.out.println(summary.length());

        /**
         * 2.提取n个关键句子 v2.2.0版本
         */
        /*String string = "you source string here";
        extractor.setWordSeg(seg);        //设置返回的关键句子个数
        List<String> keySentences = extractor.getKeySentence(new StringReader(string));
        System.out.println(keySentences);*/
    }
}


