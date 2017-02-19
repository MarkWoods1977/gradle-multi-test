# Gradle multi test

## What it is

It is a standard gradle project (in SpringBoot) which has been modified to run both unit and integration tests as individual tasks.

## How does it work

A separate source set integration-test was added to hold slower tests and its configuration extends the test dependencies so will get spring boot test starter for free - more dependencies can be added like this
  
`integrationTestCompile 'org.assertj:assertj-core:3.0.0'` in the dependencies section.
  
## Running individual tests in gradle

Run unit tests by running the `test` task

Run integration tests by running the `integrationTest` task

## Can I add more test types such as performance test

Yes by following the same changes to gradle and adding a new folder to the src directory  

## Further reading

This project was created following a tutorial @ `https://www.petrikainulainen.net/programming/gradle/getting-started-with-gradle-integration-testing/`

The documentation here gives you a nice reference point that was helpful in understanding exactly how it all works in gradle `https://docs.gradle.org/2.4/userguide/java_plugin.html`