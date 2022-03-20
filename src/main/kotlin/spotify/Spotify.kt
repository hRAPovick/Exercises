package spotify

import exercises.enums.LastName.getRandomStringLastName
import exercises.enums.Name.getRandomStringName
import exercises.enums.Songs.getById
import org.junit.Test
import java.util.Random

/*
    Имеем лист объектов с полями user_id, song_id.
    Определить наиболее часто прослушиваемые треки у каждого юзера.
 */
class Spotify {
    data class Listening(
        val userId: Int = Random().nextInt(10),
        val songId: Int = Random().nextInt(100)
    )

    @Test
    fun test() {
        (0..1000).asSequence()
            .map { Listening() }
            .groupBy { it.userId }
            .map {
                it.key to it.value
                    .groupBy { group -> group.songId }
                    .map { map -> map.key to map.value.count() }
                    .maxByOrNull { max -> max.second }
            }.sortedBy { it.first }
            .forEach {
                val s = "" + it.first + " " + getRandomStringName() + " " + getRandomStringLastName() +
                    " listened " + getById(it.second!!.first) + " " + it.second!!.second + " times"
                println(s)
            }
    }
}