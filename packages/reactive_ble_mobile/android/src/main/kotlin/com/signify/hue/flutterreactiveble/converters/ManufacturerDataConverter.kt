package com.signify.hue.flutterreactiveble.converters

import android.util.SparseArray

fun extractManufacturerData(manufacturerData: SparseArray<ByteArray>?): ByteArray {
    val rawData = mutableListOf<Byte>()

    if (manufacturerData != null) {
        for (i in 0 until manufacturerData.size()) {
            val companyId = manufacturerData.keyAt(i)
            val payload = manufacturerData.valueAt(i)

            rawData.add((companyId.toByte()))
            rawData.add(((companyId.shr(Byte.SIZE_BITS)).toByte()))
            rawData.addAll(payload.asList())
        }
    }

    return rawData.toByteArray()
}
