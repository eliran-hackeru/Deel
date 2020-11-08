# Deel
QA Automation Exam

There 3 test cases in this app:
1) Sanity with hard coded details.
2) Sanity with outsourced details (the details ar in an outsourced file).
3) Negative test with mismatch password that is in an outsourced file.

All the tests are located in the same class - SignUpTest.java.

Before each step in the test the code will take a screenshot.
Screenshots will be stored in the Screenshots folder.
Incase of a failure, the code will also take a screenshot.

Outsourced Excel file can be found in the TestData folder, under Data.xlsx.

After the tests are done, the code will generate a report with the results.
The Extent Report is located in the test-output folder, under myReport.html.

Please notice that this is a Maven project, all the dependencies can be found at pom.xml.
