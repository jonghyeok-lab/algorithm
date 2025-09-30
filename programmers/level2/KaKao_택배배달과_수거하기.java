package programmers.level2;

public class KaKao_택배배달과_수거하기 {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        House[] houses = new House[n];
        int deliveryIndex = -1;
        for (int i = 0; i < n; i++) {
            houses[i] = new House(deliveries[i], pickups[i]);
            if(deliveries[i] != 0 || pickups[i] != 0) {
                deliveryIndex = i;
            }
        }

        while (true) {
            int deliveryAmount = cap;

            deliveryIndex = find(deliveryIndex, houses);
            if (deliveryIndex == -1) break;
            answer += deliveryIndex + 1;

            // 배달
            for (int i = deliveryIndex; i >= 0; i--) {
                House visited = houses[i];
                deliveryAmount = visited.delivery(deliveryAmount);
                if (deliveryAmount == 0) {
                    break;
                }
            }

            // 수거
            answer += deliveryIndex + 1;
            int pickupAmount = cap;
            for (int i = deliveryIndex; i >= 0; i--) {
                House visited = houses[i];
                pickupAmount = visited.pickup(pickupAmount);
                if (pickupAmount == 0) {
                    break;
                }
            }
        }
        return answer;
    }

    private int find(int deliveryIndex, House[] houses) {
        for (int i = deliveryIndex; i >= 0; i--) {
            House house = houses[i];
            if (!(house.remain == 0 && house.pick == 0)) {
                return i;
            }
        }
        return -1;
    }

    static class House {
        int remain;
        int pick;

        public House(int remain, int pick) {
            this.remain = remain;
            this.pick = pick;
        }

        public int delivery(int amount) {
            if (remain < amount) {
                int delivered = remain;  // 배달 전 remain 저장
                remain = 0;
                return amount - delivered;  // 남은 용량 반환
            }
            remain -= amount;
            return 0;
        }

        public int pickup(int amount) {
            if (pick < amount) {
                int delivered = pick;
                pick = 0;
                return amount - delivered;
            }
            pick -= amount;
            return 0;
        }
    }
}
