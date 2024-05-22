package homework2;

public class Process implements Comparable<Process> {
    private String processName;
    private int priority;
    private int burstTime;
    private int arrivalTime;

    public Process(String processName, int priority, int burstTime, int arrivalTime) {
        this.processName = processName;
        this.priority = priority;
        this.burstTime = burstTime;
        this.arrivalTime = arrivalTime;
    }

    public String getProcessName() {
        return processName;
    }

    public int getPriority() {
        return priority;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    @Override
    public int compareTo(Process other) {
        // Compare based on priority first; if equal, then based on arrival time
        if (this.priority == other.priority) {
            return Integer.compare(this.arrivalTime, other.arrivalTime);
        }
        return Integer.compare(this.priority, other.priority);
    }
}
