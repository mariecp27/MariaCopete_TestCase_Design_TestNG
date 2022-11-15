# Final Exam Web Module

Create a single test for the following steps:

A. **Doing Login**
  1. Go to https://www.espnqa.com/?src=com&_adblock=true&espn=cloud
  2. Click ‘Log in’ element - Validate a modal is present and contains:
    
    a. ‘ESPN’ Logo
    b. ‘Log In’ button
    c. ‘Sign Up’ button
    
  3. Once logged in, go to 'Watch' and validate that at least one carousel is present:
  
    a. Each card in the carousel has a title and a small description about streaming source
    
  4. Click on the second card in the first carousel and validate
  
    a. 'X' button to close is present
    
  5. Click 'X' button to close
  6. Go back to the landing page
  7. Perform mouse hover the ‘User Icon’ element located at the top right corner of the view:
  
    a. Validate the element 'Nav text' has the right information previously entered in the sign up modal: 'Welcome {{username}}!'
    
  8. Click 'Log Out' element and validate:
  
    a. The user has logged out successfully i.e. Validate the element 'Nav text' has text: 'Welcome!' without user name specified
    
B. **Doing Logout**
  1. Once logged in, create the flow to log out from current session
  2. Validate session is log out from user panel
  
C. **Deactivate Account**
  1. Once Logged in create the flow to deactivate account (is mandatory to explore the page to understand the flow)
  2. Validate the check green action when the account is deactivated
  3. Try to log in again with the same account to get message from page, validate it

***Remember:***
- You should improve your code compared to the past exercise applied to ESPN web application. Include the best practices topics given.
- Avoid using implicit waits, they end up creating idle times in the test executions.
- Be sure to use Page Object Pattern, Assertions (you decide how to validate each of the flows), and Parameters.
- Use Assertions to assert test steps Example: When I finish the Log Out account, I will assert the “account was canceled” message appears.
- Remember the difference between when to use Parameters and Data Providers. For example, you can use Parameters to set the URL of the webpage you’ll be testing.
