package io.github.brucezhang1993.warp_loves_play_store

import com.highcapable.yukihookapi.hook.entity.YukiBaseHooker
import com.highcapable.yukihookapi.hook.factory.method
import com.highcapable.yukihookapi.hook.type.java.StringClass

object PlayStoreWhitelistHooker : YukiBaseHooker() {
    override fun onHook() {
        "android.net.VpnService\$Builder".toClass().method {
            name = "addDisallowedApplication"
            param(StringClass)
            returnType = "android.net.VpnService\$Builder".toClass()
        }.hook().before {
            val param1 = args().first().string();
            if ("com.android.vending" == param1) {
                result = instanceOrNull
                return@before
            }
        }
    }
}
