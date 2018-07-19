Feature: Site Details Feature
  Verify if all pages have proper titles

  Scenario: Test home page has  title
    Given user is  on homepage
    Then user should see page title as "LOFT: Women's Clothing, Petites, Dresses, Pants, Shirts, Sweaters"
  Scenario: Test category page has  title
    Given user is  on petites category page
    Then user should see page title as "New Arrivals: Petite Clothing | LOFT"
  Scenario: Test login page has  title
    Given user is  on loginpage
    Then user should see page title as "Login | LOFT"
  Scenario: Test stores page has title
    Given user is  on store page
    Then user should see page title as "Stores | LOFT"

