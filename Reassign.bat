@echo off
echo.
call ant -buildfile "E:\BankerChat\Workspace\BankerChatWithATUReporter-new\Reassign.xml" setClassPath Generate-Report
echo.
start "" "E:\BankerChat\Workspace\BankerChatWithATUReporter-new\ATU Reporter\index.html"
pause