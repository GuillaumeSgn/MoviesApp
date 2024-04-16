# detekt

## Metrics

* 28 number of properties

* 16 number of functions

* 1 number of classes

* 3 number of packages

* 11 number of kt files

## Complexity Report

* 529 lines of code (loc)

* 467 source lines of code (sloc)

* 277 logical lines of code (lloc)

* 17 comment lines of code (cloc)

* 23 cyclomatic complexity (mcc)

* 1 cognitive complexity

* 5 number of total code smells

* 3% comment source ratio

* 83 mcc per 1,000 lloc

* 18 code smells per 1,000 lloc

## Findings (5)

### formatting, FinalNewline (1)

Detects missing final newlines

[Documentation](https://detekt.dev/docs/rules/formatting#finalnewline)

* C:/Users/w190788/projet/projetfilms/presentation/src/test/java/com/example/presentation/ExampleUnitTest.kt:1:1
```
File must end with a newline (\n)
```
```kotlin
1 package com.example.presentation
! ^ error
2 
3 import org.junit.Assert.*
4 import org.junit.Test

```

### formatting, ImportOrdering (1)

Detects imports in non default order

[Documentation](https://detekt.dev/docs/rules/formatting#importordering)

* C:/Users/w190788/projet/projetfilms/presentation/src/test/java/com/example/presentation/ExampleUnitTest.kt:3:1
```
Imports must be ordered in lexicographic order without any empty lines in-between with "java", "javax", "kotlin" and aliases in the end
```
```kotlin
1 package com.example.presentation
2 
3 import org.junit.Assert.*
! ^ error
4 import org.junit.Test
5 
6 /**

```

### formatting, NoConsecutiveBlankLines (1)

Reports consecutive blank lines

[Documentation](https://detekt.dev/docs/rules/formatting#noconsecutiveblanklines)

* C:/Users/w190788/projet/projetfilms/presentation/src/main/java/com/example/presentation/ListMovies.kt:16:1
```
Needless blank line(s)
```
```kotlin
13 import com.example.projetfilms.ui.theme.ProjetFilmsTheme
14 import com.example.projetfilms.viewModel.ListViewModel
15 
16 @Composable
!! ^ error
17 fun ListMovies(toDetails: (Int) -> Unit, viewModel: ListViewModel?) {
18     viewModel?.let {
19         val moviesPop by viewModel.popular.collectAsState()

```

### formatting, NoWildcardImports (1)

Detects wildcard imports

[Documentation](https://detekt.dev/docs/rules/formatting#nowildcardimports)

* C:/Users/w190788/projet/projetfilms/presentation/src/test/java/com/example/presentation/ExampleUnitTest.kt:3:1
```
Wildcard import
```
```kotlin
1 package com.example.presentation
2 
3 import org.junit.Assert.*
! ^ error
4 import org.junit.Test
5 
6 /**

```

### style, WildcardImport (1)

Wildcard imports should be replaced with imports using fully qualified class names. Wildcard imports can lead to naming conflicts. A library update can introduce naming clashes with your classes which results in compilation errors.

[Documentation](https://detekt.dev/docs/rules/style#wildcardimport)

* C:/Users/w190788/projet/projetfilms/presentation/src/test/java/com/example/presentation/ExampleUnitTest.kt:3:1
```
org.junit.Assert.* is a wildcard import. Replace it with fully qualified imports.
```
```kotlin
1 package com.example.presentation
2 
3 import org.junit.Assert.*
! ^ error
4 import org.junit.Test
5 
6 /**

```

generated with [detekt version 1.23.3](https://detekt.dev/) on 2024-04-16 13:24:07 UTC
