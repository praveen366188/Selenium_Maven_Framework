Feature: login to the Naukri application and Edit and update
  Here we are logging in to the naukri website and editing some field and updating
@Test
  Scenario Outline:
    Given Launching the browser and navigate to the Naukri website
    Then Enter "<username>" in the username field
    And Enter "<password>" in the password field
    And Click login button
    Then We verifying the home page of the naukri profile "<titleName>"
    Then We are updating the Resume Headline and verify
    Then We Logout from the naukri application
    Examples:
      | username                | password   |titleName|
      | praveen366188@gmail.com | password@1 | Praveenkumar Sannasi Elangovan |
