# CoFTimers #


Copyright © 2013 Vikram Ramesh

For more information about the license, please see COPYING.txt

**Name**: Vikram Ramesh

**Contact Information**: vikram132@gmail.com



This is a simple Java project that will pull data about dynamic events from the Guild Wars 2 API,
and determine whether or not various dungeons and temples are open or closed. It works by using the
Guild Wars 2 API to retrieve information server names, map names, and event names. It then uses this
information to determine the status of a temple on the chosen server. More information about the 
Guild Wars 2 API can be found [here](http://wiki.guildwars2.com/wiki/API:Main). In addition to
just retrieving this information, the user will be able to customize what events in particular
they wish to view, and launch only those events in an overlay window.

## Features not yet implemented ##

1. Overlay functionality. 
2. Timers


## To Do ##

1. Improve JSON parsing method by using the gson API
2. Redesign UI to allow the addition of more events to track


## Build Instructions ##

Download the files from [this github](https://github.com/vikram-r/CoFTimers)

Compile using Java 6 or higher. (May work for lower versions, but untested and unstable. Use at own risk)

javac Client.java

java Client



This program is licensed under the GNU GPL. Please see the file COPYING in this distribution for
license terms.
