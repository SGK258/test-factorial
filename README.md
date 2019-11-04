Test Cases # test-factorial

Feature : Verify Factorial Page title

Given :  You are on Factorial Home Page
When:  You do nothing
Then:  Verify the Title equals "Factorial"


Feature: Verify Factorial Page contents

Given:  You are on Factorial page
When:  You do nothing
Then:  Verify page contents - Input field, Submit button, Terms link, Privacy link, Copyright



Feature:  Verify factorial for boundary / out of boundary inputs

Given: You are on Factorial Page
And: Entered any integer between < 0 and  >170
When: Click the submit button
Then: Verify the error msg - Please enter an integer


Feature:  Verify factorial Successful for any  0 - 170  integer

Given: You are on Factorial Page
And: Enter any integer between 0 and 170
When: Click the submit button
Then: Verify the result is displayed - The factorial of #num is #result


Feature:  Verify factorial Successful for 0 - 10  integer ( functional test)

Given: You are on Factorial Page
And: Enter integer between 0 and 10
When: Click the submit button
Then: Verify the result is displayed is equal to the expected value.


Feature: Terms and Conditions Link

Given : You are on Factorial page
When: Click on the terms and conditions link
Then: Verify Terms and condition page displayed

Feature: Privacy Link

Given : You are on Factorial page
When: Click on the terms and conditions link
Then: Verify Terms and condition page displayed

Feature: Copyright Link

Given : You are on Factorial page
When: Click on the Copyright link
Then: Verify Copyright page is displayed


Feature: UI - Resolution, Window resize

Given; You have factorial application open in a window
When: change the resolution or window size
Then: verify application has no UI issues.
