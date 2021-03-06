/*  __    __  __  __    __  ___
 * \  \  /  /    \  \  /  /  __/
 *  \  \/  /  /\  \  \/  /  /
 *   \____/__/  \__\____/__/
 *
 * Copyright 2014-2017 Vavr, http://vavr.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.vavr.kotlin

import io.vavr.Value
import io.vavr.collection.List
import io.vavr.collection.Map
import io.vavr.collection.Stream

/**
 * Constructors and Kotlin collection converters for the Vavr collection values
 *
 * @author Alex Zuzin (github.com/zvozin)
 */

/**
 * @see List.of
 */
fun <T> list(vararg t: T):
        List<T> = List.of(*t)

/**
 * Converts a Value (that is, _any_ Vavr data class) into a Kotlin MutableList
 */
fun <T> Value<T>.toMutableList():
        MutableList<T> = this.toJavaList().toMutableList()

/**
 * Converts a Kotlin Iterable into a List
 */
fun <T> Iterable<T>.toVavrList():
        List<T> = List.ofAll(this)

/**
 * Converts a Kotlin Array into a List
 */
fun <T> Array<T>.toVavrList():
        List<T> = List.ofAll(this.asIterable())

/**
 * @see Stream.of
 */
fun <T> stream(vararg t: T):
        Stream<T> = Stream.of(*t)

/**
 * @see Stream.ofAll
 */
fun <T> Iterable<T>.toVavrStream():
        Stream<T> = Stream.ofAll(this)

/**
 * Converts a Kotlin Array into a Stream
 */
fun <T> Array<T>.toVavrStream():
        Stream<T> = Stream.ofAll(this.asIterable())

/**
 * Converts a Kotlin Sequence into a Stream
 */
fun <T> Sequence<T>.toVavrStream():
        Stream<T> = Stream.ofAll(this.asIterable())

/**
 * Converts a Kotlin Map into a Vavr Map
 */
fun <K, V> kotlin.collections.Map<K, V>.toVavrMap():
        io.vavr.collection.Map<K, V> = io.vavr.collection.HashMap.ofAll(this)

/**
 * Converts a Vavr Map to a Kotlin MutableMap
 */
fun <K, V> io.vavr.collection.Map<K, V>.toMutableMap():
        kotlin.collections.MutableMap<K, V> = this.toJavaMap().toMutableMap()

/**
 * Creates a Vavr HashMap from a series of Kotlin Pairs
 */
fun <K, V> hashMap(vararg p: Pair<K, V>):
        io.vavr.collection.HashMap<K, V> =
        io.vavr.collection.HashMap.ofEntries(p.asIterable().map { it.tuple() })

/**
 * Creates a Vavr LinkedHashMap from a series of Kotlin Pairs
 */
fun <K, V> linkedHashMap(vararg p: Pair<K, V>):
        io.vavr.collection.LinkedHashMap<K, V> =
        io.vavr.collection.LinkedHashMap.ofEntries(p.asIterable().map { it.tuple() })

/**
 * Creates a Vavr TreeMap from a series of Kotlin Pairs.
 * Notice that the keys of a TreeMap must be Comparable
 */
fun <K : Comparable<K>, V> treeMap(vararg p: Pair<K, V>):
        io.vavr.collection.TreeMap<K, V> =
        io.vavr.collection.TreeMap.ofEntries(p.asIterable().map { it.tuple() })

/**
 * Returns the value associated with a key, or null if the key is not contained in the map.
 */
fun <K, V> Map<K, V>.getOrNull(key: K):
        V? = this.getOrElse(key, null)

/**
 * Converts a Kotlin Set into a Vavr Set
 */
fun <T> kotlin.collections.Set<T>.toVavrSet():
        io.vavr.collection.Set<T> = io.vavr.collection.HashSet.ofAll(this)

/**
 * Converts a Vavr Set into a Kotlin MutableSet
 */
fun <T> io.vavr.collection.Set<T>.toMutableSet():
        kotlin.collections.MutableSet<T> = this.toJavaSet().toMutableSet()

/**
 * Creates a Vavr HashSet
 */
fun <T> hashSet(vararg t: T):
        io.vavr.collection.HashSet<T> = io.vavr.collection.HashSet.ofAll(t.asIterable())

/**
 * Creates a Vavr LinkedHashSet
 */
fun <T> linkedHashSet(vararg t: T):
        io.vavr.collection.LinkedHashSet<T> = io.vavr.collection.LinkedHashSet.ofAll(t.asIterable())

/**
 * Creates a Vavr TreeSet.
 * Notice that the elements of a TreeSet must be Comparable
 */
fun <T : Comparable<T>> treeSet(vararg t: T):
        io.vavr.collection.TreeSet<T> =
        io.vavr.collection.TreeSet.ofAll(t.asIterable())