class Solution {
    public double angleClock(int hour, int minutes) {
        double minAngle= minutes * 6;
        double hrAngle;
        if(hour==12){
            hrAngle= (double)minutes* 0.5;
        }else{
            hrAngle= (hour * 60 + (double) minutes) * 0.5;
        }
        double angle= Math.abs(minAngle- hrAngle);
        double result = Math.min(angle, 360- angle);
        return result;
    }
}