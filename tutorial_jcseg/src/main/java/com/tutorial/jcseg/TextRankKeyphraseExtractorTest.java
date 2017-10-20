package com.tutorial.jcseg;

import org.lionsoul.jcseg.extractor.impl.TextRankKeyphraseExtractor;
import org.lionsoul.jcseg.tokenizer.core.*;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

/**
 * Created by jimmy on 2017/10/20.
 * 关键短语
 */
public class TextRankKeyphraseExtractorTest {
    public static void main(String[] args) throws JcsegException, IOException {
        JcsegTaskConfig config = new JcsegTaskConfig(true);
        config.setClearStopwords(false);    //设置不过滤停止词
        config.setAppendCJKSyn(false);      //设置关闭同义词追加
        config.setKeepUnregWords(false);    //设置去除不识别的词条
        config.setEnSecondSeg(false);       //关闭英文自动二次切分
        ADictionary dic = DictionaryFactory.createSingletonDictionary(config);
        ISegment seg = SegmentFactory.createJcseg(JcsegTaskConfig.COMPLEX_MODE, new Object[]{config, dic});

        /**
         * 构建TextRankKeyphraseExtractor关键短语提取器
         */
        TextRankKeyphraseExtractor extractor = new TextRankKeyphraseExtractor(seg);
        extractor.setMaxIterateNum(100);        //设置pagerank算法最大迭代词库，非必须，使用默认即可
        extractor.setWindowSize(5);             //设置textRank窗口大小，非必须，使用默认即可
        extractor.setKeywordsNum(20);           //设置最大返回的关键词个数，默认为10
        extractor.setMaxWordsNum(4);            //设置最大短语词长，默认为5

        String str = "支持向量机广泛应用于文本挖掘，例如，基于支持向量机的文本自动分类技术研究一文中很详细的介绍支持向量机的算法细节，文本自动分类是文本挖掘技术中的一种！";
        List<String> keyphrases = extractor.getKeyphrase(new StringReader(str));
        System.out.println(keyphrases);
    }
}
/**
 * 分词结果:[支持向量机, 自动分类]
 *
 */
