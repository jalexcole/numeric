# numeric
Numeric is a numpy replica done in kotlin. At the moment the goal is to add as many features for vector operations without consern for optimazitions. 

## Getting Started
The main functions of this library are held in the numeric.numeric package. 

Example:
```kotlin

val nk = numeric // the main api object

val x = nk.linspace(0.0, 1.0) // creates an array from 0.0 to 1.0 with a size of 50
val y = x * 3 // multiplying all x array elements by 3
println(y.toString()) 
```

For more information visit the wiki https://github.com/jalexcole/numeric/wiki

Gradle Dependency
```groovy
repositories {
        jcenter()
        maven { url "https://jitpack.io" }
   }
   dependencies {
         implementation 'com.github.jalexcole:numeric:0.0.1'
   }
```
 


### Primary Goal
Add in as many numpy features as possible and optimize as nessary.

Incorporate into Numerical Methods.

### Later Goals
Incorporate JEP 338 into a jvm section for further optimization.
Move to kotlin multiplatform
