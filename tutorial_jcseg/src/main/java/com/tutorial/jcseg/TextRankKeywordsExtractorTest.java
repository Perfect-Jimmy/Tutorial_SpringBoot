package com.tutorial.jcseg;

import org.lionsoul.jcseg.extractor.impl.TextRankKeywordsExtractor;
import org.lionsoul.jcseg.tokenizer.core.*;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

/**
 * Created by jimmy on 2017/10/20.
 * 关键字提取
 */
public class TextRankKeywordsExtractorTest {
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
        TextRankKeywordsExtractor extractor = new TextRankKeywordsExtractor(seg);
        extractor.setMaxIterateNum(100);        //设置pagerank算法最大迭代次数，非必须，使用默认即可
        extractor.setWindowSize(5);             //设置textRank计算窗口大小，非必须，使用默认即可
        extractor.setKeywordsNum(15);           //设置最大返回的关键词个数，默认为10

        String str = "现有的分词算法可分为三大类：基于字符串匹配的分词方法、基于理解的分词方法和基于统计的分词方法。按照是否与词性标注过程相结合，又可以分为单纯分词方法和分词与标注相结合的一体化方法。";
        List<String> keywords = extractor.getKeywords(new StringReader(str));
        System.out.println(keywords);
    }
}
/**
 * 分词结果：
 * extractor.setKeywordsNum(10):
 * [分词, 方法, 基于, 分为, 标注, 相结合, 过程, 词性, 是否, 又可]
 * extractor.setKeywordsNum(20):
 * [分词, 方法, 基于, 分为, 标注, 相结合, 过程, 词性, 是否, 又可, 单纯, 按照, 匹配, 字符串, 统计, 大类, 理解, 算法, 一体化, 现有]
 */
