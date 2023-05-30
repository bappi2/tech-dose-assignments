package InterviewQuestions;

import java.util.Map;
import java.util.TreeMap;

public class BankProblem {
    int [] calculate(int [] balances, String[] requestes) {
        Map<Long, Request> map = new TreeMap<>();
        long[] lastTime = new long[balances.length];

        int i = 1;
        long lastTimestamp = 0;
        for (String incomingReq: requestes) {
            Request request = new Request(incomingReq, i);
            i++;
            map.put(request.timestamp, request);
            lastTimestamp = request.timestamp;
        }
        for (Long timestamp : map.keySet()) {
            Request req = map.get(timestamp);
            if (req.action.equals("deposit")) {
                if (isValidRequest(req, balances)) {
                    balances[req.holderId -1] += req.amount;
                }
            }
            else if (req.action.equals("withdraw")) {
                if (isValidWithdraw(req, balances)) {
                    balances[req.holderId -1] -= req.amount;
                }
                else {
                    return new int []{ -req.reqId};
                }
            }
        }

        return balances;
    }

    private boolean isValidWithdraw(Request req, int[] balances) {
        if (req.holderId >=1 && req.holderId <= balances.length
                && req.amount <= balances[req.holderId -1] ) {
            return true;
        }
        else {
            return false;
        }
    }

    private boolean isValidRequest(Request req, int[] balances) {
        if (req.holderId >=1 && req.holderId <= balances.length) {
            return true;
        }
        else {
            return false;
        }
    }

    class Request {
        int reqId;
        String action;
        long timestamp;
        int holderId;

        int amount;
        public Request(String request, int reqId) {
            this.reqId = reqId;
            String[] split = request.split(" ");
            this.action = split[0];
            this.timestamp = Long.valueOf(split[1]);
            this.holderId = Integer.valueOf(split[2]);
            this.amount = Integer.valueOf(split[3]);
        }
    }

    public static void main(String[] args) {
        int [] balances = new int[] {1000, 1500};
        String[] requests = new String[] {
                "withdraw 1613327630 2 480",
                "withdraw 1613327644 2 800"
        };
        BankProblem bp = new BankProblem();
        bp.calculate(balances, requests);


    }
}
