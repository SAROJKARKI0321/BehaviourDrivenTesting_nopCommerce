Feature: User Registration

  Scenario Outline: Register new user with valid data
    Given I am on a registration page
    When I enter my firstname "<firstname>", lastname "<lastname>", email "<email>", password "<password>", confirmpassword "<confirmpassword>"
    And I click register
    Then I should see registration complete message

    Examples:
      | firstname | lastname | email                   | password  | confirmpassword |
      |  Trace   | Simpson   | trace@test.com  | Hello@456 | Hello@456       |
      | John      | Doe      | jon1.doe@example.com    | MyPass789 | MyPass789       |
      | Maya      | Lama     | mya1.lama@example.org   | Secure@1  | Secure@1        |
      | Amber      | Morgan   | amber1.g@testmail.com     | Pass!999  | Pass!999        |