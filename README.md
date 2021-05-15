# How to run

* Open a terminal window in intellij
* cd scratch
* Make sure you use java16  
* Run the following:
<pre>
java --module-path com.fudb.scratch/target/scratch-1.0-SNAPSHOT.jar --module com.fudb.scratch/com.fudb.scratch.App
</pre>

Use jlink to build a standalone application
* From the root directory of the project run:
<pre>
 jlink --module-path com.fudb.scratch/target/scratch-1.0-SNAPSHOT.jar --add-modules com.fudb.scratch --output scratch/standalone 
</pre>

* Args for add modules: 
<pre>
--add-modules=jdk.incubator.vector
</pre>