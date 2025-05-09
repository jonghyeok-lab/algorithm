package programmers.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class PG_호텔대실 {

    public int solution(String[][] book_time) {
        int answer = 0;

        List<BookTime> bookTimes = new ArrayList<>();

        for(int i = 0; i < book_time.length; i++) {
            String start = book_time[i][0];
            String end = book_time[i][1];
            BookTime bookTime = new BookTime(start, end);
            bookTimes.add(bookTime);
        }

        List<BookTime> sortedBookTimes = bookTimes.stream()
                .sorted((a, b) -> Integer.compare(b.endM, a.endM))
                .collect(Collectors.toList());

        // sortedBookTimes.forEach(e -> System.out.println(e.endM));

        PriorityQueue<BookTime> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.startM, a.startM));
        BookTime first = sortedBookTimes.get(0);
        pq.add(first);
        answer++;
        int minTime = -1;

        for(int i = 1; i < sortedBookTimes.size(); i++) {
            BookTime b = sortedBookTimes.get(i);
            // pq.add(b);
            minTime = pq.peek().startM;
            if(b.endM + 10 > minTime) {
                answer++;
            } else {
                pq.poll();
                // minTime = pq.poll().startM;
            }
            pq.add(b);

        }
        return answer;
    }

    static class BookTime {
        int startM; // 시작 시각의 분
        int endM; // 끝 시각의 분

        BookTime(String start, String end) {
            startM = toMinute(start);
            endM = toMinute(end);
        }

        private int toMinute(String target) {
            String[] splited = target.split(":");
            return Integer.parseInt(splited[0]) * 60 + Integer.parseInt(splited[1]);
        }
    }
}
