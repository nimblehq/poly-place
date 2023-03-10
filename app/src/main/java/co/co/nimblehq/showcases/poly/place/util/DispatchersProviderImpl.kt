package co.co.nimblehq.showcases.poly.place.util

import kotlinx.coroutines.Dispatchers

class DispatchersProviderImpl : DispatchersProvider {

    override val io = Dispatchers.IO

    override val main = Dispatchers.Main

    override val default = Dispatchers.Default
}
