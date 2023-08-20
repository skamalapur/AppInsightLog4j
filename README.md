1) Only Warn and ERROR are sent to application insight by default
2) Should include these libraries in the pom file
````
  		<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<java.version>1.8</java.version>
		<log4j.version>2.11.2</log4j.version>
		<disruptor.version>3.4.2</disruptor.version>
		<jackson.version>2.9.8</jackson.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>com.microsoft.azure</groupId>
			<artifactId>applicationinsights-runtime-attach</artifactId>
			<version>3.4.15</version>
		</dependency>
		<dependency>
			<groupId>com.microsoft.azure</groupId>
			<artifactId>applicationinsights-core</artifactId>
			<version>3.4.15</version>
		</dependency>
		<dependency>
			<groupId>com.microsoft.azure</groupId>
			<artifactId>applicationinsights-logging-log4j1_2</artifactId>
			<version>2.6.4</version>
		</dependency>

		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-core</artifactId>
			<version>${log4j.version}</version>
		</dependency>
````
4) Add APPLICATIONINSIGHTS_CONNECTION_STRING=The connection string and not the instrumentation key in the environment variables 
5) If using IDE make sure you close and start the IDE every time after changing the environment properties 
6) add appender to c:\Users\ShrinivasKamalapur\OneDrive - log4j2.xml
  ````
<appender name="aiAppender" type="Microsoft.ApplicationInsights.Log4NetAppender.ApplicationInsightsAppender, Microsoft.ApplicationInsights.Log4NetAppender">
    <layout type="log4net.Layout.PatternLayout">
        <conversionPattern value="%message%newline" />
    </layout>

   <Loggers>
        <!-- avoid duplicated logs with additivity=false -->
        <Logger name="com.mkyong" level="debug" additivity="false">
            <AppenderRef ref="LogToRollingRandomAccessFile"/>
            <AppenderRef ref="LogToConsole"/>
              <AppenderRef ref="aiAppender"/>
        </Logger>
        <Root level="error">
            <AppenderRef ref="LogToConsole"/>
              <AppenderRef ref="aiAppender"/>
        </Root>
    </Loggers>
Links
https://social.msdn.microsoft.com/Forums/en-US/11acf7f3-563a-4541-b0e3-d81498ed30fb/unable-to-post-log4j2-trace-logs-to-application-insights-using-applicationinsightslogginglog4j2?forum=ApplicationInsights

https://stackoverflow.com/questions/60361760/application-insights-logging-with-log4js-in-java
https://stackoverflow.com/questions/60361760/application-insights-logging-with-log4js-in-java
https://stackoverflow.com/questions/60361760/application-insights-logging-with-log4js-in-java
mkyong/java-logging
https://github.com/mkyong/java-logging/tree/master
https://mkyong.com/spring-boot/spring-boot-log4j-2-example/

````






Logs - 

