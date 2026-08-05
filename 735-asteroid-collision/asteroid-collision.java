class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack <Integer> st= new Stack<>();
        int n= asteroids.length;
        st.push(asteroids[0]);
        for(int i=1;i<n;i++){
            int a= asteroids[i];
            if(a>=0){
                st.push(a);
            }else{
                while(true){
                    if(st.isEmpty() || st.peek()<0){
                        st.push(a);
                        break;
                    }
                    int b= st.peek();
                    if(Math.abs(a)>b){
                        st.pop();
                    }else if(Math.abs(a)==b){
                        st.pop();
                        break;
                    }else{
                        break;
                    }

                }
            }
        }
        int[] result= new int[st.size()];
        for(int i=st.size()-1;i>=0;i--){
            result[i]=st.pop();
        }
        return result;
    }
}