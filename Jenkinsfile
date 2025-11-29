pipeline {
    agent any

    environment {
        GRADLE_OPTS = "-Dorg.gradle.jvmargs=-Xmx512m"
    }

    stages {
        stage('Prepare') {
            steps { echo "Preparing workspace..." }
        }

        stage('Build') {
            steps {
                echo 'Building project (prefer ./gradlew)'
                script {
                    if (fileExists('./gradlew')) {
                        // Ensure the Gradle wrapper is executable on the agent
                        sh 'chmod +x ./gradlew || true'
                        sh './gradlew clean assemble --console=plain'
                    } else if (sh(returnStatus: true, script: 'gradle --version') == 0) {
                        sh 'gradle clean assemble --console=plain'
                    } else {
                        sh '''
                        mkdir -p build/classes
                        if [ -d src/main/java ]; then
                          find src/main/java -name '*.java' | xargs -r javac -d build/classes || true
                        fi
                        '''
                    }
                }
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests (Gradle preferred; fallback to JUnit Console)'
                script {
                    if (fileExists('./gradlew')) {
                        // Ensure the Gradle wrapper is executable on the agent
                        sh 'chmod +x ./gradlew || true'
                        sh './gradlew test --console=plain'
                    } else if (sh(returnStatus: true, script: 'gradle --version') == 0) {
                        sh 'gradle test --console=plain'
                    } else {
                        sh '''
                        set -e
                        mkdir -p test-results build/test-classes build/classes
                        CONSOLE_JAR=junit-platform-console-standalone.jar
                        if [ ! -f "$CONSOLE_JAR" ]; then
                          echo "Downloading JUnit Platform Console Standalone..."
                          curl -sSfL -o "$CONSOLE_JAR" "https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.9.3/junit-platform-console-standalone-1.9.3.jar"
                        fi
                        if [ -d src/main/java ]; then
                          find src/main/java -name '*.java' | xargs -r javac -d build/classes || true
                        fi
                        if [ -d src/test/java ]; then
                          find src/test/java -name '*.java' | xargs -r javac -cp build/classes:"$CONSOLE_JAR" -d build/test-classes || true
                        fi
                        if [ -d RestaurantProject/src/src/test ]; then
                          find RestaurantProject/src/src/test -name '*.java' | xargs -r javac -cp build/classes:"$CONSOLE_JAR" -d build/test-classes || true
                        fi
                        java -jar "$CONSOLE_JAR" --class-path build/classes:build/test-classes --scan-class-path --reports-dir test-results || true
                        '''
                    }
                }
            }

            post {
                always {
                    junit allowEmptyResults: true, testResults: '**/build/test-results/**/TEST-*.xml,**/test-results/*.xml'
                    publishHTML (target: [
                        reportDir: 'build/reports/tests/test',
                        reportFiles: 'index.html',
                        reportName: 'Gradle Test Report',
                        allowMissing: true,
                        alwaysLinkToLastBuild: true,
                        keepAll: true
                    ])
                }
            }
        }

        stage('Archive') {
            steps {
                echo 'Archiving build outputs (if any)'
                archiveArtifacts artifacts: 'build/libs/**/*.jar', allowEmptyArchive: true
            }
        }
    }

    post {
        success { echo 'Build and tests succeeded.' }
        failure { echo 'Build or tests failed. See console log and test reports.' }
    }
}
