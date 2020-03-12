/*
package com.cz.app.appweb.service;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
//import com.janeluo.*;
public class Test {

    public static List<String> getStringList(String text) throws Exception{
        //独立Lucene实现
        StringReader re = new StringReader(text);
        IKSegmenter ik = new IKSegmenter(re, true);
        Lexeme lex;
        List<String> s = new ArrayList<>();
        while ((lex = ik.next()) != null) {
            s.add(lex.getLexemeText());
        }
        return s;
    }
   */
/* public static  void automaticSelection(String title) {
        //移除停用词进行分词
        List<Word> list = WordSegmenter.seg(title);

        System.out.println(JSON.toJSONString(list));

        //保留停用词
        List<Word> lists = WordSegmenter.segWithStopWords(title);
        System.out.println(JSON.toJSONString(lists));

    }

    public static void main(String[] args) {
        WordFilter.automaticSelection("我叫李太白，我是一个诗人，我生活在唐朝");
    }*//*

}
*/
