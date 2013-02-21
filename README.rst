This project using Scala and SBT.

::

  $git clone {this repo}
  $cd httpstatus
  $sbt assembly
  $cd ./target/
  $ls *jar
  httpstatus-assembly-0.1-SNAPSHOT.jar

  $ java -jar httpstatus-assembly-0.1-SNAPSHOT.jar 4
  Status 400: Bad Request
  ...
  Status 449: Retry with

  $ java -jar httpstatus-assembly-0.1-SNAPSHOT.jar Bad
  Status 400: Bad Request
  Status 502: Bad Gateway
