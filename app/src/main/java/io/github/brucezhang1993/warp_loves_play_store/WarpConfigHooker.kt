package io.github.brucezhang1993.warp_loves_play_store

import com.highcapable.yukihookapi.hook.entity.YukiBaseHooker
import com.highcapable.yukihookapi.hook.factory.constructor
import com.highcapable.yukihookapi.hook.factory.method
import com.highcapable.yukihookapi.hook.log.YLog
import com.highcapable.yukihookapi.hook.type.java.StringClass
import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonBuilder
import kotlinx.serialization.serializer
import org.json.JSONStringer

object WarpConfigHooker : YukiBaseHooker() {
    override fun onHook() {
        "com.cloudflare.app.data.warpapi.WarpTunnelConfig".toClass().constructor {
            paramCount = 3
        }.hook().before {
            args.forEach { arg ->
                YLog.info("WarpTunnelConfig: ${arg.toString()}")
            }
        }
    }
}
