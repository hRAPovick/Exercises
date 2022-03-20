package exercises.spotify;

import lombok.Data;
import org.junit.Test;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static exercises.enums.LastName.getRandomStringLastName;
import static exercises.enums.Name.getRandomStringName;
import static exercises.enums.Songs.getById;

/*
    Имеем лист объектов с полями user_id, song_id.
    Определить наиболее часто прослушиваемые треки у каждого юзера.
 */
public class Spotify {
    @Data
    class Listening {
        private int userId;
        private int songId;

        public Listening() {
            userId = new Random().nextInt(10);
            songId = new Random().nextInt(100);
        }
    }

    @Test
    public void spotyQuestFirst() {
        Map<Integer, List<Listening>> userToListening = IntStream.range(0, 1000)
                .mapToObj(x -> new Listening())
                .collect(Collectors.groupingBy(Listening::getUserId));
        Map<Object, Integer> map = userToListening.entrySet().stream()
                .map(
                        listening -> {
                            Map<Integer, Long> songIdToCount = listening.getValue().stream()
                                    .collect(Collectors.groupingBy(Listening::getSongId, Collectors.counting()));
                            Integer favouriteSongId = Objects.requireNonNull(songIdToCount.entrySet()
                                            .stream()
                                            .max(Comparator.comparingLong(Map.Entry::getValue))
                                            .orElse(null))
                                    .getKey();
                            return new AbstractMap.SimpleEntry<>(listening.getKey(), favouriteSongId);
                        }
                ).collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue));
        for (Map.Entry<Object, Integer> entry : map.entrySet()) {
            System.out.println(
                    entry.getKey() + " " + getRandomStringName() + " " +
                            getRandomStringLastName() + " ---- " + getById(entry.getValue()));
        }
    }
}
