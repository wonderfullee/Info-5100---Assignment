package class10.Assignment_8;

import java.util.ArrayList;
import java.util.List;

public class ExtraCredit {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(res, sb, num, 0, target, 0, 0);
        return res;

    }
    public void dfs(List<String> res, StringBuilder sb, String num, int pos, int target, long pre, long multi) {
        if (pos == num.length()) {
            if (target == pre) res.add(sb.toString());
            return;
        }
        for(int i = pos; i < num.length(); i++) {
            if(num.charAt(pos) == '0' && i != pos)
                break;
            long curr = Long.parseLong(num.substring(pos, i + 1));
            int len = sb.length();
            if(pos == 0) {
                dfs(res, sb.append(curr), num, i + 1, target, curr, curr);
                sb.setLength(len);
            } else {
                dfs(res, sb.append("+").append(curr), num, i + 1, target, pre + curr, curr);
                sb.setLength(len);
                dfs(res, sb.append("-").append(curr), num, i + 1, target, pre - curr, -curr);
                sb.setLength(len);
                dfs(res, sb.append("*").append(curr), num, i + 1, target, pre - multi + multi * curr, multi * curr);
                sb.setLength(len);
            }
        }
    }

        public static void main (String[] args){
            ExtraCredit ec = new ExtraCredit();
            System.out.println(ec.addOperators("123",6));
            System.out.println(ec.addOperators("232",8));
            System.out.println(ec.addOperators("105",5));
            System.out.println(ec.addOperators("00",0));

        }
    }

