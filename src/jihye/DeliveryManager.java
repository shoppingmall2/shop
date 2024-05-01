package jihye;

import java.util.HashMap;
import java.util.Map;

public class DeliveryManager {

    public enum DeliveryStatus {
        WAITING,SHIPPED,
        DELIVERED;
    }
    // 다음 상태를 반환하는 메서드
    public DeliveryStatus next() {
        // 여기에 다음 상태로 넘어가는 로직 추가
        // WAITING 상태에서는 SHIPPED 상태로 넘어감
        if (this == WAITING) {
            return SHIPPED;
        }
        // SHIPPED 상태에서는 DELIVERED 상태로 넘어감
        else if (this == SHIPPED) {
            return DELIVERED;
        }
        // DELIVERED 상태에서는 더 이상 다음 상태가 없음
        else {
            return this;
        }
    }

    // 각 상품의 배송 단계를 저장할 맵
    private static Map<String, DeliveryStatus> deliveryStatusMap = new HashMap<>();

    // 배송 단계를 초기화하는 메서드
    public static void initializeDeliveryStatus(String itemName) {
        deliveryStatusMap.put(itemName, DeliveryStatus.WAITING);
    }

    // 다음 배송 단계로 진행하는 메서드
    public static void approveNextStep(String itemName) {
        // 현재 상태 가져오기
        DeliveryStatus currentStatus = deliveryStatusMap.get(itemName);
        // 다음 단계로 진행
        DeliveryStatus nextStatus = currentStatus.next();
        // 새로운 단계로 업데이트
        deliveryStatusMap.put(itemName, nextStatus);
    }

    // 해당 상품의 현재 배송 단계를 가져오는 메서드
    public static DeliveryStatus getDeliveryStatus(String itemName) {
        return deliveryStatusMap.get(itemName);
    }
}
