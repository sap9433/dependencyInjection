# Dependency Injection
A lightweight java plugin to inject dependency . Useful, if your project is not a spring boot project , and you still want to leverage the power of DI without adding the full fled-get spring-core jar . 

## Possible uses

We were working on a Spark application using java . we wanted to leverage dependency injection . Noticed there is no stand alone jar for that ,
Only way was to ass spring jars to our dependency . Which we didn't want . So wrote this stand alone jar.


## Steps for publishing -

- Create an [account](https://issues.sonatype.org/secure/Signup!default.jspa)
- Create a new Sonatype Open Source Project Repository Hosting [OSSRH](https://issues.sonatype.org/secure/CreateIssue.jspa)
- Your Project will be created . Wait for the ticket to [resolve](https://issues.sonatype.org/browse/OSSRH-50941)
- Create a [gpg key](https://central.sonatype.org/pages/working-with-pgp-signatures.html) . (brew install gpg2 , gpg --gen-key, gpg --list-keys, gpg --keyserver hkp://pool.sks-keyservers.net --send-keys CCB2F39ADC112552658A3EA60A1189B4C4B4D83B)