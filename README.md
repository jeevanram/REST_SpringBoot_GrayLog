# Spring Boot REST application with Logging Framework

## REST_SpringBoot_GrayLog
        > Set up Graylog with Log4J/Log4J2 SpringBoot application 

## DataSource 
        > ORACLE
                spring.datasource.url = jdbc:postgresql://localhost:5432/postgres
                spring.datasource.username = postgres
                spring.datasource.password = welcome123
                spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
                
        > POSTGRESQL
                spring.datasource.url= jdbc:oracle:thin:@//hostname:1521/database
                spring.datasource.username=username
                spring.datasource.password=password
                spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
                spring.jpa.database-platform=org.hibernate.dialect.Oracle10gDialect

## To SET up Graylog SERVER
        > http://docs.graylog.org/en/2.2/pages/installation.html
        
        > LOG4J properties
                > Define the logfile destination and format of our logging
                        log4j.appender.logfile=org.apache.log4j.DailyRollingFileAppender
                        log4j.appender.logfile.File=./logs/logfile.log
                        log4j.appender.logfile.layout=org.apache.log4j.PatternLayout
                        log4j.appender.logfile.layout.ConversionPattern=%d{HH:mm:ss,SSS} %-5p [%t] [%c{1}] - %m%n

                > Define the graylog2 destination
                        log4j.appender.graylog2=org.graylog2.log.GelfAppender
                        log4j.appender.graylog2.graylogHost=IP
                        log4j.appender.graylog2.originHost=IP
                        log4j.appender.graylog2.layout=org.apache.log4j.PatternLayout
                        log4j.appender.graylog2.additionalFields={'environment': 'DEV', 'application': 'DemoAPP'}
                        log4j.appender.graylog2.extractStacktrace=true
                        log4j.appender.graylog2.addExtendedInformation=true

                > Send all INFO,WARN,ERROR logs to logfile
                        log4j.rootLogger=ERROR,logfile

                > Also send com.example INFO logs to graylog
                        log4j.category.com.example=INFO,graylog2
                        log4j.additivity.com.example=true
                        
        > log4j2.xml example

            <?xml version="1.0" encoding="UTF-8"?>
            <Configuration status="OFF" packages="org.graylog2.log4j2">
                <Appenders>
                    <GELF name="gelfAppender" server="graylog2.example.com" port="12201" hostName="appserver01.example.com">
                        <PatternLayout pattern="%logger{36} - %msg%n"/>
                        <Filters>
                            <Filter type="MarkerFilter" marker="FLOW" onMatch="DENY" onMismatch="NEUTRAL"/>
                            <Filter type="MarkerFilter" marker="EXCEPTION" onMatch="DENY" onMismatch="ACCEPT"/>
                        </Filters>
                        <!-- Additional fields -->
                        <KeyValuePair key="foo" value="bar"/>
                        <KeyValuePair key="jvm" value="${java:vm}"/>                
                    </GELF>
                </Appenders>
                <Loggers>
                    <Root level="info">
                        <AppenderRef ref="gelfAppender"/>
                    </Root>
                </Loggers>
            </Configuration>

## Reference 
        > For GELF with Log4J  : https://github.com/pstehlik/gelf4j
        > For GELF with Log4J2 : https://github.com/graylog-labs/log4j2-gelf

