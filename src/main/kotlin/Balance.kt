data class Balance(val amount: Double) : Comparable<Balance> {
  override fun compareTo(other: Balance): Int {
    return amount.compareTo(other.amount)
  }
}

