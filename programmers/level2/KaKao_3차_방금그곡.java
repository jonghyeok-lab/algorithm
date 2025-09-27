package programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class KaKao_3차_방금그곡 {

    public String solution(String m, String[] musicinfos) {
        List<MusicInfo> musicInfoList = new ArrayList<>();
        for (int i = 0; i < musicinfos.length; i++) {
            String musicinfo = musicinfos[i];
            String[] splited = musicinfo.split(",");
            MusicInfo musicInfo = (new MusicInfo(splited[0], splited[1], splited[2], replaceSharp(splited[3])));

            if (musicInfo.isAnswer(replaceSharp(m))) {
                System.out.println(musicInfo.getTitle());
                musicInfoList.add(musicInfo);
            }
        }

        return musicInfoList.stream()
                .sorted()
                .map(each -> each.getTitle())
                .findFirst()
                .orElse("(None)");
    }

    private String replaceSharp(String s) {
        return s.replaceAll("C#", "c")
                .replaceAll("D#", "d")
                .replaceAll("F#", "f")
                .replaceAll("G#", "g")
                .replaceAll("B#", "b")
                .replaceAll("E#", "e")
                .replaceAll("A#", "a");
    }

    static class MusicInfo implements Comparable<MusicInfo> {
        String start;
        String end;
        String title;
        String info;

        public MusicInfo(String start, String end, String title, String info) {
            this.start = start;
            this.end = end;
            this.title = title;
            this.info = (info);
        }

        public String getTitle() {
            return this.title;
        }

        public int compareTo(MusicInfo other) {
            // 조건 일치 음악 여러 개 -> 재생된 시간이 제일 긴 거 -> 먼저 입력된 음악
            int a = diffTime();
            int b = other.diffTime();

            return b - a;
        }

        public boolean isAnswer(String m) {
            int diffTime = diffTime();
            System.out.println(diffTime);
            String played;
            if (info.length() > diffTime) {
                played = info.substring(0, diffTime);
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < diffTime; i++) {
                    sb.append(info.charAt(i % info.length()));
                }
                played = sb.toString();
            }
            System.out.println(played);
            return played.contains(m);
        }

        private int diffTime() {
            int startMinute = toMinute(start);
            int endMinute = toMinute(end);

            return endMinute - startMinute;
        }

        private int toMinute(String time) {
            String[] splitedTime = time.split(":");
            int hour = Integer.parseInt(splitedTime[0]);
            int minute = Integer.parseInt(splitedTime[1]);

            return hour * 60 + minute;
        }
    }
}
