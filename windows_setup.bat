@ECHO OFF
cd %cd%
SET /p ask=Is JAVA SDK installed? Did you set Java SDK Enviroments? (Y/n)
if %ask%==n goto No
if %ask%==N goto No
SET /p ask2=Is MAVEN installed? Did you set Maven Enviroments? (Y/n)
if %ask2%==n goto No
if %ask2%==N goto No
ECHO "Packages compiling..."
mvn clean compile package install
ECHO "Packages compiled...Finished"
pause

:No
cls
echo.
echo Okay, let's exit...
echo.
set /p pause="Press any key to continue!... "
exit
