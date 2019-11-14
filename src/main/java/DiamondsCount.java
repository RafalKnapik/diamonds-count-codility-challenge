import java.util.*;

public class DiamondsCount {

    private static int solution(int[] X, int[] Y) {
        int count = 0;
        Map<ArrayList<Integer>, Integer> vertical = new HashMap<ArrayList<Integer>, Integer>();
        Map<ArrayList<Integer>, Integer> horizontal = new HashMap<ArrayList<Integer>, Integer>();

        for (int i = 0; i < X.length; i++) {
            for (int j = i + 1; j < X.length; j++) {
                if(X[i] == X[j] && (Y[i] - Y[j]) % 2 == 0){
                    ArrayList<Integer> middlePoint = new ArrayList<Integer>();
                    middlePoint.add(X[i]);
                    middlePoint.add((Y[i] + Y[j])/2);
                    if(vertical.containsKey(middlePoint)) {
                        vertical.put(middlePoint, vertical.get(middlePoint) + 1);
                    } else {
                        vertical.put(middlePoint, 1);
                    }
                    if(horizontal.containsKey(middlePoint)){
                        count = count + horizontal.get(middlePoint);
                    }
                }

                if(Y[i] == Y[j]&& (X[i] - X[j]) % 2 == 0){
                    ArrayList<Integer> middlePoint = new ArrayList<Integer>();
                    middlePoint.add((X[i] + X[j])/2);
                    middlePoint.add(Y[i]);
                    if(horizontal.containsKey(middlePoint)) {
                        horizontal.put(middlePoint, horizontal.get(middlePoint) + 1);
                    } else {
                        horizontal.put(middlePoint, 1);
                    }
                    if(vertical.containsKey(middlePoint)){
                        count = count + vertical.get(middlePoint);
                    }
                }
            }
        }
        System.out.println(horizontal);
        System.out.println(vertical);
        return count;
    }

    public static void main(String[] args) {
        int[] X = {1, 1, 2, 2, 2, 3, 3};
        int[] Y = {3, 4, 1, 3, 5, 3, 4};
        System.out.println(solution(X, Y));
    }
}
