# TestBench Demo

This project is a collection of samples on how to use Vaadin TestBench.
If you are looking for more information on TestBench, see https://vaadin.com/docs/v10/testbench/testbench-overview.html

This version is for Vaadin 14.

## Running the Example

The project is built using Maven. A similar setup can be done using other build systems as well.
The Maven project can easily be imported into any IDE supporting
Maven or used via the command line interface. Maven can be downloaded from:
http://maven.apache.org.

The project produces a standard WAR file containing a simple calculator application written with Vaadin.
During the build process TestBench tests are automatically run against the final
war file using a Jetty server. The tests can be run from the
command line by issuing the following command:

```
mvn verify
```

If you are running specific tests directly via an IDE, you might need to deploy the
project beforehand to http://localhost:8080/. Any method will do, but the easiest
one is probably Maven and the jetty-maven-plugin:

```
mvn jetty:run
```

### Sample code classes explained

The source code for the application to be tested, a desktop calculator
application, is given in the `src/main/java` subfolder.

The TestBench tests for the application are located under the
`src/test/java` subfolder.
