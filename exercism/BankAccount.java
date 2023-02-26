package exercism;

class BankAccountActionInvalidException extends Exception {
  BankAccountActionInvalidException(String msg) {
    super(msg);
  }
}

public class BankAccount {

  private boolean isClosed;
  private int balance;

  BankAccount() {
    isClosed = true;
    balance = 0;
  }

  public void open() throws BankAccountActionInvalidException {
    isClosed = false;
  }

  public synchronized int getBalance() throws BankAccountActionInvalidException {
    if (isClosed)
      throw new BankAccountActionInvalidException("Account closed");

    return balance;
  }

  public synchronized void deposit(int amount) throws BankAccountActionInvalidException {
    if (isClosed)
      throw new BankAccountActionInvalidException("Account closed");

    if (amount < 0)
      throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");

    balance += amount;
  }

  public synchronized void withdraw(int amount) throws BankAccountActionInvalidException {

    if (isClosed)
      throw new BankAccountActionInvalidException("Account closed");

    if (balance <= 0)
      throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");

    if (amount < 0)
      throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");

    if (balance < amount)
      throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");

    balance -= amount;

  }

  public void close() {
    isClosed = true;
  }

}
