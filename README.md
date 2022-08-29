Eliminating Race Conditions(Where memory is accessed by two or more threads). Updating the counter variable with the two threads leads to error and using reentrant lock. Reentry lock makes it so that threads wait their turn instead of simultaneously. Locking code eliminates race conditions and enforces thread safety.

CountDownLatch allows a parent thread to await worker threads

Eventually locks were removed and not necessary when 
using Atomic variable. Atomic varibles make threads wait 
just like locks but are easier and cleaner to do.