Feature: Make operations on account
 Scenario: A client wants to make a deposit
		Given A bank client "jane" "doe"
		And A bank account with 50.0
		When A client deposits 300.0
		Then The account balance should be at 350.0
		
  Scenario: A client wants to retrieve some of his savings
		Given A bank client "jane" "doe"
		And A bank account with 50.0
		When A client withraws 40.0
		Then The account balance should be at 10.0
		
 Scenario: A client wants to retrieve more than his savings
		Given A bank client "jane" "doe"
		And A bank account with 50.0
		When A client withraws 400.0
		Then It should throw NO_SUFFICIENT_CREDIT exception

 Scenario: A client wants to see the history
		Given A bank client "jane" "doe"
		And A bank account with 800.0
		When A client withraws 400.0
		When A client deposits 300.0
		Then A client should see his operations and contains "DEPOSIT" and "WITHDRAWL"

	