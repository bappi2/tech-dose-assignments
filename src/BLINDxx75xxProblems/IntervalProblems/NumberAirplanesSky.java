package BLINDxx75xxProblems.IntervalProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Given an list interval, which are taking off and landing time of the flight. How many airplanes are there at most at the same time in the sky?
Example
Example 1:
Input: [(1, 10), (2, 3), (5, 8), (4, 7)]
Output: 3
Explanation:
The first airplane takes off at 1 and lands at 10.
The second ariplane takes off at 2 and lands at 3.
The third ariplane takes off at 5 and lands at 8.
The forth ariplane takes off at 4 and lands at 7.
During 5 to 6, there are three airplanes in the sky.
Example 2:
Input: [(1, 2), (2, 3), (3, 4)]
Output: 1
Explanation: Landing happen before taking off.
Notice
If landing and taking off of different planes happen at the same time, we consider landing should happen at first.
 */
public class NumberAirplanesSky {
    public int countOfAirplanes(List<Interval> airplanes) {
        if (airplanes == null || airplanes.size() == 0) {
            return 0;
        }

        int max = 0;
        List<Event> events = new ArrayList<>();
        for (Interval airplane : airplanes) {
            events.add(new Event(airplane.start, 0));
            events.add(new Event(airplane.end, 1));
        }

        Collections.sort(events, new MyEventComparator());

        int count = 0;
        for (Event e : events) {
            if (e.flag == 0) {
                count++;
            } else {
                count--;
            }

            max = Math.max(max, count);
        }

        return max;
    }
}

class Event {
    int time;
    int flag; // 0 start 1 end

    public Event(int time, int flag) {
        this.time = time;
        this.flag = flag;
    }
}

class MyEventComparator implements Comparator<Event> {
    @Override
    public int compare(Event a, Event b) {
        if (a.time != b.time) {
            return a.time - b.time;
        }

        return b.flag - a.flag;
    }
}
