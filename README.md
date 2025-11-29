# Assignment2 — Restaurant Observer Demo

This project demonstrates a small refactor of a restaurant/customer system using the Observer pattern. It includes a runnable demo and a JUnit test suite.

Files of interest
- `src/main/java/restaurant` — runnable demo (Client, Restaurant, ErieFamousRestaurant, Customer, Phone, FoodObserver).
- `src/main/java/RefactoringDesignPatterns/Assignment2` — classes used by the provided JUnit tests (Customer, Phone, ErieFamousRestaurant, Restaurant, FoodObserver).
- `RestaurantProject/src/src/test` — JUnit 5 tests (RestaurantObserverTest.java).
- `jenkinsfile/Jenkinsfile` — CI pipeline updated to publish test results and handle cases where Gradle wrapper is not present.

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
- Tests now run via Gradle; I added the nonstandard test source dir to `build.gradle` because tests are located in `RestaurantProject/src/src/test`.
- CI Jenkinsfile was updated to be robust: prefers `./gradlew`, falls back to system `gradle`, and otherwise runs tests using the JUnit Console Launcher and publishes results.

If you want me to tidy package/layout (move all sources to a single canonical package structure), or to remove legacy duplicates, I can do that next.
