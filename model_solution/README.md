# APR-as-AAT

# com1003_cafe

This is the orignal version of the **com1003_cafe** project, only changing the Java version from 17 to 8.

# Randoop

### For multiple classes

```shell
java -Xmx3000m -classpath 1/build/classes/java/main:randoop-all-4.3.2.jar randoop.main.Main gentests --classlist=classes_solution.txt --no-error-revealing-tests=false --time-limit=60 --junit-output-dir=randoop-output
```

### For a single class

```shell
java -Xmx3000m -classpath com1003_cafe_8/build/classes/java/main:randoop-all-4.3.2.jar randoop.main.Main gentests --testclass=uk.ac.sheffield.com1003.cafe.Cafe --no-error-revealing-tests=true --time-limit=60 --junit-output-dir=randoop-output
```

