@echo off
echo.
call ant -buildfile Build-OneCycle.xml setClassPath Generate-Report
echo.
call ant -buildfile Build-Re_assign.xml setClassPath Generate-Report
echo.
start "" "E:\BankerChat\Workspace\BankerChatWithATUReporter-new\ATU Reporter\index.html"
pause