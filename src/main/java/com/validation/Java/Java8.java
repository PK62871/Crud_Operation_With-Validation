package com.validation.Java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8 {
	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("prabhakar","yashvant","prakash");
		List<String> result = names.stream().map(name->name.toUpperCase()).collect(Collectors.toList());
		
		for(String finalResult:result) {
			System.out.println(finalResult);
		}
			
	}
	}

