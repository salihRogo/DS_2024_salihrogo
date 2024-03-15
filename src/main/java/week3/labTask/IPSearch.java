package week3.labTask;

public class IPSearch {
    public static IPAddress search(IPAddress[] ipAddresses, String ipAddress) {
        // replace the method body with your code

        long searchedIP = convertToIPNumber(ipAddress);

        int low = 0;
        int high = ipAddresses.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (searchedIP < ipAddresses[mid].getStartIp()) {
                high = mid - 1;
            } else if (searchedIP > ipAddresses[mid].getEndIp()) {
                low = mid + 1;
            } else {
                return ipAddresses[mid];
            }
        }
        return null;

    }

    public static long convertToIPNumber(String IPAddress) {
        String[] splited = new String[IPAddress.length() - 1];
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        for (Character c : IPAddress.toCharArray()) {
            if (c.equals('.')) {
                splited[i] = sb.toString();
                i++;
                sb = new StringBuilder();
            } else if (j == IPAddress.length() - 1){
                sb.append(c);
                splited[i] = sb.toString();
            } else {
                sb.append(c);
            }
            j++;
        }

        return (16777216L * Integer.parseInt(splited[0])) + (65536L * Integer.parseInt(splited[1])) + (256L * Integer.parseInt(splited[2])) + Integer.parseInt(splited[3]);
    }
}
