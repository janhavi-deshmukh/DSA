package binarySearch;

//same as ceiling of a number except no equal to check
public class smallestLetterGreaterThanTarget {

    private static char getceilingCharater(char[] letters, char target) {

        int start = 0;
        int end = letters.length - 1;
        while (start <= end) {


            int mid = start + (end - start) / 2;
            if (target > letters[mid]) {
                start = mid + 1;
            }
            else if(target<letters[mid]) {
                end = mid - 1;
            }


        }
        return letters[start % letters.length];
    }

    public static void main(String[] args) {
        char[] letters={'c','d','f','j','k'};
        char target='g';
        System.out.print(getceilingCharater(letters,target));


    }

}
