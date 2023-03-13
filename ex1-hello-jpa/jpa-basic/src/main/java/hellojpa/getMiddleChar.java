package hellojpa;

import antlr.StringUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class getMiddleChar {
    public static void main(String[] args) {
        String a = "abfdd";
        int[] b = {1,2,3,4};
        if(a.length()%2 == 0) System.out.println("aa");
        else System.out.println(a.substring(Math.round(a.length()%2)-1,Math.round(a.length())));
        System.out.println(b.length);

        getMiddleChar gm = new getMiddleChar();
        int[] result = gm.solution(b,2);
        for(int temp : result){
            System.out.print(temp);
        }
    }
    public int[] solution(int[] arr, int divisor) {
        int[] answer;
        List<Integer> list = new LinkedList<Integer>();
        for(int temp : arr){
            if(temp%divisor == 0) list.add(temp);
        }
        answer = new int[list.size()];
        for(int i=0; i<list.size() ; i++){
            answer[i] = list.get(i);
        }

        Arrays.sort(answer);


        return answer;
    }

}
