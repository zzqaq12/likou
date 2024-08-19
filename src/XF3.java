public class XF3 {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4};
        int []res = calcul(arr);
        for (int elem : res) {
            System.out.print(elem + " ");
        }

    }

    public static int[] calcul(int arr[]) {
        int n = arr.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int rMax = arr[i];
            int lMax = arr[i];
            int max = arr[i];
            int left = i - 1;
            int right = i + 1;
            while (left >=0 || right < n) {
                if (left >= 0 && right < n) {
                    if (arr[left] > max && arr[right] > max) {
                        if (arr[left] > arr[right]) {
                            lMax += arr[left];
                            left--;
                        } else {
                            rMax += arr[right];
                            right++;
                        }
                    } else if (arr[left] > lMax) {
                        left += arr[left];
                        left--;
                    } else if (arr[right] > rMax ) {
                        max += arr[right];
                        right++;
                    }
                }else if (left >= 0) {
                   if (arr[left] > lMax) {
                       lMax += arr[left];
                       left--;
                   } else break;
                } else if (right < n){
                    if (arr[right] > rMax) {
                        rMax += arr[right];
                        right++;
                    }else break;
                }
            }
            res[i] = lMax + rMax - max;
        }
        return res;
    }
}
