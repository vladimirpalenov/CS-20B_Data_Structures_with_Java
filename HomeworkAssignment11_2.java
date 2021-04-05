import java.util.*;
public class HomeworkAssignment11_2 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        ArrayList<List<String>> routes = new ArrayList<List<String>>();
        routes.add(Arrays.asList("B", "C"));
        routes.add(Arrays.asList("D", "B"));
        routes.add(Arrays.asList("C", "A"));
        System.out.println(sol.getDestination(routes)=="A"); //true
        ArrayList<List<String>> routes1 = new ArrayList<List<String>>();
        routes1.add(Arrays.asList("Z", "K"));
        routes1.add(Arrays.asList("W", "X"));
        routes1.add(Arrays.asList("K", "W"));
        routes1.add(Arrays.asList("A", "W"));
        routes1.add(Arrays.asList("X", "Y"));
        routes1.add(Arrays.asList("D", "X"));
        System.out.println(sol.getDestination(routes1)=="Y"); //true
        ArrayList<List<String>> routes2 = new ArrayList<List<String>>();;
        System.out.println(sol.getDestination(routes2)==null); //true
        ArrayList<List<String>> routes3 = new ArrayList<List<String>>();
        routes3.add(Arrays.asList("Z", "K"));
        System.out.println(sol.getDestination(routes3)=="K"); //true
    }
}

class Solution {
    /**
     * MEMBER FUNCTION NAME:
     * public String getDestination(List<List<String>> routes)
     * PURPOSE:
     * This function finds and returns the destination town, that is, the town without
     * any outdegrees.
     * PARAMETERS:
     * List<List<String>> routes
     * RETURN VALUE:
     * String
     **/
    public String getDestination(List<List<String>> routes) {
        List<String> departures = new ArrayList<String>();
        List<String> destinations = new ArrayList<String>();
        if (routes == null){
            return null;
        }else if (routes.size() == 0){
            return null;
        } else{
            for (int i = 0; i < routes.size(); i++){
                departures.add(routes.get(i).get(0));
                destinations.add(routes.get(i).get(1));
            }
            for (int i = 0; i < destinations.size(); i++){
                if(!departures.contains(destinations.get(i))){
                    return destinations.get(i);
                }
            }
        }
        return null;
    }
}