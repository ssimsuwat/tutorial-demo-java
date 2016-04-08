@echo off
SET DIR=%~d0%~p0%

SET connstring="data source=TUTORIAL\TUTORIAL;initial catalog=Northwind;integrated security=True"
SET repository.path="https://github.com/espiderinc/tutorial-demo-java.git"

"D:\workspace\screencast\download\RoundhousE\console\rh.exe" /c=%connstring% /r=%repository.path% /env=LOCAL /ni /simple