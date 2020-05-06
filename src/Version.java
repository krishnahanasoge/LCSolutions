public class Version {

    public static int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int maxLength = Math.max(split1.length, split2.length);
        for(int i=0;i<maxLength;i++){
            int value1 = split1.length <= i ? 0 : Integer.valueOf(split1[i]);
            int value2 = split2.length <= i ? 0 : Integer.valueOf(split2[i]);
            if(value1 < value2){
                return -1;
            }else if(value1 > value2){
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        compareVersion("0.1", "1.1");
    }
}
