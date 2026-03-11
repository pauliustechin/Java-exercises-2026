package lt.techin.praktinis;

public class NumberReverter {
    public void revert(int number) {
        String numString = Integer.toString(number);
        StringBuilder sb = new StringBuilder();

        for(int i = (numString.length() - 1); i >= 0; i--){
            sb.append(numString.charAt(i));
        }

        int result = Integer.parseInt(String.valueOf(sb));
        System.out.println(result);
    }
}
