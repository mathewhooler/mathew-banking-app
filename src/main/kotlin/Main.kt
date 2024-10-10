fun main() {
  val c1 = Customer("Mathew", 111)
  val c2 = Customer("Steven", 222)
  val c3 = Customer("Lissy", 333)
  val c4 = Customer("Mark", 444)

  val accounts = mutableMapOf(
    c1.customerId to Account(c1, 0),
    c2.customerId to Account(c2, 0),
    c3.customerId to Account(c3, 0),
    c4.customerId to Account(c4, 0)
  )

  val bank = Bank(accounts)

  bank.deposit(111, 2000)
  bank.deposit(222, 3000)
  bank.deposit(333, 5200)
  bank.deposit(444, 1200)
  bank.deposit(111, 2000)

  bank.withdraw(111, 2500)
  bank.withdraw(333, 2500)

  val balance1 = bank.checkBalance(111)
  val balance2 = bank.checkBalance(333)

  println("Balance of account 1: $balance1")
  println("Balance of account 3: $balance2")
}