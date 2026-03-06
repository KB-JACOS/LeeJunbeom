import java.util.*;
class Programmers_압축 {
	public int[] solution(String msg) {
		List<String> dic = new ArrayList<>();
		List<Integer> answer = new ArrayList<>();

		for(int i=0;i<=25;i++){
			dic.add(String.valueOf((char)('A'+i)));
		}
		int beforeIdx = 0;
		for(int i=0;i<msg.length();i++){
			StringBuilder sb = new StringBuilder();

			sb.append(msg.charAt(i));
			String now = sb.toString();

			if(dic.contains(now)){
				beforeIdx = dic.indexOf(now);
				int j = 0;
				for(j=i+1;j<msg.length();j++){
					sb.append(msg.charAt(j));
					now = sb.toString();
					if(dic.contains(now)){
						beforeIdx = dic.indexOf(now);

					} else {
						break;
					}
				}
				i = j-1;
				answer.add(beforeIdx+1);
				dic.add(sb.toString());
			}
		}

		int[] as = new int[answer.size()];

		for(int i=0;i<answer.size();i++){
			as[i] = answer.get(i);
		}

		return as;
	}
}