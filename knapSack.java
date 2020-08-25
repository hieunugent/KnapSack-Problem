import java.util.*;

class Program {
  public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
    // Write your code here.
    // Replace the code below.
		int[][] knapsackValue = new int[items.length + 1][capacity+1];
		for(int i = 1; i < items.length +1 ;i++){
			int currentW = items[i-1][1];
			int currentV = items[i-1][0];
			for( int c =0 ; c < capacity +1;c++){
				if(currentW > c){
					knapsackValue[i][c] = knapsackValue[i-1][c];
				}else{
					knapsackValue[i][c] = Math.max(
						knapsackValue[i-1][c],
						knapsackValue[i-1][c-currentW]+ currentV
					);
				}
			}			
		}
    
    return backTrackingKnap(knapsackValue, items,knapsackValue[items.length][capacity]);
  }
	
	public static List<List<Integer>> backTrackingKnap(int[][]knapsackValue , int[][] items, int weight)
	{
	List<List<Integer>> sequence = new ArrayList<List<Integer>>();
	List<Integer> totalWeight = new ArrayList<Integer>();
	totalWeight.add(weight);
	sequence.add(totalWeight);
	sequence.add(new ArrayList<Integer>());
	int i = knapsackValue.length-1;
	int c = knapsackValue[0].length-1;
	while(i > 0){
		if(knapsackValue[i][c] == knapsackValue[i-1][c]){
			i--;
		}else{
			sequence.get(1).add(0,i-1);
			c -= items[i-1][1];
				i--;
		}
		if(c==0){
			break;
		}
	}
		return sequence;
	}
}
