ECHO ON

CALL color b9
CALL Powershell.exe -executionpolicy remotesigned -File  allure-results-folder-deletion.ps1
PAUSE
