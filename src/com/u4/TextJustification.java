package com.u4;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
	
	public static void main(String[] args) {
		//String [] words = {"This", "is", "an", "example", "of", "text", "justification."};
		String [] words = {"What","must","be","acknowledgment","shall","be"};
		List<String> res = new TextJustification().fullJustify(words, 16);
		for(String s:res) {
			System.out.println(s);
		}
	}
	public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int s=0;
        int s2=0;
        int index1 = 0, index2 = 0;
        for(int i = 0;i < words.length;i++){
            int valueSize = words[i].length();
            if(s+valueSize>maxWidth){
                index2 = i-1;
                //从index1 - index2 的单词, 
                int all_space_num = maxWidth - s2;
                int kge_num = index2-index1;
          
               
                int yu = kge_num > 0?all_space_num % kge_num:0;
                 
                String valueStr = "";
                for(int j = 0;j < kge_num;j++){
                    valueStr += words[index1+j];
                    int addnum = yu > 0?1:0;
                    addnum += (all_space_num / kge_num);
                    yu--;
                    /*空格处理*/
                    for(int n = 0;n < addnum;n++)
                        valueStr += " ";
                }
                
                valueStr+=words[index2];
                if(valueStr.length()<maxWidth){
                    int def = maxWidth-valueStr.length();
                    for(int z = 0;z<def;z++)
                        valueStr+=" ";
                }
                res.add(valueStr);
                
                index1 = i;
                i--;
                s=0;
                s2=0;
            }else if(i != words.length-1){
                s += valueSize+1;
                s2 += valueSize;
            }else if(i == words.length-1){
                index2 = i;
                String valueStr = "";
                int kge_num = index2-index1;
                for(int j = 0;j < kge_num;j++){
                    valueStr += words[index1+j];
                    valueStr += " ";
                }
                
                valueStr+=words[index2];
                if(valueStr.length()<maxWidth){
                    int def = maxWidth-valueStr.length();
                    for(int z = 0;z<def;z++)
                        valueStr+=" ";
                }
                res.add(valueStr);
            }
        }
        return res;
    }
}
