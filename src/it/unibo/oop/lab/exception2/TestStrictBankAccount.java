package it.unibo.oop.lab.exception2;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * JUnit test to test
 * {@link StrictBankAccount}.
 * 
 */
public final class TestStrictBankAccount {

    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
    @Test
    public void testBankOperations() {
        /*
         * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a
         * scelta, con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
         * 
         * 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in
         * presenza di un id utente errato, oppure al superamento del numero di
         * operazioni ATM gratuite.
         */
    	
    	BankAccount firstAccount = new StrictBankAccount(1, 10_000, 10);
    	BankAccount secondAccount = new StrictBankAccount(2, 10_000, 10);
    	
    	try {
    		firstAccount.deposit(5, 1_000);
    		fail("[USER ID WRONG, FAIL]");
    	} catch(WrongAccountHolderException e) {
    		assertNotNull("[CHECKING WRONG ACCOUNT HOLDER EXCEPTION]", e.getMessage());
    	}
    	
    	try {
    		secondAccount.withdraw(2, 100_000);
    		fail("[AMOUNT NOT AVAILABLE, FAIL]");
    	} catch(NotEnoughFoundsException e) {
    		assertNotNull("[CHECKING NOT ENOUGH FOUNDS EXCEPTION]", e.getMessage());
    	} catch(WrongAccountHolderException e) {
    		assertNotNull("[CHECKING WRONG ACCOUNT HOLDER EXCEPTION]", e.getMessage());
    	}
    	
    }
}
