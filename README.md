# TestBench Simplest Demo

This project is a demo on how to use Vaadin TestBench.
If you are looking for more information on TestBench, see https://vaadin.com/docs/v10/testbench/testbench-overview.html

This project also uses Karibu-Testing Vaadin unit testing; for details
please see https://github.com/mvysny/karibu-testing/ .

This project uses Vaadin 14.

## Running the Example

The project is built using Maven. A similar setup can be done using other build systems as well.
The Maven project can easily be imported into any IDE supporting
Maven or used via the command line interface. Maven can be downloaded from:
http://maven.apache.org.

The project produces a standard WAR file containing a simple application written with Vaadin.
During the build process all tests are automatically run:
* TestBench tests are run against the final war file using a Jetty server;
* Karibu-Testing tests run as regular unit tests

The tests can be run from the command line by issuing the following command:

```
mvn -C clean verify
```

If you are running `MyFirstIT` tests directly via an IDE, you might need to deploy the
project beforehand to http://localhost:8080/. Any method will do, but the easiest
one is probably Maven and the jetty-maven-plugin:

```
mvn -C jetty:run
```

The `MyFirstUnitTest` tests do not require a running server and can be launched
easily via the IDE.

### Sample code classes explained

The source code for the application to be tested is given in the `src/main/java` subfolder.

Both the TestBench tests and Karibu-Testing tests are located under the
`src/test/java` subfolder.
