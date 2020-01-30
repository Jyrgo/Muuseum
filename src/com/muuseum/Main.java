package com.muuseum;

import com.muuseum.personCounter.PersonCounter;

public class Main {

    public static void main(String[] args)  {
        System.out.println(args[0]);
        PersonCounter personCounter = new PersonCounter(args[0]);
        personCounter.mostVisitorsInMuseum();
    }
}