2023-08-20 07:14:15,666 main DEBUG Apache Log4j Core 2.11.2 initializing configuration XmlConfiguration[location=C:\Users\ShrinivasKamalapur\OneDrive - kyndryl\Documents\POCSource\java-logging-master\java-logging-master\log4j2\target\classes\log4j2.xml]
2023-08-20 07:14:15,681 main DEBUG Installed 1 script engine
2023-08-20 07:14:16,378 main DEBUG Oracle Nashorn version: 1.8.0_331, language: ECMAScript, threading: Not Thread Safe, compile: true, names: [nashorn, Nashorn, js, JS, JavaScript, javascript, ECMAScript, ecmascript], factory class: jdk.nashorn.api.scripting.NashornScriptEngineFactory
2023-08-20 07:14:16,379 main DEBUG PluginManager 'Core' found 117 plugins
2023-08-20 07:14:16,380 main DEBUG PluginManager 'Level' found 0 plugins
2023-08-20 07:14:16,389 main DEBUG PluginManager 'Lookup' found 13 plugins
2023-08-20 07:14:16,391 main DEBUG Building Plugin[name=layout, class=org.apache.logging.log4j.core.layout.PatternLayout].
2023-08-20 07:14:16,419 main DEBUG PluginManager 'TypeConverter' found 26 plugins
2023-08-20 07:14:16,449 main DEBUG PatternLayout$Builder(pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n", PatternSelector=null, Configuration(C:\Users\ShrinivasKamalapur\OneDrive - kyndryl\Documents\POCSource\java-logging-master\java-logging-master\log4j2\target\classes\log4j2.xml), Replace=null, charset="null", alwaysWriteExceptions="null", disableAnsi="null", noConsoleNoAnsi="null", header="null", footer="null")
2023-08-20 07:14:16,449 main DEBUG PluginManager 'Converter' found 44 plugins
2023-08-20 07:14:16,451 main DEBUG Building Plugin[name=appender, class=org.apache.logging.log4j.core.appender.ConsoleAppender].
2023-08-20 07:14:16,466 main DEBUG ConsoleAppender$Builder(target="SYSTEM_OUT", follow="null", direct="null", bufferedIo="null", bufferSize="null", immediateFlush="null", ignoreExceptions="null", PatternLayout(%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n), name="LogToConsole", Configuration(C:\Users\ShrinivasKamalapur\OneDrive - kyndryl\Documents\POCSource\java-logging-master\java-logging-master\log4j2\target\classes\log4j2.xml), Filter=null, ={})
2023-08-20 07:14:16,469 main DEBUG Starting OutputStreamManager SYSTEM_OUT.false.false
2023-08-20 07:14:16,469 main DEBUG Building Plugin[name=layout, class=org.apache.logging.log4j.core.layout.PatternLayout].
2023-08-20 07:14:16,471 main DEBUG PatternLayout$Builder(pattern="%d %p %c{1.} [%t] %m%n", PatternSelector=null, Configuration(C:\Users\ShrinivasKamalapur\OneDrive - kyndryl\Documents\POCSource\java-logging-master\java-logging-master\log4j2\target\classes\log4j2.xml), Replace=null, charset="null", alwaysWriteExceptions="null", disableAnsi="null", noConsoleNoAnsi="null", header="null", footer="null")
2023-08-20 07:14:16,495 main DEBUG Building Plugin[name=TimeBasedTriggeringPolicy, class=org.apache.logging.log4j.core.appender.rolling.TimeBasedTriggeringPolicy].
2023-08-20 07:14:16,500 main DEBUG TimeBasedTriggeringPolicy$Builder(interval="null", modulate="null", maxRandomDelay="null")
2023-08-20 07:14:16,501 main DEBUG Building Plugin[name=SizeBasedTriggeringPolicy, class=org.apache.logging.log4j.core.appender.rolling.SizeBasedTriggeringPolicy].
2023-08-20 07:14:16,510 main DEBUG createPolicy(size="1 MB")
2023-08-20 07:14:16,512 main DEBUG Building Plugin[name=Policies, class=org.apache.logging.log4j.core.appender.rolling.CompositeTriggeringPolicy].
2023-08-20 07:14:16,513 main DEBUG createPolicy(={TimeBasedTriggeringPolicy(nextRolloverMillis=0, interval=1, modulate=false), SizeBasedTriggeringPolicy(size=1048576)})
2023-08-20 07:14:16,514 main DEBUG Building Plugin[name=DefaultRolloverStrategy, class=org.apache.logging.log4j.core.appender.rolling.DefaultRolloverStrategy].
2023-08-20 07:14:16,519 main DEBUG DefaultRolloverStrategy$Builder(max="10", min="null", fileIndex="null", compressionLevel="null", ={}, stopCustomActionsOnError="null", tempCompressedFilePattern="null", Configuration(C:\Users\ShrinivasKamalapur\OneDrive - kyndryl\Documents\POCSource\java-logging-master\java-logging-master\log4j2\target\classes\log4j2.xml))
2023-08-20 07:14:16,521 main DEBUG Building Plugin[name=appender, class=org.apache.logging.log4j.core.appender.RollingRandomAccessFileAppender].
2023-08-20 07:14:16,526 main DEBUG RollingRandomAccessFileAppender$Builder(fileName="logs/app.log", filePattern="logs/${date:yyyy-MM}/app-%d{MM-dd-yyyy}-%i.log.gz", append="null", Policies(CompositeTriggeringPolicy(policies=[TimeBasedTriggeringPolicy(nextRolloverMillis=0, interval=1, modulate=false), SizeBasedTriggeringPolicy(size=1048576)])), DefaultRolloverStrategy(DefaultRolloverStrategy(min=1, max=10, useMax=true)), advertise="null", advertiseURI="null", filePermissions="null", fileOwner="null", fileGroup="null", bufferedIo="null", bufferSize="null", immediateFlush="null", ignoreExceptions="null", PatternLayout(%d %p %c{1.} [%t] %m%n), name="LogToRollingRandomAccessFile", Configuration(C:\Users\ShrinivasKamalapur\OneDrive - kyndryl\Documents\POCSource\java-logging-master\java-logging-master\log4j2\target\classes\log4j2.xml), Filter=null, ={})
2023-08-20 07:14:16,540 main DEBUG Starting RollingRandomAccessFileManager logs/app.log
2023-08-20 07:14:16,547 main DEBUG PluginManager 'FileConverter' found 2 plugins
2023-08-20 07:14:16,550 main DEBUG Setting prev file time to 2023-08-20T07:11:44.796+0530
2023-08-20 07:14:16,553 main DEBUG Initializing triggering policy CompositeTriggeringPolicy(policies=[TimeBasedTriggeringPolicy(nextRolloverMillis=0, interval=1, modulate=false), SizeBasedTriggeringPolicy(size=1048576)])
2023-08-20 07:14:16,554 main DEBUG Initializing triggering policy TimeBasedTriggeringPolicy(nextRolloverMillis=0, interval=1, modulate=false)
2023-08-20 07:14:16,555 main DEBUG Initializing triggering policy SizeBasedTriggeringPolicy(size=1048576)
2023-08-20 07:14:16,555 main DEBUG Building Plugin[name=appenders, class=org.apache.logging.log4j.core.config.AppendersPlugin].
2023-08-20 07:14:16,555 main ERROR Appenders contains an invalid element or attribute "appender"
2023-08-20 07:14:16,556 main DEBUG createAppenders(={LogToConsole, LogToRollingRandomAccessFile})
2023-08-20 07:14:16,556 main DEBUG Building Plugin[name=AppenderRef, class=org.apache.logging.log4j.core.config.AppenderRef].
2023-08-20 07:14:16,558 main DEBUG createAppenderRef(ref="LogToRollingRandomAccessFile", level="null", Filter=null)
2023-08-20 07:14:16,558 main DEBUG Building Plugin[name=AppenderRef, class=org.apache.logging.log4j.core.config.AppenderRef].
2023-08-20 07:14:16,559 main DEBUG createAppenderRef(ref="LogToConsole", level="null", Filter=null)
2023-08-20 07:14:16,559 main DEBUG Building Plugin[name=AppenderRef, class=org.apache.logging.log4j.core.config.AppenderRef].
2023-08-20 07:14:16,562 main DEBUG createAppenderRef(ref="aiAppender", level="null", Filter=null)
2023-08-20 07:14:16,563 main DEBUG Building Plugin[name=logger, class=org.apache.logging.log4j.core.config.LoggerConfig].
2023-08-20 07:14:16,566 main DEBUG createLogger(additivity="false", level="DEBUG", name="com.mkyong", includeLocation="null", ={LogToRollingRandomAccessFile, LogToConsole, aiAppender}, ={}, Configuration(C:\Users\ShrinivasKamalapur\OneDrive - kyndryl\Documents\POCSource\java-logging-master\java-logging-master\log4j2\target\classes\log4j2.xml), Filter=null)
2023-08-20 07:14:16,572 main DEBUG Building Plugin[name=AppenderRef, class=org.apache.logging.log4j.core.config.AppenderRef].
2023-08-20 07:14:16,573 main DEBUG createAppenderRef(ref="LogToConsole", level="null", Filter=null)
2023-08-20 07:14:16,574 main DEBUG Building Plugin[name=AppenderRef, class=org.apache.logging.log4j.core.config.AppenderRef].
2023-08-20 07:14:16,575 main DEBUG createAppenderRef(ref="aiAppender", level="null", Filter=null)
2023-08-20 07:14:16,575 main DEBUG Building Plugin[name=root, class=org.apache.logging.log4j.core.config.LoggerConfig$RootLogger].
2023-08-20 07:14:16,576 main DEBUG createLogger(additivity="null", level="ERROR", includeLocation="null", ={LogToConsole, aiAppender}, ={}, Configuration(C:\Users\ShrinivasKamalapur\OneDrive - kyndryl\Documents\POCSource\java-logging-master\java-logging-master\log4j2\target\classes\log4j2.xml), Filter=null)
2023-08-20 07:14:16,577 main DEBUG Building Plugin[name=loggers, class=org.apache.logging.log4j.core.config.LoggersPlugin].
2023-08-20 07:14:16,578 main DEBUG createLoggers(={com.mkyong, root})
2023-08-20 07:14:16,580 main ERROR Unable to locate appender "aiAppender" for logger config "root"
2023-08-20 07:14:16,580 main ERROR Unable to locate appender "aiAppender" for logger config "com.mkyong"
2023-08-20 07:14:16,581 main DEBUG Configuration XmlConfiguration[location=C:\Users\ShrinivasKamalapur\OneDrive - kyndryl\Documents\POCSource\java-logging-master\java-logging-master\log4j2\target\classes\log4j2.xml] initialized
2023-08-20 07:14:16,582 main DEBUG Starting configuration XmlConfiguration[location=C:\Users\ShrinivasKamalapur\OneDrive - kyndryl\Documents\POCSource\java-logging-master\java-logging-master\log4j2\target\classes\log4j2.xml]
2023-08-20 07:14:16,582 main DEBUG Started configuration XmlConfiguration[location=C:\Users\ShrinivasKamalapur\OneDrive - kyndryl\Documents\POCSource\java-logging-master\java-logging-master\log4j2\target\classes\log4j2.xml] OK.
2023-08-20 07:14:16,583 main DEBUG Shutting down OutputStreamManager SYSTEM_OUT.false.false-1
2023-08-20 07:14:16,584 main DEBUG Shut down OutputStreamManager SYSTEM_OUT.false.false-1, all resources released: true
2023-08-20 07:14:16,584 main DEBUG Appender DefaultConsole-1 stopped with status true
2023-08-20 07:14:16,585 main DEBUG Stopped org.apache.logging.log4j.core.config.DefaultConfiguration@66cd51c3 OK
2023-08-20 07:14:16,652 main DEBUG Registering MBean org.apache.logging.log4j2:type=73d16e93
2023-08-20 07:14:16,656 main DEBUG Registering MBean org.apache.logging.log4j2:type=73d16e93,component=StatusLogger
2023-08-20 07:14:16,657 main DEBUG Registering MBean org.apache.logging.log4j2:type=73d16e93,component=ContextSelector
2023-08-20 07:14:16,659 main DEBUG Registering MBean org.apache.logging.log4j2:type=73d16e93,component=Loggers,name=
2023-08-20 07:14:16,660 main DEBUG Registering MBean org.apache.logging.log4j2:type=73d16e93,component=Loggers,name=com.mkyong
2023-08-20 07:14:16,660 main DEBUG Registering MBean org.apache.logging.log4j2:type=73d16e93,component=Appenders,name=LogToRollingRandomAccessFile
2023-08-20 07:14:16,661 main DEBUG Registering MBean org.apache.logging.log4j2:type=73d16e93,component=Appenders,name=LogToConsole
2023-08-20 07:14:16,664 main DEBUG org.apache.logging.log4j.core.util.SystemClock does not support precise timestamps.
2023-08-20 07:14:16,664 main DEBUG Reconfiguration complete for context[name=73d16e93] at URI C:\Users\ShrinivasKamalapur\OneDrive - kyndryl\Documents\POCSource\java-logging-master\java-logging-master\log4j2\target\classes\log4j2.xml (org.apache.logging.log4j.core.LoggerContext@7dcf94f8) with optional ClassLoader: null
2023-08-20 07:14:16,665 main DEBUG Shutdown hook enabled. Registering a new one.
2023-08-20 07:14:16,666 main DEBUG LoggerContext[name=73d16e93, org.apache.logging.log4j.core.LoggerContext@7dcf94f8] started OK.
2023-08-20 07:14:24.628+05:30 INFO  c.m.applicationinsights.agent - Application Insights Java Agent 3.4.15 started successfully (PID 37196, JVM running for 9.924 s)
2023-08-20 07:14:24.721+05:30 INFO  c.m.applicationinsights.agent - Java version: 1.8.0_331, vendor: Oracle Corporation, home: C:\Program Files\Java\jdk1.8.0_331\jre
07:14:25.032 [main] DEBUG com.mkyong.HelloWorld - without appinsightsjson Hello from Log4j 2 MS ARS 123 
