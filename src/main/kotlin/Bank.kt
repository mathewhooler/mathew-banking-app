data class City(val name: String)

data class Customer(val name: String, val id: Int, val city: City)

data class Account(val customer: List<Account>, Customer, var balance: Double = 0.0)

data class Balance(val value: Double)

data class Bank(val name: String, val accounts: MutableList<Account>) {
  fun deposit(customerName: String, customerId: Int, amount: Double): Unit {
    val account = accounts.find { it.customer.name == customerName && it.customer.id == customerId }
    if (account == null) {
      throw Exception("Account not found")
    } else {
      if (amount <= 0) {
        throw IllegalArgumentException("Deposit amount must be greater than zero")
      }
      account.balance += amount
      println("$customerName (ID: $customerId) deposited $$amount. New balance is ${account.balance}")
    }
  }

  fun withdraw(customerName: String, customerId: Int, amount: Double): Balance {
    val account = accounts.find { it.customer.name == customerName && it.customer.id == customerId }
    if (account == null) {
      throw Exception("Account not found")
    } else {
      if (amount > account.balance)
        throw IllegalArgumentException("Insufficient funds in account")
    }
    account.balance -= amount
    println("$customerName (ID: $customerId) withdrew $$amount. New balance is ${account.balance}")

    return Balance(account.balance)
    }

  fun checkBalance(customerId: Int): Double {
    val account = accounts.find { it.customer.id == customerId }
    if (account == null) {
      throw Exception("Account not found")
    } else {
      println("Account balance for ${account.customer.name} (ID: $customerId) is ${account.balance}")
    }

    return account.balance
  }

}

  fun main() {
    val melbourne = City("Melbourne")
    val sydney = City("Sydney")
    val brisbane = City("Brisbane")

    val c1 = Customer("Mathew", 1, melbourne)
    val c2 = Customer("Steven", 2, sydney)
    val c3 = Customer("Mathew", 3, brisbane)
    val c4 = Customer("Mark", 4, melbourne)

    val bank = Bank(
      "CashApp", mutableListOf(
        Account(c1),
        Account(c2),
        Account(c3),
        Account(c4)
      )
    )

    bank.deposit("Mathew", 1, 2000.0)
    bank.deposit("Steven", 2, 3000.0)
    bank.deposit("Mathew", 3, 5200.0)
    bank.deposit("Mark", 4, 1200.0)
    bank.deposit("Mathew", 1, 2000.0)


    bank.withdraw("Mathew", 1, 2500.0)
    bank.withdraw("Mathew", 3, 2500.0)

    bank.checkBalance(1)

  }