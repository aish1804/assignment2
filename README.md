<<<<<<< HEAD
# Assignment2 — Restaurant Observer Demo

This project demonstrates a small refactor of a restaurant/customer system using the Observer pattern. It includes a runnable demo and a JUnit test suite.

Files of interest
- `src/main/java/restaurant` — runnable demo (Client, Restaurant, ErieFamousRestaurant, Customer, Phone, FoodObserver).
- `src/main/java/RefactoringDesignPatterns/Assignment2` — classes used by the provided JUnit tests (Customer, Phone, ErieFamousRestaurant, Restaurant, FoodObserver).
- `RestaurantProject/src/src/test` — JUnit 5 tests (RestaurantObserverTest.java).
- `jenkinsfile/Jenkinsfile` — original CI pipeline (kept for history); a root-level `Jenkinsfile` may be added so Jenkins can pick it by default.

Run locally (no Gradle required)
1. Compile the demo classes and tests (bash on Windows):
```bash
cd /c/Users/aishw/Downloads/Assignment2
mkdir -p build/classes
javac -d build/classes $(find src/main/java RestaurantProject/src/src/main -name "*.java")
```
2. Run the demo:
```bash
java -cp build/classes restaurant.Client
```

Run with Gradle (recommended)
The repository includes a Gradle wrapper so you can build and run tests reproducibly.
```bash
cd /c/Users/aishw/Downloads/Assignment2
./gradlew clean test
```

Notes
- I removed macOS metadata (`__MACOSX`) that caused javac errors.
- I added a `.gitignore` to avoid committing build and IDE artifacts.
- Tests now run via Gradle; the build was adjusted to include a nonstandard test source directory because tests are located in `RestaurantProject/src/src/test`.
- CI: a robust `Jenkinsfile` that prefers `./gradlew`, falls back to `gradle`, and includes a JUnit Console fallback is available in the repo root.

If you want me to tidy the package/layout (move all sources to a single canonical package structure) or remove legacy duplicates, I can do that next.

