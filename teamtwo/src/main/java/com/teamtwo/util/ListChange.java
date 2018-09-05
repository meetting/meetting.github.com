package com.teamtwo.util;

import java.util.ArrayList;
import java.util.List;

public class ListChange {
public static List<Integer> ChangeStringtoInteger(String[] StringList){
		
		List<Integer> integerList = new ArrayList<Integer>();
		
		for(int i = 0;i < StringList.length;i++){
			integerList.add(Integer.parseInt(StringList[i]));
		}
		
		return integerList;
	}
}
