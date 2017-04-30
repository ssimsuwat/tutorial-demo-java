@echo off
SET DIR=%~d0%~p0%

SET connstring="data source=TUTORIAL\TUTORIAL;initial catalog=Northwind;user=sa;password=Yukon900"
SET repository.path="https://github.com/ssimsuwat/tutorial-demo-java.git"
SET version.file="..\..\..\..\pom.xml"
SET version.xpath="//project/version"

"C:\RoundhousE.v0.8.6.0\RoundhousE\console\rh.exe" /vf=%version.file% /vx=%version.xpath% /c=%connstring% /r=%repository.path% /env=LOCAL /ni /simple