package br.com.api.pixAPI;

import java.util.Arrays;
import java.util.List;

public class Testes {

	public static void main(String[] args) {
		
		List<Integer> itens = Arrays.asList(1,2,3,4,5,6);
		
		itens.forEach(item -> {
			if(item == 4) System.out.println(item);
		});
		
	}

}
