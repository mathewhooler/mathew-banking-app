import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertContains

class BankTestMultiAccounts {
  @Test
  fun `bank supports multiple accounts`() {
    val customer1 = Customer("Terry", 42)
    val customer2 = Customer("Susan", 37)

    val account1 = Account(customer1)
    val account2 = Account(customer2)

    val accounts = mutableListOf(account1, account2)

    val bank = Bank("Test Bank", accounts)

    assertEquals(2, bank.accounts.size)
    assertContains(bank.accounts, account1)
    assertContains(bank.accounts, account2)
  }
}

class BankTestDeposits {
  @Test
  fun `bank can make deposits`(){
    val customer1 = Customer("John", 1)
    val customer2 = Customer("Jason", 2)

    val account1 = Account(customer1)
    val account2 = Account(customer2)

    val accounts = mutableListOf(account1, account2)

    val bank = Bank("MatBank", accounts)


    bank.deposit("John", 1, 1000.0)

  }
}

class BankTestWithdrawals {
  @Test
  fun `bank can make withdrawals`(){
    val customer1 = Customer("John", 1)
    val customer2 = Customer("Jason", 2)

    val account1 = Account(customer1, 500.0)
    val account2 = Account(customer2, 600.0)

    val accounts = mutableListOf(account1, account2)

    val bank = Bank("MatBank", accounts)

    bank.withdraw("John", 1, 300.0)

  }
}

class BankTestCheckBalance {
  @Test
  fun `can check balance of customers account`() {
    val customer1 = Customer("Terry", 1)
    val customer2 = Customer("Susan", 2)

    val account1 = Account(customer1, 400.0)
    val account2 = Account(customer2)

    val accounts = listOf(account1, account2)

    val bank = Bank("Test Bank", MutableList<Account>)

    val balance = bank.checkBalance(1) // checking

    assertEquals(400.0, balance)
  }
}

// class BankTest5 {
//   @Test
//   fun `customer can have multiple accounts`() {
//     val customer1 = Customer("Terry", 1)
//     val customer2 = Customer("Susan", 2)
//
//     val account1 = Account(customer1)
//     val account2 = Account(customer1)
//
//
//     )
//   }

