# Key Concepts Covered

## 🔹 JDBC (Java Database Connectivity)

* Direct communication with the database
* Writing SQL queries manually
* Managing connections, statements, and result sets

---

## 🔹 Connection Pooling

* Avoids creating a new DB connection for every request
* Reuses existing connections from a pool
* Improves performance and scalability

---

## ⚡ Why Connection Pooling?

### ❌ Without Pooling

* Each request creates a new connection
* Expensive (network + authentication + resource allocation)
* Slower performance

---

### ✅ With Pooling

* Pre-created connections are reused
* Faster response time
* Efficient resource usage
