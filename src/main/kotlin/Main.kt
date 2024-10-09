fun main() {
  val c1 = Customer("Mathew", 1)
  val c2 = Customer("Steven", 2)
  val c3 = Customer("Mathew", 3)
  val c4 = Customer("Mark", 4)

  val bank = Bank(mutableListOf(
    Account(c1, 1, 0.0),
    Account(c2, 2, 0.0),
    Account(c3, 3, 0.0),
    Account(c4, 4, 0.0)
  ))

  bank.deposit("Mathew", 1, 2000.0)
  bank.deposit("Steven", 2, 3000.0)
  bank.deposit("Mathew", 3, 5200.0)
  bank.deposit("Mark", 4, 1200.0)
  bank.deposit("Mathew", 1, 2000.0)

  bank.withdraw("Mathew", 1, 2500.0)
  bank.withdraw("Mathew", 3, 2500.0)

  val balance1 = bank.checkBalance(1)
  val balance2 = bank.checkBalance(3)

  println("Balance of account 1: $balance1")
  println("Balance of account 3: $balance2")
}

