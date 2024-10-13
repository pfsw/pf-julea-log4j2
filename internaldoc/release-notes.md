# Release notes for pf-julea-log4j2 (JUnit Log Event Assertion)

## Version 2.0.1 (13/10/2024), 25 Unit-Tests, 100.0% Coverage

- Fixed parent appenders detection to ensure that julea does not prevent explicitly configured logging.

## Version 2.0.0 (01/09/2024), 25 Unit-Tests, 100.0% Coverage

- Extracted generic part to pf-julea-core
- Setting additivity of in-memory appender to true if necessary to ensure configured log output to other appenders doesn't get lost

## Version 1.1.0 (20/07/2023), 23 Unit-Tests, 93.4% Coverage

- Support for enum values in assertion methods
- New interfaces to be implemented by test classes:
    - Junit4Log4j2Asserter
    - Junit5Log4j2Asserter
- Removed dependencies from published pom file to avoid transitive inclusion of the 2 junit libraries

## Version 1.0.0 (16/09/2022), 11 Unit-Tests, 93.0% Coverage

- log event assertion for junit 4
- log event assertion for junit 5
