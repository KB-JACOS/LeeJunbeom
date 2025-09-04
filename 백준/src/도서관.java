import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 도서관 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int bookCount = Integer.parseInt(st.nextToken());
		int sejun = Integer.parseInt(st.nextToken());

		List<Integer> minusBook = new ArrayList<>();
		List<Integer> plusBook = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for(int i=0;i<bookCount;i++){
			Integer s = Integer.parseInt(st.nextToken());
			if(s < 0) {
				minusBook.add(s);
			}else{
				plusBook.add(s);
			}
		}

		minusBook.sort(Integer::compareTo);
		plusBook.sort(Integer::compareTo);

		List<Integer> maximum = new ArrayList<>();
		int flag = 0;
		int max = 0;
		for(int i=0;i<minusBook.size();i++){
			max = Math.max(max, Math.abs(minusBook.get(i)));
			flag++;
			if(flag == sejun || i == minusBook.size()-1){
				maximum.add(max);
				max = 0;
				flag = 0;
			}
		}

		flag = 0;
		max = 0;
		for(int i=plusBook.size()-1;i>=0;i--){
			max = Math.max(max, plusBook.get(i));
			flag++;
			if(flag == sejun || i == 0){
				maximum.add(max);
				max = 0;
				flag = 0;
			}
		}

		maximum.sort(Integer::compareTo);

		int result = 0;

		for(int i=0;i<maximum.size();i++){
			if(i == maximum.size()-1){
				result += maximum.get(i);
				System.out.println(result);
				break;
			}
			result += maximum.get(i)*2;
		}

	}
}
