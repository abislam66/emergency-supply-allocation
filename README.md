# Emergency Supply Allocation

A Java project that models **real-world disaster preparedness** by determining
the minimum number of cities that must store emergency supplies so an entire
region remains covered during a crisis.

The solution uses **recursive backtracking** and **graph algorithms** to solve
an **NP-hard optimization problem** similar to the *dominating set problem*.

---

## Why This Matters
In disaster scenarios, storing supplies in every city is expensive and
inefficient. Instead, supplies must be placed strategically so that **every
city either contains supplies or is directly connected to one that does**.

This project determines whether such a strategy is possible given a strict
limit on the number of supply locations.

---

## What the Program Does
- Represents cities and roads as an **undirected graph**
- Searches for an optimal placement of emergency supply hubs
- Guarantees full regional coverage if a solution exists
- Outputs the cities selected as supply locations

---

## Key Algorithm
java
boolean allocateResources(
    HashMap<String, HashSet<String>> roadNetwork,
    int maxSupplyCities,
    HashSet<String> supplyLocations
)
Uses recursive backtracking to explore valid configurations

Prunes invalid branches early for efficiency

Solves a computationally difficult (NP-hard) problem

Project Structure
emergency-supply-allocation/
├── src/
│   ├── allocateResources.java
│   ├── extract_city.java
│   ├── helper.java
│   ├── main.java
│   └── city.txt
├── README.md
└── .gitignore
Input Format
City connections are read from src/city.txt:

makefile
Copy code
CityA: CityB (5), CityC (7)
CityB: CityA (5), CityD (10)
Distances are ignored — only connectivity is used.

How to Run
bash
Copy code
javac src/*.java
java -cp src main
When prompted:

Enter the input file: src/city.txt

Enter the maximum number of cities allowed to store supplies
Output

✔️ If a solution exists: prints the cities selected as supply hubs

❌ If not: reports that no valid configuration is possible

Skills Demonstrated

Recursive backtracking

Graph traversal and modeling

NP-hard problem solving

Java collections (HashMap, HashSet)

Clean project structure and file I/O
