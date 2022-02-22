package org.docheinstein.minimotek.database.server

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import org.docheinstein.minimotek.util.info
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.math.roundToLong
import kotlin.random.Random

@Singleton
class ServerRepository @Inject constructor(private val serverDao: ServerDao) {
    val servers: Flow<List<Server>> = serverDao.loadAll()

    fun load(id: Long): Flow<Server> {
        return serverDao.load(id)
    }

    suspend fun save(server: Server) {
        info("Saving server $server")
        delay((2000 * Random.nextFloat()).roundToLong()) // simulate latency
        serverDao.save(server)
    }

    suspend fun delete(server: Server) {
        info("Deleting server $server")
        delay((2000 * Random.nextFloat()).roundToLong()) // simulate latency
        serverDao.delete(server)
    }
}