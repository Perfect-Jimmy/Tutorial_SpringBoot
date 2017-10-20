package com.tutorial.jcseg;

import org.lionsoul.jcseg.tokenizer.ASegment;
import org.lionsoul.jcseg.tokenizer.core.*;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by jimmy on 2017/10/20.
 */
public class BaseTest {
    public static void main(String[] args) throws JcsegException, IOException {
        /**
         * 1.JcsegTaskConfig配置实例,autoLoad=true会自动查找配置来初始化
         */
        JcsegTaskConfig config = new JcsegTaskConfig(true);
        config.setAppendCJKSyn(true);//追加同义词到分词结果中, 需要在 jcseg.properties 中配置 jcseg.loadsyn=1
        //config.setAppendCJKPinyin(true);//追加拼音到分词结果中, 需要在 jcseg.properties 中配置 jcseg.loadpinyin=1

        /**
         * 2.创建ADictionary分词词库实例
         * ADictionary会依据JcsegTaskConfig里面的词库信息加载全部有效的词库
         * config.isAutoload()对应properties文件里面的lexicon.autoload,true创建同步词库,反之就是非同步词库
         */
        ADictionary dic = DictionaryFactory.createDefaultDictionary(config, config.isAutoload());

        /**
         * 3.创建ISegment
         * JcsegTaskConfig.COMPLEX_MODE:复杂分词对象.
         * JcsegTaskConfig.SIMPLE_MODE:简易分词对象.
         * JcsegTaskConfig.DETECT_MODE:DetectSeg Isegmengt分词对象.
         * JcsegTaskConfig.SEARCH_MODE表示:SearchSeg Isegmengt分词对象.
         * JcsegTaskConfig.DELIMITER_MODE表:DelimiterSeg Isegmengt分词对象.
         * JcsegTaskConfig.NLP_MODE表:NLPSeg Isegmengt分词对象.
         */
        ASegment seg = (ASegment) SegmentFactory.createJcseg(JcsegTaskConfig.COMPLEX_MODE, new Object[]{config, dic});

        /**
         * 4.设置要分词的内容
         */
      //  String str = "jcseg是使用Java开发的一款开源的中文分词器, 使用mmseg算法. 分词准确率高达98.4%.";
        String str = "中国的中央一台很精彩很厉害，研究一下.看汤姆克鲁斯";
        seg.reset(new StringReader(str));

        /**
         * 5. 获取分词结果
         */
        IWord word = null;
        while ((word = seg.next()) != null) {
            System.out.print(word.getValue() + "|");
        }
    }
}

/**
 * 分词结果
 * COMPLEX_MODE:jcseg|使用|java|开发|一款|开源|中文|分词器|使用|mmseg|算法|分词|准确率|高达|98|98.4%|
 * SIMPLE_MODE: jcseg|使用|java|开发|一款|开源|中文分词|器|使用|mmseg|算法|分词|准确率|高达|98|98.4%|
 *
 * 追加同义词到分词结果中
 * COMPLEX_MODE:jcseg|使用|java|开发|一款|开源|中文|国语|分词器|使用|mmseg|算法|分词|准确率|正确率|高达|98|98.4%|
 * SIMPLE_MODE: jcseg|使用|java|开发|一款|开源|中文分词|器|使用|mmseg|算法|分词|准确率|正确率|高达|98|98.4%|
 *
 * 追加拼音到分词结果中
 * COMPLEX_MODE:jcseg|使用|shi yong|java|开发|kai fa|一款|yi kuan|开源|kai yuan|中文|zhong wen|分词器|fen ci qi|使用|shi yong|mmseg|算法|suan fa|分词|fen ci|准确率|zhun que lu|高达|gao da|98|98.4%|
 * SIMPLE_MODE: jcseg|使用|shi yong|java|开发|kai fa|一款|yi kuan|开源|kai yuan|中文分词|zhong wen fen ci|器|qi|使用|shi yong|mmseg|算法|suan fa|分词|fen ci|准确率|zhun que lu|高达|gao da|98|98.4%|
 */