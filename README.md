1) Only Warn and ERROR are sent to application insight by default
2) Should include these libraries in the pom file 
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


3) Add APPLICATIONINSIGHTS_CONNECTION_STRING=The connection string and not the instrumentation key in the environment variables 
4) If using IDE make sure you close and start the IDE every time after changing the environment properties 
5) add appender to c:\Users\ShrinivasKamalapur\OneDrive - log4j2.xml
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
