# Java HashMap – Most Used Methods (Quick Refresher)

A concise **README-style cheat sheet** covering the most commonly used `HashMap` methods in Java — perfect for **AP CSA**, **interviews**, and **real-world coding**.

---

## 📌 Basic Operations

### `put(K key, V value)`

Adds or updates a key–value pair.

```java
map.put("apple", 10);
```

### `get(Object key)`

Returns the value for the key (or `null` if missing).

```java
int qty = map.get("apple");
```

### `getOrDefault(Object key, V defaultValue)`

Safely retrieves a value with a fallback.

```java
int qty = map.getOrDefault("banana", 0);
```

### `containsKey(Object key)`

Checks if a key exists.

```java
map.containsKey("apple");
```

### `containsValue(Object value)`

Checks if a value exists anywhere in the map.

### `remove(Object key)`

Removes a key–value pair.

```java
map.remove("apple");
```

---

## 🔄 Conditional Updates

### `putIfAbsent(K key, V value)`

Inserts only if the key does not exist.

```java
map.putIfAbsent("orange", 5);
map.putIfAbsent(key, new ArrayList<>());
map.get(key).add(value);
```
Common mistake (don’t do this)
```java
map.put(key, new ArrayList<>()); // overwrites existing list every time
map.get(key).add(value);
```

Even better (one-liner): computeIfAbsent

This avoids doing get() separately:
```java
map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
```
Quick example: group words by first letter
```java
Map<Character, List<String>> map = new HashMap<>();

for (String s : words) {
char key = s.charAt(0);
map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
}
```
### `replace(K key, V value)`

Updates value only if key exists.

---

## 📊 Size & State

### `size()`

Returns number of key–value pairs.

### `isEmpty()`

Checks if the map is empty.

---

## 🔁 Iteration Methods

### `keySet()`

Iterate over keys.

```java
for (String key : map.keySet()) {
    System.out.println(key);
}
```

### `values()`

Iterate over values.

### `entrySet()` ⭐ **Most Important**

Iterate over keys and values together.

```java
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
```

---

## ⚡ Java 8+ Functional Methods

### `forEach((k, v) -> { ... })`

Cleaner iteration.

```java
map.forEach((k, v) -> System.out.println(k + ": " + v));
```

### `computeIfAbsent(K key, Function)`

Creates value if key is missing.

```java
map.computeIfAbsent("kiwi", k -> 1);
```

### `merge(K key, V value, BiFunction)`

Combines values cleanly.

```java
map.merge("apple", 1, (oldVal, add) -> oldVal + add);
```

---

## 🎯 Must-Know for AP CSA / Interviews

* `put`
* `get`
* `getOrDefault`
* `containsKey`
* `remove`
* `keySet`
* `entrySet`

Master these and you can solve **~99% of HashMap problems**.

---

## ⏱️ Time Complexity (Average Case)

| Operation          | Time |
| ------------------ | ---- |
| get / put / remove | O(1) |
| containsKey        | O(1) |
| iteration          | O(n) |

---

**Tip:** HashMaps do **not** preserve order. Use `LinkedHashMap` if order matters.
