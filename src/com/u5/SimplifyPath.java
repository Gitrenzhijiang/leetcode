package com.u5;

import java.util.Stack;
/*
 * path = "/a/./b/../c/", => "/a/c"ºÍpath = "/a/./b/c/", => "/a/b/c"
 * 
 */
public class SimplifyPath {//right answer: /e/f/g
	public static void main(String[] args) {
		String path = "/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///";
		System.out.println(new SimplifyPath().simplifyPath2(path));
	}
	public String simplifyPath2(String path) {
        if(path == null || "".equals(path))
        	return null;
        if(path.endsWith("/") && path.length()>1) {
        	path = path.substring(0, path.length()-1);
        }
        Stack<String> stack = new Stack<>();
        for(int i = 0;i < path.length();i++) {
        	while(i<path.length() && path.charAt(i) == '/')i++;
        	int start = i;
        	if(start == path.length())
        		break;
        	while(i<path.length() && path.charAt(i) != '/')i++;
        	String sub = path.substring(start, i);
        	if(".".equals(sub)) {
        		
        	}else if("..".equals(sub)) {
        		if(!stack.isEmpty())
        			stack.pop();
        	}else {
        		stack.push(sub);
        	}
        }
        String res = "";
        if(stack.isEmpty()) {
        	res = "/";
        }else {
        	while(!stack.isEmpty()) {
        		System.out.println(stack.peek());
        		res = "/"+stack.pop()+res;
        	}
        }
        return res;
	}
}
