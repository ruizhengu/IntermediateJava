# IntermediateJava

## A dataset of 296 programs for an intermediate-level Java programming assignment

### Pre-processing

* Discard the submissions with major compilation issues, and fix the ones with minor compilation issues.
* Discard the submissions that contain infinite loops.
* Add missed classes for each submission (mainly the App and the exception classes).
* If a submission can not compile with the test suite, manually modify it.
* If there is a mismatch between the actual number of failed tests and the number of negative tests identified by ARJA, modify the program.
* Make sure there is no compilation error when replacing the methods of the programs with the methods from the model solution.
