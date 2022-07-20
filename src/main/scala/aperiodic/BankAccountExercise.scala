package aperiodic


import aperiodic.BankAccountExercise.Account
import aperiodic.ex1.{getLastElementOfList, lastRecursive}
import jdk.jfr.Timestamp

//import scala.collection.mutable.Set


/*
 Given an account defined as:

 Account
   balance (decimal number)
   name: (string)
   accountType (e.g. credit card, checking, savings)
   openedDate: (time stamp)

 for example
   balance: 1000.00
   name   : Chase Freedom
   accountType   : credit card
   opened Date: 6/19/2004

 Compare 2 sets of accounts for a user - one set from the current month, and one set from the prior month, e.g.:

 previous: [ { "balance":2000.0, "name":"Chase Freedom", "accountType":"credit_card", "openedDate":1111680799 }, { "balance":100.0, "name":"Citibank", "accountType":"credit_card", "openedDate":1000680799 } ]
 current:  [ { "balance":1000.0, "name":"Chase Freedom", "accountType":"credit_card", "openedDate":1111680799 }, { "balance":500.0, "name":"American Express", "accountType":"credit_card", "openedDate":v } ] what does v mean?

    * print out "<name>: <balance change>" for accounts that are in both months, e.g. "Chase Freedom: -1000"
    * print out "<name>: added" for those that are in the current month but not the previous month, e.g. "American Express: added"
    * print out "<name>: deleted" for those that are in the previous month but not the current month, e.g. "Citibank: deleted"
*/
// To execute Scala code, please define an object named Solution that extends App



object AccountType {
  sealed trait AccountType
  case object CreditCard extends AccountType
  case object Checking extends AccountType
  case object Savings extends AccountType
}

import AccountType._
object BankAccountExercise extends App {
  type AccountName = String

  case class Account(balance: BigDecimal, name: String, accountType: AccountType, openedDate: BigInt)

  val previousAccounts: Set[Account] = Set(
    Account(2000.0, "Chase Freedom", CreditCard, 1111680799),
    Account(100.0, "Citibank", CreditCard, 1000680799)
  )

  val currentAccounts: Set[Account] = Set(
    Account(500.0, "American Express", CreditCard, 1000680734),
    Account(1000.0, "Chase Freedom", CreditCard, 1111680799)
  )

  def accountsByNameAndType(accounts: Set[Account]): Map[String, Account] =
    accounts.groupBy(account => s"${account.name}-${account.accountType}").view.mapValues(_.head).toMap

  val previous: Map[String, Account] = accountsByNameAndType(previousAccounts)
  val current: Map[String, Account] = accountsByNameAndType(currentAccounts)

  val (elementsInBoth, elementsOnlyInPrevious) = previous.partition { case (accountName, _) => current.keys.toSeq.contains(accountName) }
  elementsInBoth.foreach {
    case (previousAccountName, previousAccount) =>
      current.get(previousAccountName).foreach(currentAccount => println(currentAccount.name + ": " + (previousAccount.balance - currentAccount.balance).toString()))
  }
  elementsOnlyInPrevious.foreach {
    case (accountName, _) => println(accountName + ": Deleted")
  }
   println(current.toSet)
  println(elementsOnlyInPrevious.toSet)
  (current.toSet diff elementsOnlyInPrevious.toSet).foreach { case (accountName, _) => println(accountName + ": Added") }


}






















//sealed trait AccountType
//  case object CreditCard extends AccountType
//  case object Checking extends AccountType
//  case object Savings extends AccountType
//
//
//object BankAccountExercise extends AccountType {
//
//  case class Account(balance: BigDecimal, name: String, accountType: AccountType, openedDate: Long)
//
//  val previousAccounts : Set[Account] =  Set(Account(2000.0, "Chase Freedom", CreditCard, 1111680799 ),
//                                               Account(100.0, "Citibank",  CreditCard, 1000680799 )
//                                              )
//
//  val  currentAccounts: Set[Account] = Set(Account( 500.0, "American Express",  CreditCard, 1000680734 ),
//                                            Account( 1000.0, "Chase Freedom", CreditCard, 1111680799 ),
//                                            Account( 1000.0, "Chase Freedom", Savings, 1111680799 )
//                                            )
//
//  def compareAccountsImprovements(previousAcc:  Set[Account], currentAcc: Set[Account]): Set[(String,String)] = {
//// change map key  account => s"${account.name}-${account.accountType}-${account.openedDate}", true is not needed.
//    val previous: Map[String, Account] = previousAcc.groupBy( account => s"${account.name}-${account.accountType}-${account.openedDate}").map{case (k,v) => (k,v.head)}
//    val current: Map[String, Account] = currentAcc.groupBy(_.name).map{case (k,v) => (k,v.head)}
//
//    val previousToCurrentComparison: Set[(String, String)] = comparison(previous,current,"deleted")
//
//    val currentToPreviousComparison: Set[(String,String)] = comparison(current,previous, "added",true)
//
//    previousToCurrentComparison ++ currentToPreviousComparison
//
//    }
//
//  def comparison(entry1: Map[String, Account], entry2: Map[String, Account],comparisonStatus: String, add : Boolean = false): Set[(String,String)] = {
//
//    entry1.keys.map{
//      previousName =>
//        entry2.get(previousName) match{
//          case Some(currentAccount) if currentAccount.accountType == entry1.get(previousName).head.accountType && !add => (previousName, (currentAccount.balance - entry1.get(previousName).head.balance).toString())
//          case Some(currentAccount) if currentAccount.accountType == entry1.get(previousName).head.accountType && add => (previousName, (entry1.get(previousName).head.balance - currentAccount.balance).toString())
//          case Some(_) => (previousName, comparisonStatus)
//          case None => (previousName, comparisonStatus)
//        }
//    }.toSet
//  }
//
//
//  def main(args: Array[String]): Unit = {
//    val compareAccounts: Set[(String, String)] = compareAccountsImprovements(previousAccounts,currentAccounts)
//
//    compareAccounts.foreach(value => println(s"${value._1}: ${value._2}"))
//  }
//
//}

