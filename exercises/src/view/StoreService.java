package view;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import bean.Store;

public class StoreService {

	public static void main(String[] args) {
		final Integer whAllocationAmount = 300;
		final List<Store> selectedStores = getStores().stream()
				.filter(store -> Boolean.TRUE.equals(store.getSelected())).collect(Collectors.toList());

		// Thực hiện các bước tính toán

		Map<Long, Integer> storeAllocatedAmouts = doAllocation(whAllocationAmount, selectedStores);
		storeAllocatedAmouts.entrySet().stream().forEach(System.out::println);

	}

	private static List<Store> getStores() {
		// Store(storeId, referenceStoreId, stockPreviousDay, expectedSales, isSelected)
		return Arrays.asList(new Store(1L, null, bd(18), bd(40), Boolean.TRUE),
				new Store(2L, null, bd(19), bd(20), Boolean.TRUE), 
				new Store(3L, null, bd(21), bd(17), Boolean.TRUE),
				new Store(4L, null, bd(14), bd(31), Boolean.TRUE), 
				new Store(5L, null, bd(14), bd(10), Boolean.TRUE),
				new Store(6L, null, bd(15), bd(30), Boolean.TRUE), 
				new Store(7L, 2L, bd(15), null, Boolean.TRUE),
				new Store(8L, null, bd(12), bd(19), Boolean.TRUE), 
				new Store(9L, null, bd(17), bd(26), Boolean.TRUE),
				new Store(10L, 7L, bd(18), null, Boolean.TRUE), 
				new Store(11L, null, bd(22), null, Boolean.FALSE));
	}

	private static BigDecimal bd(long value) {
		return BigDecimal.valueOf(value);
	}

	/**
	 * Do Allocation.
	 * 
	 * Key: storeId with Long type Value: storeAllocatedAmount after calculation
	 * with 4 steps
	 * 
	 * @return map of storeId, storeAllocatedAmount
	 */
	private static Map<Long, Integer> doAllocation(Integer whAllocationAmount, List<Store> stores) {

		// Step 1: Filling in missing expected sales
		Map<Long, BigDecimal> filledExpectedSales = fillMissingExpectedSales(stores);

		// Step 2: Calculate Allocation Key

		// Step 3: Calculate Allocated Amount

		// Step 4: Fix rounding issue

		return convertToIntegerMap(filledExpectedSales);
	}
	
	private static Map<Long, Integer> convertToIntegerMap(Map<Long, BigDecimal> map) {
	    Map<Long, Integer> result = new HashMap<>();
	    for (Map.Entry<Long, BigDecimal> entry : map.entrySet()) {
	        result.put(entry.getKey(), entry.getValue().intValue());
	    }
	    return result;
	}
	
	private static Map<Long, BigDecimal> fillMissingExpectedSales(List<Store> stores) {
		
		Map<Long, BigDecimal> storeExpectedSales = new HashMap<>();
		
		boolean hasExpectedSales = false;
	    boolean hasReferenceStore = false;
	    
	    for (Store store : stores) {
	    	if (store.getExpectedSales() != null) {
	            hasExpectedSales = true;
	        }
	        if (store.getReferenceStoreId() != null) {
	            hasReferenceStore = true;
	        }
	        if (store.getExpectedSales() == null) {
	            // Use Case 1: Store has a reference store with maintained expected sales
	            if (store.getReferenceStoreId() != null) {
	                Store referenceStore = stores.stream()
	                        .filter(s -> store.getReferenceStoreId().equals(s.getStoreId())
	                                && s.getExpectedSales() != null)
	                        .findFirst().orElse(null);
	                if (referenceStore != null) {
	                    store.setExpectedSales(referenceStore.getExpectedSales());
	                }
	            }
	            // Use Case 2: Store has no reference store maintained or reference store is missing expected sales
	            if (store.getExpectedSales() == null) {
	                List<BigDecimal> availableExpectedSales = stores.stream()
	                        .filter(s -> s.getExpectedSales() != null && !s.getStoreId().equals(store.getStoreId()))
	                        .map(Store::getExpectedSales)
	                        .collect(Collectors.toList());
	                
	                if (!availableExpectedSales.isEmpty()) {
	                    BigDecimal averageExpectedSales = availableExpectedSales.stream()
	                            .reduce(BigDecimal.ZERO, BigDecimal::add)
	                            .divide(BigDecimal.valueOf(availableExpectedSales.size()), 1, RoundingMode.HALF_UP);
	                    store.setExpectedSales(averageExpectedSales);
	                }
	            }else {
	                storeExpectedSales.put(store.getStoreId(), store.getExpectedSales());
	            }
	        }
	    }
	    
	    if (!hasExpectedSales && !hasReferenceStore) {
	        // Hiển thị thông báo lỗi
	        displayErrorMessage();
	        // Dừng quá trình tính toán bằng cách trả về một Map rỗng hoặc null tùy theo logic của bạn
	        return new HashMap<>();
	    }	    
		return storeExpectedSales;
	}
	
	private static void displayErrorMessage() {
	    System.out.println("Expected sales cannot be calculated..."); 
	}
}