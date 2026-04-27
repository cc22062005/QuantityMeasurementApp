# Quantity Measurement App

A Java-based application that measures and compares physical quantities such as **length** and **weight** across multiple units. Built using Test-Driven Development (TDD) with JUnit, the app supports equality checks, unit conversions, and addition operations for different measurement types.

## Features

- Compare lengths in Feet, Inches, Yards, and Centimeters
- Compare weights in Kilograms, Grams, and Pounds
- Convert between units of the same measurement type
- Add two quantities and get results in a desired unit
- Generic `Quantity` class design for extensibility across measurement categories

## Tech Stack

- **Language:** Java
- **Testing:** JUnit 5
- **Build Tool:** Maven
- **Version Control:** Git & GitHub

## Use Cases

| UC | Description | Branch | Pull Request |
|----|-------------|--------|--------------|
| UC1 | Feet Equality - Compare two feet measurements for equality | [feature/UC1-FeetEquality](https://github.com/cc22062005/QuantityMeasurementApp/tree/feature/UC1-FeetEquality) | [PR #1](https://github.com/cc22062005/QuantityMeasurementApp/pull/1) |
| UC2 | Inches Equality - Compare two inches measurements for equality | [feature/UC2-InchesEquality](https://github.com/cc22062005/QuantityMeasurementApp/tree/feature/UC2-InchesEquality) | [PR #2](https://github.com/cc22062005/QuantityMeasurementApp/pull/2) |
| UC3 | Quantity Length - Generic class for length measurements | [feature/UC3-QuantityLength](https://github.com/cc22062005/QuantityMeasurementApp/tree/feature/UC3-QuantityLength) | [PR #3](https://github.com/cc22062005/QuantityMeasurementApp/pull/3) |
| UC4 | Extended Units - Add support for Yards and Centimeters | [feature/UC4-ExtendedUnits](https://github.com/cc22062005/QuantityMeasurementApp/tree/feature/UC4-ExtendedUnits) | [PR #4](https://github.com/cc22062005/QuantityMeasurementApp/pull/4) |
| UC5 | Unit Conversion - Convert between different length units | [feature/UC5-UnitConversion](https://github.com/cc22062005/QuantityMeasurementApp/tree/feature/UC5-UnitConversion) | [PR #5](https://github.com/cc22062005/QuantityMeasurementApp/pull/5) |
| UC6 | Length Addition - Add two length quantities | [feature/UC6-LengthAddition](https://github.com/cc22062005/QuantityMeasurementApp/tree/feature/UC6-LengthAddition) | [PR #6](https://github.com/cc22062005/QuantityMeasurementApp/pull/6) |
| UC7 | Target Unit Addition - Add lengths with a specified target unit | [feature/UC7-TargetUnitAddition](https://github.com/cc22062005/QuantityMeasurementApp/tree/feature/UC7-TargetUnitAddition) | [PR #7](https://github.com/cc22062005/QuantityMeasurementApp/pull/7) |
| UC8 | Refactor Enum - Refactor unit enums for cleaner design | [feature/UC8-RefactorEnum](https://github.com/cc22062005/QuantityMeasurementApp/tree/feature/UC8-RefactorEnum) | [PR #8](https://github.com/cc22062005/QuantityMeasurementApp/pull/8) |
| UC9 | Weight Measurement - Add weight measurements (kg, g, lb) | [feature/UC9-WeightMeasurement](https://github.com/cc22062005/QuantityMeasurementApp/tree/feature/UC9-WeightMeasurement) | [PR #9](https://github.com/cc22062005/QuantityMeasurementApp/pull/9) |

## Project Structure

```
src/
├── main/java/com/quantitymeasurement/
│   ├── LengthUnit.java
│   ├── QuantityLength.java
│   ├── WeightUnit.java
│   └── QuantityWeight.java
└── test/java/com/quantitymeasurement/
    ├── FeetTest.java
    ├── InchesTest.java
    ├── QuantityLengthTest.java
    ├── UC4ExtendedUnitsTest.java
    └── WeightTest.java
```

## Author

**P Chandan Kumar**
