package BLINDxx75xxProblems.BinarySearchProblems;

public class CapacityToShipPackagesWithinDDays {
    /*
  capacity
   low = max weight in the pile
   high = sum of the weights
  */
    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;
        for(int i = 0; i < weights.length; i++){
            low = Math.max(weights[i], low);
            high += weights[i];
        }
        while(low < high){
            int mid = low + (high-low)/2;
            if(!canShipWithinInputDays(weights,days, mid)){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }

    private boolean canShipWithinInputDays(int[] weights, int days, int capacity){
        int numDays = 1;
        int totalWeightShipped = 0;
        for(int i = 0; i < weights.length; i++){
            totalWeightShipped += weights[i];
            if(totalWeightShipped > capacity){
                numDays++;
                totalWeightShipped = weights[i];
            }
            if(numDays > days){
                return false;
            }
        }
        return true;
    }
}
