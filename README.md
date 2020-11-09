# Let's Deel
QA Automation Exam

There are 4 test cases in this app:
1) Sanity with hard coded details.
2) Sanity with outsourced details that are in an outsourced file.
3) Negative test with mismatch passwords that are in an outsourced file.
4) Negative test with invalid email that is in an outsourced file.

All the tests are located in the same class - SignUpTest.java.

Before each step in the test the code will take a screenshot.
Screenshots will be stored in the Screenshots folder.
Incase of a failure, the code will also take a screenshot.

Outsourced Excel file can be found in the TestData folder, under Data.xlsx.

After the tests are done, the code will generate a report with the results.
The Extent Report is located in the test-output folder, under myReport.html.

Please notice that this is a Maven project & TestNG Framework,
All the dependencies can be found at pom.xml.

Thank you!
