class Bank(val accounts: MutableMap<Int, Account>) {

  fun deposit(customerId: Int, amount: Int) {
    val account = accounts[customerId] ?: throw Exception("Account not found")
    if (amount <= 0) {
      throw IllegalArgumentException("Deposit amount must be greater than zero")
    }
    account.balance += amount

  }

  fun withdraw(customerId: Int, amount: Int) {
    val account = accounts[customerId] ?: throw Exception("Account not found")
    if (amount <= 0) {
      throw IllegalArgumentException("Withdrawal amount must be greater than zero")
    }
    if (amount > account.balance) {
      throw IllegalArgumentException("Insufficient funds in account")
    }
    account.balance -= amount

  }

  fun checkAccountBalance(customerId: Int): Int {
    val account = accounts[customerId] ?: throw Exception("Account not found")
    return account.balance
  }

  fun checkBankBalance(): Int {
    return accounts.values.sumOf { it.balance }
  }
}

