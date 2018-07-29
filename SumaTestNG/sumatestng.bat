set projectlocation=C:\Users\Pradeep\git\automation\SumaTestNG
cd %projectlocation%
set classpath=%projectlocation%\bin;%projectlocation%\lib\*
java org.testng.TestNG %projectlocation%\testng.xml
pause