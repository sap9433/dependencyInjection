# Custom Object to JsonMapper

A lightweight java plugin to convert object to a customized JSON String. 

## Possible uses
We often need to log objects for performance , security and data analysis. While logging we need to make
sure we inadvertently doesn't print secure information , also often there are organizational
requirement to log data in certain custom format . Lets say there is a requirement that if there is a field called `ip`,  while printing it json key should be `ipv4`. And it's tough to enforce those guidelines to different project
across the organization. This light weight project takes care of that.

## Usage guide 

## Steps for publishing (For Contributor of the project only ) -

- Create an [account](https://issues.sonatype.org/secure/Signup!default.jspa)
- Create a new Sonatype Open Source Project Repository Hosting [OSSRH](https://issues.sonatype.org/secure/CreateIssue.jspa)
- Your Project will be created . Wait for the ticket to [resolve](https://issues.sonatype.org/browse/OSSRH-50941)
- Create a [gpg key](https://central.sonatype.org/pages/working-with-pgp-signatures.html) . (brew install gpg2 , gpg --gen-key, gpg --list-keys, gpg --keyserver hkp://pool.sks-keyservers.net --send-keys CCB2F39ADC112552658A3EA60A1189B4C4B4D83B)
- Follow [this](https://central.sonatype.org/pages/gradle.html) to generate build.gradle.
- create gradle.properties in your root and add to .gitignore.[Add secret](https://docs.gradle.org/current/userguide/signing_plugin.html)
- gradle uploadArchives
- Dont forget to remove snapshot from version , 

