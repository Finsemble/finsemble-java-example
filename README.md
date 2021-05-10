# Example Java Projects for Finsemble

## Maven

The Finsemble Java library is available for use in a Maven _pom.xml_ file:

https://search.maven.org/artifact/com.chartiq.finsemble/finsemble

You can build the JAR files and the launch4j executable file using the `mvn package` command.

**Note:** The executable generated by launch4j is experimental and may not work correctly. Reach out to <a href="mailto:support@finsemble.com">support@finsemble.com</a> to receive Client Success support if you encounter difficulties.

## Examples provided
- JavaExample - Example JavaFX application
- JavaSwingExample - Example Java Swing application
- JavaHeadlessExample - Example of a window-less Java application
- AuthenticationExample - Example component that performs authentication from within Java
- MultiWindow - JavaSwingExample - Same as JavaSwingExample but running in multi-window (several windows running under the same
  process)
- MultiWindow - AuthenticationExample - Same as AuthenticationExample but running in multi-window (several windows running under the same
      process)


## Configuring the Java examples 
Copy the _java-example.json_ included in the project to _src/components/java-example/java-example.json_. Update the application manifest to include:
``` JSON
    "finsemble": {
        ...,
        "custom": {
            "javaExampleJarRoot": "<path_to_the_jar_files_directory>"
        },
        "importConfig": [
            "../../configs/application/config.json",
            "../../configs/application/java-example.json"
        ]
    }
```

**NOTE:**
- The _java-example.json_ file includes two copies of the JavaFX example: 
  - Java Example (local)
  -  Java Example (asset). 

The "local" component uses `javaExampleRoot` to specify the path to the JAR file on the local system. The "asset" component uses the `appAsset` to download and run the application - Please refer to our tutorial
on [integrating native applications](https://documentation.finsemble.com/tutorial-integratingNativeApplications.html) for more details.


