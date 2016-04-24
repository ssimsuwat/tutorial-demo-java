@echo off
SET DIR=%~d0%~p0%

SET connstring="data source=TUTORIAL\TUTORIAL;initial catalog=Northwind;integrated security=True"
SET repository.path="https://github.com/espiderinc/tutorial-demo-java.git"
SET version.file="..\..\..\..\pom.xml"
SET version.xpath="/project/version"

"D:\workspace\screencast\download\RoundhousE\console\rh.exe" /vf=%version.file% /vx=%version.xpath% /c=%connstring% /r=%repository.path% /env=LOCAL /ni /simple