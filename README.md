# Custom Object to Json Converter

A lightweight java plugin to convert object to a customized JSON String. Available in [MVN Central](https://mvnrepository.com/artifact/com.github.sap9433/dependency-inject).

## Possible uses
We often need to log objects for performance , security and data analysis. While logging we need to make
sure we inadvertently doesn't print secure information , also often there are organizational
requirement to log data in certain custom format . Lets say there is a requirement that if there is a field called `ip`,  while printing it json key should be `ipv4`. And it's tough to enforce those guidelines to different project
across the organization. This light weight project takes care of that.

## Usage guide 

- Include the dependency in your project-
If you are using gradle in your `build.gradle`
```
dependencies {
    ....
    compile "com.github.sap9433:dependency-inject:1.1"
}
```
If you are using Maven , in your `pom.xml`

```
 <dependency>
  <groupId>com.github.sap9433</groupId>
  <artifactId>dependency-inject</artifactId>
  <version>1.1</version>
</dependency>  
```
- Lets say Booking.java is the class that you want to convert to json. Then use `@IncludePrint` for the Fields that you want to include in the JSON
```
import java.util.List;

public class Booking {
    @IncludePrint
    private long bookingId;
    @IncludePrint
    private String description;
    private List<String> dontPrint;

    ....
    ....
    Getter setters and constructors and etc..
    ....
    ....
}
```

- Now where you want to conver The instance of the class to JSON

```
import java.util.Arrays;

public class Transaction {
    public static void main(String[] args) {
        Booking booking = new Booking(21   , "My Booking", Arrays.asList("Pass", "Secret"));
        ExpediaJsonFormatter customFormatter = new ExpediaJsonFormatter();
        try {
            String jsonString = customFormatter.expediaJsonString(booking);
            System.out.println(jsonString);
        } catch (PrintingException pe){ }
    }
}
```

- you should see output as.
```
{"description":"My Booking","bookingId":"21"}
```

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
- to upload your changes to sonatype release manager - `gradle uploadArchives`
- Dont forget to remove snapshot from version , 
- Now go to (https://oss.sonatype.org/#stagingRepositories) , select your repository , check, and click on `close`. It takes some time to close.
- Once you have successfully closed the staging repository, you can release it by pressing the `Release` button. This will move the components into the release repository of OSSRH where it will be synced to the Central Repository.
- If some of the guideline fails you will see the steps that failed in Red. and 'Release' button will not be activated. Drop it and re upload and reclose.
- Last 3 steps are well documented [here](https://central.sonatype.org/pages/gradle.html) and [here](https://central.sonatype.org/pages/releasing-the-deployment.html)
- After 10 minutes to 2hrs . Your changes will reflect [search.maven.org](https://search.maven.org/artifact/com.github.sap9433/dependency-inject/1.0/jar).
- changes should be available immediately after release in [release site](https://oss.sonatype.org/content/repositories/staging/com/github/sap9433/dependency-inject/)

