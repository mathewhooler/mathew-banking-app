import Balance as Balance

data class Bank(val accounts: MutableList<Account>) {

  fun deposit(customerName: String, customerId: Int, amount: Double) {
    val account = accounts.find { it.customer.name == customerName && it.customer.id == customerId }
    if (account == null) {
      throw Exception("Account not found")
    }
    if (amount <= 0) {
      throw IllegalArgumentException("Deposit amount must be greater than zero")
    }
    account.balance = Balance(account.balance.amount + amount)

  }

  fun withdraw(customerName: String, customerId: Int, amount: Double) {
    val account = accounts.find { it.customer.name == customerName && it.customer.id == customerId }
    if (account == null) {
      throw Exception("Account not found")
    }
    if (amount <= 0) {
      throw IllegalArgumentException("Withdrawal amount must be greater than zero")
    }
    if (amount > account.balance) {
      throw IllegalArgumentException("Insufficient funds in account")
    }
    account.balance = Balance(account.balance.amount - amount)

  }

  fun checkBalance(customerId: Int): Balance {
    val account = accounts.find { it.customer.id == customerId }
    if (account == null) {
      throw Exception("Account not found")
    }
    return account.balance
  }
}

// private operator fun Any.compareTo(balance: Balance): Int {
// return 0
// }
