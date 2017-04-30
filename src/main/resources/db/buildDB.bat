@echo off
SET DIR=%~d0%~p0%

SET connstring="Server=1YC0SF2;Database=Northwind;Integrated Security=true"
SET repository.path="https://github.com/ssimsuwat/tutorial-demo-java.git"
SET version.file="..\..\..\..\pom.xml"
SET version.xpath="//project/version"

"C:\RoundhousE.v0.8.6.0\RoundhousE\console\rh.exe" /vf=%version.file% /vx=%version.xpath% /c=%connstring% /r=%repository.path% /env=LOCAL /ni /simple