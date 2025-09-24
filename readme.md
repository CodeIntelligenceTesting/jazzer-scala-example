# Jazzer Scala Example
This is a simple project demonstrating how to fuzz a Scala project with Jazzer. 
It includes standard unit tests (JUnit 5) and a fuzz test for Jazzer.

The example code contains a method that intentionally throws an exception for a specific set of inputs.

This example uses Jazzer version 0.25.1 and shows how you can run it directly from Maven.

For detailed information on how to use Jazzer, please refer to the [Jazzer documentation](https://github.com/CodeIntelligenceTesting/jazzer?tab=readme-ov-file#using-jazzer-via)

## Run
You can run Jazzer's fuzz tests as part of Maven tests in one of the following ways:
1. Run a fuzz test in the fuzzing mode. 
   ```shell
   JAZZER_FUZZ=1 mvn test -Dtest=ExploreMeTest#myFuzzTest
   ```
1. Run a fuzz test in the regression mode.
   ```shell
   mvn test -Dtest=ExploreMeTest#myFuzzTest
   ```
