Class InitialCode {
    public ArrayList<Integer> nextGreater(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < A.size(); i++) {
            boolean valueAdded = false;
            for(int j = i; j < A.size() - 1; j++) {
                if (A.get(i) < A.get(j + 1)) {
                    valueAdded = true;
                    result.add(A.get(j + 1));
                    break;
                }
            }
            if (!valueAdded) {
                result.add(-1);
            }
        }
        return result;
    }
    public int longestConsecutive(final List<Integer> A) {
        if (A.size() == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<Integer>();
        int max = 1;

        for(Integer n : A) {
            set.add(n);
        }

        for (Integer n : A) {
            int left = n - 1;
            int right = n + 1;
            int count = 1;

            while (set.contains(left)) {
                count++;
                set.remove(left);
                left--;
            }

            while (set.contains(right)) {
                count++;
                set.remove(right);
                right++;
            }

            max = Math.max(count, max);
        }

        return max;
    }

    public int kthsmallest(final List<Integer> A, int B) {

        if (A.size() == 1) {
            return A.get(0);
        }
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(new Integer[A.size()]));

        Collections.copy(list, A);
        Collections.sort(list);
        System.out.println(list);
        for (int i = 0; i <= list.size(); i++) {
            if (i == B) {
                return list.get(i - 1);
            }
        }
        return -1;
    }

    public ArrayList<ArrayList<Integer>> prettyPrint(int A) {

        if (A == 0) {
            return new ArrayList<>();
        }
        if (A == 1) {
            ArrayList<ArrayList<Integer>> output = new ArrayList<>();
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(1);
            output.add(arrayList);
            return output;
        }
        int n = A * 2 - 1;
        int[][] rectangle = new int[n][n];

        int value = n/2 + 1;

        for (int i = 0; i <= n/2; i++) {
            for (int j = i; j < n - i; j++) {
                rectangle[i][j] = value;
            }
            value--;

            if (i < n/2) {
                arrayCopy(rectangle[i], rectangle[i + 1]);
            }
        }

        int mid = n/2 + 1;

        int offset = 1;
        for (int i = mid; i < n; i++) {
            arrayCopy(rectangle[i - (offset * 2)], rectangle[i]);
            offset++;
        }

        return convert(rectangle);
    }

    public ArrayList<ArrayList<Integer>> convert(int[][] rectangle) {
        ArrayList<ArrayList<Integer>> twoDimensionalArray = new ArrayList<>();
        for (int i = 0; i < rectangle.length; i++) {
            ArrayList<Integer> array = new ArrayList<>();
            for (int j = 0; j < rectangle[0].length; j++) {
                array.add(rectangle[i][j]);
            }
            twoDimensionalArray.add(array);
        }
        return twoDimensionalArray;
    }

    public void arrayCopy(int[] src, int[] dest) {
        for (int i = 0; i < dest.length; i++) {
            dest[i] = src[i];
        }
    }

    public void print(int[][] rectangle) {
        int height = rectangle.length;
        int width = rectangle[0].length;
        for(int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(rectangle[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void print(ArrayList<ArrayList<Integer>> rectangle) {
        int height = rectangle.size();
        int width = rectangle.get(0).size();
        for(int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(rectangle.get(i).get(j)+" ");
            }
            System.out.println();
        }
    public static void main(String[] args) {

    }
}