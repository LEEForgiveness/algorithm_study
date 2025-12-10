import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static void main(String[] args) {
		int[] shop_price = {20000, 100000, 1500000};
		int[] user_coupons = {10, 10, 10};

		Integer[] priceArray = Arrays.stream(shop_price).boxed().toArray(Integer[]::new);
		Integer[] couponArray = Arrays.stream(user_coupons).boxed().toArray(Integer[]::new);

		Arrays.sort(priceArray, Collections.reverseOrder());
		Arrays.sort(couponArray, Collections.reverseOrder());
		System.out.println(Arrays.toString(priceArray));
		System.out.println(Arrays.toString(couponArray));

		int total = 0;
		int i = 0;
		int j = 0;
		while (i < couponArray.length && j < priceArray.length){
			double discountFactor = (100.0 - couponArray[i]) / 100.0;
			System.out.println(discountFactor);
			total = total + (int)(priceArray[j] * discountFactor);
			i++;
			j++;
		}

		for (i = j; i < priceArray.length; i++) {
			total += priceArray[i];
		}
		System.out.println(total);
	}
}