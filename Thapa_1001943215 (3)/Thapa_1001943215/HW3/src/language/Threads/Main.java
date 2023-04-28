package language.Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static final String EOF = "EOF";

    public static void main(String[] args) {
	// write your code here
        List< String > buffer = new ArrayList<>( );
        ReentrantLock bufferLock = new ReentrantLock( );

        Thread Producer = new Thread( new language.Threads.Producer( buffer, bufferLock ) );
        Producer.setName( Threadcolor.ANSI_GREEN + "Producer's Thread: " );

        Thread ConsumerOne = new Thread( new language.Threads.Consumer( buffer ) );
        ConsumerOne.setName( Threadcolor.ANSI_BLUE + "Consumer One's Thread: " );

        Thread ConsumerTwo = new Thread( new language.Threads.Consumer( buffer ) );
        ConsumerTwo.setName( Threadcolor.ANSI_CYAN + "Consumer Two's Thread: " );

        Thread ConsumerThree = new Thread( new Consumer( buffer ) );
        ConsumerThree.setName( Threadcolor.ANSI_PURPLE + "Consumer Three's Thread: " );

        Producer.start( );
        ConsumerOne.start( );
        ConsumerTwo.start( );
        ConsumerThree.start( );

    }
}
