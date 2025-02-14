package Day4.BankTranscationSystem;
class Bank{
    private int balance;

    Bank(int balance){
        this.balance=balance;
    }

    public int getBalance(){
        return balance;
    }

    public int withdrawal(int amt)throws InsufficientBalanceException, IllegalArgumentException{
        if(amt>balance){
            throw new InsufficientBalanceException("Insufficient balance");
        }
        if(amt<0){
            throw  new IllegalArgumentException("Invalid amount");
        }
        return  getBalance() - amt;
    }
}
class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException(String message){
        super(message);
    }
}
public class BankTranscationSystem  {
    public static void main(String[] args) throws InsufficientBalanceException {
        Bank bank = new Bank(1000);
        int withdraw = bank.withdrawal(8);
        System.out.println("Withdrawal successful, new balance : " + withdraw);
    }
}
