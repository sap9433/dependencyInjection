# Custom Object to Json Converter

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
```$xslt
signing.keyId=C4B4D83B  #(gpg --list-keys , last 8 digit )
signing.password=z_*** #(password that you used to sign keys)
signing.secretKeyRingFile=/Users/<ur machine username>/.gnupg/secring.gpg
ossrhUsername=sapy
ossrhPassword=<ossrhpassword from google key chain>
```
- gradle uploadArchives
- Dont forget to remove snapshot from version , 
- Now go to (https://oss.sonatype.org/#stagingRepositories) , select your repository , check, and click on close. It takes some time to close.
- Once you have successfully closed the staging repository, you can release it by pressing the Release button. This will move the components into the release repository of OSSRH where it will be synced to the Central Repository.
- If some of the guideline fails you will see the steps that failed in Red. and 'Release' button will not be activated
- Last 3 steps are well documented [here](https://central.sonatype.org/pages/gradle.html) and [here](https://central.sonatype.org/pages/releasing-the-deployment.html)
- After 10 minutes to 2hrs . Your changes will reflect [search.maven.org](https://search.maven.org/artifact/com.github.sap9433/dependency-inject/1.0/jar).

