ECHO ON

CALL color b9
CALL Powershell.exe -executionpolicy remotesigned -File  allure-results-folder-deletion.ps1
CALL mvn clean verify -P grid -Dbrowser=CHROME -Dremote=true -Dmaven.clean.failOnError=false
CALL mvn allure:report -Dbrowser=CHROME
PAUSE