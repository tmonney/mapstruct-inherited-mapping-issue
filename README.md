# mapstruct-inherited-mapping-issue

A reproducer for https://github.com/mapstruct/mapstruct/issues/2318

The project defines Maven profiles to test different MapStruct versions:
- `mapstruct-1.3` => 1.3.1.Final
- `mapstruct-1.4` => 1.4.1.Final
- `mapstruct-1.5` => 1.5.0-SNAPSHOT

As of writing (2020-12-30), tests fail with

`mvn clean test -Pmastruct-1.4`

`mvn clean test -Pmastruct-1.5`

But pass with

`mvn clean test -Pmastruct-1.3`
