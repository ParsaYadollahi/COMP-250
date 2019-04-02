package quiz;

public class TestLinearProbing {

    public static void main(String[] args){
        LinearProbing map = new LinearProbing();

        int[] ids = new int[] {26061239, 26069802, 26065629, 26067804, 26067799, 26063353, 26068989, 26067775};
        for (int i = 0; i < ids.length;i++) {
            map.insert(ids[i], ids[i]);
        }
        System.out.println(map.getValue(5));
    }
}
