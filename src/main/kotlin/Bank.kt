class Bank(val accounts: MutableList<Account>) {

  fun deposit(customerId: Int, amount: Double) {
    val account = accounts.find { it.customer.name == customerName && it.customer.customerId == customerId }
    if (account == null) {
      throw Exception("Account not found")
    }
    if (amount <= 0) {
      throw IllegalArgumentException("Deposit amount must be greater than zero")
    }
    account.balance += amount

  }

  fun withdraw(customerId: Int, amount: Double) {
    val account = accounts.find { it.customer.name == customerName && it.customer.customerId == customerId }
    if (account == null) {
      throw Exception("Account not found")
    }
    if (amount <= 0) {
      throw IllegalArgumentException("Withdrawal amount must be greater than zero")
    }
    if (amount > account.balance) {
      throw IllegalArgumentException("Insufficient funds in account")
    }
    account.balance -= amount

  }

  fun checkBalance(customerId: Int): Double {
    val account = accounts.find { it.customer.customerId == customerId }
    if (account == null) {
      throw Exception("Account not found")
    }
    return account.balance
  }
}
