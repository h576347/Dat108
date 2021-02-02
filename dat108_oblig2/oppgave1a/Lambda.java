package no.hvl.dat108.oppgave1a;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lambda {
	
	
	public static void main(String[] args) {
		List<String>listen= Arrays.asList("10","1","20","110","21","12");
		
		
		Collections.sort(listen, (a,b) ->  {

                return new Integer(Integer.parseInt(a)).compareTo(Integer.parseInt(b));
            }
        );
		
//		Collections.sort(listen, (a,b) -> Integer.compare(Integer.parseInt(a), Integer.parseInt(b)));
		
		
		
		System.out.println(listen);
		

	}

}
