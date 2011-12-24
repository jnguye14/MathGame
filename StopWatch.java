/*
    Copyright (c) 2005, Corey Goldberg

    StopWatch.java is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.
    Code Found at: http://www.goldb.org/stopwatchjava.html
    
    Dec. 23 2011, Edited by Christopher Jeffery 
*/

public class StopWatch
{
    private long startTime = 0;
    private long stopTime = 0;
    private boolean running = false;
    
    public boolean notRunning()
    {
    	if(running)
    		return false;
    	
    	return true;
    }

    public void start()
    {
        this.startTime = System.currentTimeMillis();
        this.running = true;
    }

    public void stop()
    {
        this.stopTime = System.currentTimeMillis();
        this.running = false;
    }

    //elaspsed time in milliseconds
    public long getElapsedTime()
    {
        long elapsed;
        if (running)
            elapsed = (System.currentTimeMillis() - startTime);
        else
            elapsed = (stopTime - startTime);
        return elapsed;
    }

    //elaspsed time in seconds
    public long getElapsedTimeSecs()
    {
        long elapsed;
        if (running)
            elapsed = ((System.currentTimeMillis() - startTime) / 1000);
        else
            elapsed = ((stopTime - startTime) / 1000);
        return elapsed;
    }
    
    //average time in milliseconds
    public long getAverageTime(int denominator)
    {
    	return getElapsedTime() / denominator;
    }
}