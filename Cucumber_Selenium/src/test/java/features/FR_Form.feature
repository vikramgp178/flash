Feature: FR Form functionality.

  Background: 
    Given : As a Client application URL available.
    When : User open the URL.

  @Sanity
  Scenario Outline: Verify the Title of the Page.
    Then : Title page should be "<title>".
    And : Close the browser.

    Examples: 
      | title                |
      | Remises & Réductions |

  @Regression
  Scenario Outline: Verify all validation message for all fields.
    Then : Fill The Form along with "<Card_Type>" and "<Card_Number>".
    And : Check error "<error1>" message for FirstName.
    And : Check error "<error2>" message for LastName.
    And : Check error "<error3>" message for Address line1.
    And : Check error "<error4>" message for Address line2.
    And : Check error "<error5>" message for Postal Code.
    And : Check error "<error6>" message for City.
    And : Check error "<error7>" message for Country.
    And : Check error "<error8>" message for email.
    And : Check error "<error9>" message for Password.
    And : Check error "<error10>" message for Card Type.
    And : Check error "<error11>" message for Card Number.
    And : Check error "<error12>" message for Month.
    And : Check error "<error13>" message for Year.
    And : Click on Submit button.
    And : Click on Submit button of SubForm.
    And : Check error "<error14>" message for Otp.
    And : Click on resend code button.
    And : Click on cancel button.
    And : Submit the Otp.
    And : Click on Cancel option.

    Examples: 
      | Card_Type  | Card_Number      | error1 | error2 | error3 | error4 | error5 | error6 | error7 | error8 | error9 | error10 | error11 | error12 | error13 | error14 |
      | MasterCard | 5505800383301944 | Prénom | b      | c      | d      | e      | f      | g      | h      | i      | j       | k       | l       | m       | n       |

  @Smoke
  Scenario Outline: Verify and fill up the form
    Then : Enter the FirstName.
    And : Enter the LastName
    And : Title page should be "<title1>".
    And : Enter the Address line1
    And : Enter the Address line2
    And : Enter the Postal Code.
    And : Enter the City.
    And : Select the Country
    And : Enter the email.
    And : Enter the Password.
    And : Select the Card Type "<Card_Type>".
    And : Enter the Card Number "<Card_Number>".
    And : Select the Month.
    And : Select the Year.
    And : Click on Submit button.
    And : Click on Submit button of SubForm.
    And : Enter the Otp.
    And : Click on resend code button.
    And : Click on cancel button.
    And : Submit the Otp.
    And : Click on Cancel option.
    And : Get the member info. from Acknowledgment page.
    And : Compare the Enroll Member data and Popup Member Data.
    And : Compare the Popup Member Data and Acknowledgment Page.

    Examples: 
      | Card_Type  | Card_Number      | title1               |
      | MasterCard | 5505800383301944 | Remises & Réductions |
