import org.junit.jupiter.api.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals

class BankTest {
  @Test
  fun `bank supports multiple accounts`() {
    val customer1 = Customer("Terry", 111)
    val customer2 = Customer("Susan", 222)

    val account1 = Account(customer1, 0)
    val account2 = Account(customer2, 0)

    val accountsMap = mutableMapOf(
      customer1.customerId to account1,
      customer2.customerId to account2
    )

    val bank = Bank(accountsMap)

    assertEquals(2, bank.accounts.size)
    assertContains(bank.accounts.values, account1)
    assertContains(bank.accounts.values, account2)
  }

  @Test
  fun `bank can make deposits`() {
    val customer1 = Customer("John", 1)
    val account1 = Account(customer1, 0)

    val bank = Bank(mutableMapOf(customer1.customerId to account1))

    bank.deposit(1, 1000)

    assertEquals(1000, account1.balance)
  }

  @Test
  fun `bank can make withdrawals`() {
    val customer1 = Customer("John", 1)
    val account1 = Account(customer1, 500)

    val bank = Bank(mutableMapOf(customer1.customerId to account1))

    bank.withdraw(1, 300)

    assertEquals(200, account1.balance)
  }
}
