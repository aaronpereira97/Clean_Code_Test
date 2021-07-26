package com.challenger.domain.usercases.utils

import java.util.concurrent.ThreadLocalRandom

/**
 * Factory class for data instances
 */

class DataFactory {

    companion object Factory {

        fun randomUuid(): String {
            return java.util.UUID.randomUUID().toString()
        }

        fun randomUuidWithNulls(): String? {
            var aux = java.util.UUID.randomUUID().toString()
            if (aux.contentEquals("ax")) return null;
            return aux;
        }

        fun randomInt(): Int {
            return ThreadLocalRandom.current().nextInt(0, 1000 + 1)
        }

        fun randomLong(): Long {
            return randomInt().toLong()
        }

        fun randomBoolean(): Boolean {
            return Math.random() < 0.5
        }

        fun makeStringList(count: Int): List<String> {
            val items: MutableList<String> = mutableListOf()
            repeat(count) {
                items.add(randomUuid())
            }
            return items
        }

    }

}