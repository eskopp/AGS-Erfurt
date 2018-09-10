package semi;

public class Date {
    public static boolean leapyear(int year){
        if (year % 4 == 0 && year % 100 >0 || year % 400 == 0){
            return(true);
    }
        return(false);
    }
    
    public static int lenY(int year){
        if (leapyear(year)){
            return(366);
        }
        return(365);
    }
    
    public static int lenM(int year, int month){
        while(month > 12){
            month -= 12;
            year++;
        }
        if (month < 8 && month % 2 != 0 || month >= 8 && month % 2 == 0){
            return(31);
        }
        if (month == 2 && leapyear(year)){
            return(29);
        }       
        if (month == 2){
            return(28);
        }
        return(30);
    }
    
    public static int numD(int year, int month, int day){
        int d1 = day;
        int d2 = 0;
        for(int i = 1; i < month; i++){
            d2 += lenM(year, i);
        }
        return(d1 + d2);
        
    }
    
    public static int difD(int year, int month, int day, int year2, int month2, int day2){
        int d1 = 0;
        int d2 = 0;
        int d3 = 0;
        
        if (year > year2 || year == year2 && month > month2 || year == year2 && month == month2 && day > day2){
            return(0);    
        }
        
        if (year == year2){
                if (month == month2){
                    return(day2 - day);
                }
                
                if (month + 2 <= month2){
                    for(int i = month + 1; i <= month2; i++){
                        d1 += lenM(year, i);
                    }
                }
                
                d2 = lenM(year, month) - day;
                d3 = day2;
                
                return(d1 + d2 + d3);               
        }    
        if (year + 2 <= year2){
            for(int i = year + 1; i <= year2 - 1; i++){
                d1 += lenY(i);
            }
        }
        
        d2 = lenY(year) - numD(year, month, day);
        d3 = numD(year2, month2, day2);
            
        return(d1 + d2 + d3);
    }
    
    public static double difT(String time1, String time2){
        int hour1 = Integer.valueOf(time1.substring(0, 2));
        int min1 = Integer.valueOf(time1.substring(3));
        int hour2 = Integer.valueOf(time2.substring(0, 2));
        int min2 = Integer.valueOf(time2.substring(3));
        
        int hour = hour2 - hour1;
        int min = min2 - min1;
        
        if (min < 0){
            min = min + 60;
            hour = hour - 1;
        }
        double d = (hour + (min * 1.0 / 60.0)) / 24.0;
        return(Math.round(d * 10000.0) * 1.0 / 10000.0);
    }
    
    public static boolean biggerT(String time1, String time2){
        double hour1 = Integer.valueOf(time1.substring(0, 2));
        double min1 = Integer.valueOf(time1.substring(3));
        
        double hour2 = Integer.valueOf(time2.substring(0, 2));
        double min2 = Integer.valueOf(time2.substring(3));
        
        if (hour1 > hour2 || hour1 == hour2 && min1 > min2){
            return (true);
        }    
        return(false);
    }
    
    public static double t2d(String time){
        double hour = Integer.valueOf(time.substring(0, 2));
        double min = Integer.valueOf(time.substring(3));
        double d = (hour + min / 60) / 24.0;
        return(Math.round(d * 10000.0) * 1.0 / 10000.0);
    }
    
    public static String d2t(double d){
        int min = (int) (d * 24 * 60);
        int hour = 0;
        while (min >= 60){
            min -= 60;
            hour++;
        }
        return(toTime(hour, min));
        
    }
    
    public static String toTime(int h, int m){
        String hour;
        String min;
        if(h < 10){
            hour = "0" + String.valueOf(h);
        }else{
            hour = String.valueOf(h);
        }        
        if(m < 10){
            min = "0" + String.valueOf(m);
        }else{
            min= String.valueOf(m);
        }
        return(hour + ":" + min);
    }
    
    public static String addT(String time1, String time2){
        int hour1 = Integer.valueOf(time1.substring(0, 2));
        int min1 = Integer.valueOf(time1.substring(3));
        int hour2 = Integer.valueOf(time2.substring(0, 2));
        int min2 = Integer.valueOf(time2.substring(3));
        
        int hour = hour1 + hour2;
        int min = min1 + min2;
        if(min >= 60){
            hour++;
            min -= 60;
        }
        return(toTime(hour, min));
    }
    
    public static String avT(String[] t){
        int h = 0;
        int m = 0;
        for(int i = 0; i < t.length; i++ ){
            h += Integer.valueOf(t[i].substring(0, 2));
            m += Integer.valueOf(t[i].substring(3));
        }
        double hour = h * 1.0 / t.length;
        double min = Math.round(m * 1.0 / t.length + ((hour - (int) hour) * 60.0));
        hour = (int) hour;
        return(Date.toTime((int) (hour), (int) min));
    }
    
    public static String[] avD(int[] d, String[] t){
        double days = 0;
        String time;
        for(int i = 0; i < d.length; i++){
            days += d[i];           
        }
        days /= d.length;
        time = addT(avT(t), d2t(days - (int) days));
        int h = Integer.valueOf(time.substring(0, 2));
        if(h >= 24){
            time = toTime(h - 24, Integer.valueOf(time.substring(3, 5)));
            days++;
        }
        String[] e = {String.valueOf((int) days), time};
        return(e);
    }
    
    public static String[] avM(int[] y, int[] m, int[] d, String[] t){
        int smallestM = m[0];
        for(int i = 1; i < m.length; i++){
            if(m[i] < smallestM){
                smallestM = m[i];
            }
        }
        for(int i = 0; i < m.length; i++){
            while(m[i] > smallestM){
                d[i] += lenM(y[i], m[i] - 1);
                m[i]--;
            }
        }
        String[] e1 = avD(d, t);
        while(Integer.valueOf(e1[0]) > lenM(y[0], m[0])){
            e1[0] = String.valueOf(Integer.valueOf(e1[0]) - lenM(y[0], m[0] + 1));
            m[0]++;
        }
        String[] e2 = {String.valueOf(m[0]), e1[0], e1[1]};
        return(e2);
    }
    
    public static String[] avY(int[] y, int[] m, int[] d, String[] t){
        int smallestY = y[0];
        for(int i = 1; i < y.length; i++){
            if(y[i] < smallestY){
                smallestY = y[i];
            }
        }
        for(int i = 0; i < y.length; i++){
            while(y[i] > smallestY){
                m[i] += 12;
                y[i]--;
            }
        }
        String[] e1 = avM(y, m, d, t);
        while(Integer.valueOf(e1[0]) > 12){
            e1[0] = String.valueOf(Integer.valueOf(e1[0]) - 12);
            y[0]++;
        }
        String[] e2 = {String.valueOf(y[0]), e1[0], e1[1], e1[2]};
        return(e2);
    }
}